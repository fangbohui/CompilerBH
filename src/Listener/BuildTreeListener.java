package Listener;

import AST.Expression.BinaryExpression.*;
import AST.Expression.ConstantExpression.BoolConstant;
import AST.Expression.ConstantExpression.IntConstant;
import AST.Expression.ConstantExpression.NullConstant;
import AST.Expression.ConstantExpression.StringConstant;
import AST.Expression.Expression;
import AST.Expression.FunctionCallExpression;
import AST.Expression.NewExpression;
import AST.Expression.UnaryExpression.*;
import AST.Expression.VarExpression.FieldExpression;
import AST.Expression.VarExpression.IdenExpression;
import AST.Expression.VarExpression.IndexExpression;
import AST.Function;
import AST.Statement.*;
import AST.Statement.LoopStatement.ForStatement;
import AST.Statement.LoopStatement.WhileStatement;
import AST.Type.ClassType;
import AST.Type.MemberClass.Member;
import AST.Type.MemberClass.MemberVar;
import AST.Type.Type;
import Error.CompileError;
import Environment.*;
import Parser.MomoParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by fangbohui on 17-4-3.
 */
public class BuildTreeListener extends BaseListener {
	@Override
	public void exitProgram(MomoParser.ProgramContext ctx) {
		ctx.varDefinition().forEach(statementContext -> {
			VarStatement varDefinitionStatement = (VarStatement) propertyTree.get(statementContext);
			Environment.program.addVarDefinition(varDefinitionStatement);
		});
	}

	@Override
	public void enterFunctionDefinition(MomoParser.FunctionDefinitionContext ctx) {
		Function function = (Function) propertyTree.get(ctx);
		Environment.enterScope(function);
	}

	@Override
	public void exitFunctionDefinition(MomoParser.FunctionDefinitionContext ctx) {
		Function function = (Function) propertyTree.get(ctx);
		function.addStatement((BlockStatement) propertyTree.get(ctx.blockStatement()));
		Environment.exitScope();
		if (function.name.equals("main")) {
			Environment.hasMain = true;
		}
	}

	@Override
	public void enterClassDefinition(MomoParser.ClassDefinitionContext ctx) {
		ClassType classType = (ClassType) propertyTree.get(ctx);
		Environment.enterScope(classType);
		classType.memberVarMap.forEach((name, member) -> {
			if (name.equals("this")) {
				throw new CompileError("you cannot use 'this' as a member-var name");
			}
			Environment.symbolTable.add(name, member.type);
		});
		classType.memberFunctionMap.forEach((name, member) -> {
			if (name.equals("this")) {
				throw new CompileError("you cannot use 'this' as a member-var name");
			}
			Environment.symbolTable.add(name, member.function);
		});
	}

	@Override
	public void exitClassDefinition(MomoParser.ClassDefinitionContext ctx) {
		ClassType classType = (ClassType) propertyTree.get(ctx);
		ctx.varDefinition().forEach(varDefinitionContext -> {
			String name = varDefinitionContext.IDEN().getText();
			if (varDefinitionContext.expression() != null) {
				Member member = classType.getMember(name);
				if (member instanceof MemberVar) {
					MemberVar memberVar = (MemberVar)member;
					memberVar.expression = (Expression)propertyTree.get(varDefinitionContext.expression());
				}
			}
		});
		Environment.exitScope();
	}

	@Override
	public void enterStatement(MomoParser.StatementContext ctx) {
		if (ctx.parent instanceof MomoParser.ConditionStatementContext) {
			Environment.enterScope(null);
		}
	}

	@Override
	public void exitStatement(MomoParser.StatementContext ctx) {
		if (ctx.parent instanceof MomoParser.ConditionStatementContext) {
			Environment.exitScope();
		}
		propertyTree.put(ctx, propertyTree.get(ctx.getChild(0)));
	}

	@Override
	public void enterBlockStatement(MomoParser.BlockStatementContext ctx) {
		BlockStatement blockStatement = (BlockStatement)BlockStatement.getStatement();
		Environment.enterScope(blockStatement);
		if (ctx.parent instanceof MomoParser.FunctionDefinitionContext) {
			Function function = (Function)propertyTree.get(ctx.parent);
			for (int i = 0; i < function.parameters.size(); i ++) {
				Symbol parameter = function.parameters.get(i);
				function.parameters.set(i, Environment.symbolTable.add(parameter.name, parameter.type));
			}
		}
		propertyTree.put(ctx, blockStatement);
	}

	@Override
	public void exitBlockStatement(MomoParser.BlockStatementContext ctx) {
		ctx.statement().forEach(statementContext -> {
			((BlockStatement)propertyTree.get(ctx)).addStatement((Statement) propertyTree.get(statementContext));
		});
		Environment.exitScope();
	}

	@Override
	public void exitExpressionStatement(MomoParser.ExpressionStatementContext ctx) {
		propertyTree.put(ctx, ExpressionStatement.getStatement((Expression) propertyTree.get(ctx.expression())));
	}

	@Override
	public void exitConditionStatement(MomoParser.ConditionStatementContext ctx) {
		propertyTree.put(ctx, IfStatement.getStatement(
				(Expression) propertyTree.get(ctx.expression()),
				(Statement) propertyTree.get(ctx.statement(0)),
				(Statement) propertyTree.get(ctx.statement(1))
		));
	}

	@Override
	public void enterWhileStatement(MomoParser.WhileStatementContext ctx) {
		WhileStatement whileStatement = (WhileStatement) WhileStatement.getStatement();
		Environment.enterScope(whileStatement);
		propertyTree.put(ctx, whileStatement);
	}

	@Override
	public void exitWhileStatement(MomoParser.WhileStatementContext ctx) {
		WhileStatement whileStatement = (WhileStatement)propertyTree.get(ctx);
		whileStatement.addCondition((Expression) propertyTree.get(ctx.expression()));
		whileStatement.addStatement((Statement) propertyTree.get(ctx.statement()));
		Environment.exitScope();
	}

	@Override
	public void enterForStatement(MomoParser.ForStatementContext ctx) {
		ForStatement forStatement = (ForStatement)ForStatement.getStatement();
		Environment.enterScope(forStatement);
		propertyTree.put(ctx, forStatement);
	}

	@Override
	public void exitForStatement(MomoParser.ForStatementContext ctx) {
		ForStatement forStatement = (ForStatement) propertyTree.get(ctx);
		int semi = 0;
		for (ParseTree parseTree : ctx.children) {
			if (parseTree.getText().equals(";")) {
				semi += 1;
			}
			if (parseTree instanceof MomoParser.ExpressionContext) {
				Expression expression = (Expression)propertyTree.get(parseTree);
				if (semi == 0) {
					forStatement.addInit(expression);
				} else if (semi == 1) {
					forStatement.addCondition(expression);
				} else if (semi == 2) {
					forStatement.addInc(expression);
				} else {
					throw new CompileError("you're having too many ';'");
				}
			}
		}
		Environment.exitScope();
	}

	@Override
	public void exitContinueStatement(MomoParser.ContinueStatementContext ctx) {
		propertyTree.put(ctx, ContinueStatement.getStatement());
	}

	@Override
	public void exitBreakStatement(MomoParser.BreakStatementContext ctx) {
		propertyTree.put(ctx, BreakStatement.getStatement());
	}

	@Override
	public void exitReturnStatement(MomoParser.ReturnStatementContext ctx) {
		Expression expression = (Expression) propertyTree.get(ctx.expression());
		propertyTree.put(ctx, ReturnStatement.getStatement(expression));
	}

	@Override
	public void exitVarDefinition(MomoParser.VarDefinitionContext ctx) {
		if (!(ctx.parent instanceof MomoParser.ClassDefinitionContext)) {
			Type type = (Type) propertyTree.get(ctx.type());
			String name = ctx.IDEN().getText();
			if (name.equals("this")) {
				throw new CompileError("you cannot use this as a name");
			}
			Symbol symbol = Environment.symbolTable.add(name, type);
			Expression expression = (Expression) propertyTree.get(ctx.expression());
			propertyTree.put(ctx, VarStatement.getStatement(symbol, expression));
		}
	}

	@Override
	public void exitConstantExpression(MomoParser.ConstantExpressionContext ctx) {
		propertyTree.put(ctx, propertyTree.get(ctx.constant()));
	}

	@Override
	public void exitIdenExpression(MomoParser.IdenExpressionContext ctx) {
		propertyTree.put(ctx, IdenExpression.getExpression(ctx.getText()));
	}

	@Override
	public void exitFieldExpression(MomoParser.FieldExpressionContext ctx) {
		propertyTree.put(ctx, FieldExpression.getExpression(
				(Expression) propertyTree.get(ctx.expression()), ctx.IDEN().getText())
		);
	}

	@Override
	public void exitIndexExpression(MomoParser.IndexExpressionContext ctx) {
		propertyTree.put(ctx, IndexExpression.getExpression(
				(Expression)propertyTree.get(ctx.expression(0)),
				(Expression)propertyTree.get(ctx.expression(1))
		));
	}

	@Override
	public void exitSubExpression(MomoParser.SubExpressionContext ctx) {
		propertyTree.put(ctx, propertyTree.get(ctx.expression()));
	}

	@Override
	public void exitPostfixExpression(MomoParser.PostfixExpressionContext ctx) {
		Expression expression = (Expression) propertyTree.get(ctx.expression());
		if (ctx.operator.getText().equals("++")) {
			propertyTree.put(ctx, SucIncExpression.getExpression(expression));
		} else {
			propertyTree.put(ctx, SucDecExpression.getExpression(expression));
		}
	}

	@Override
	public void exitUnaryExpression(MomoParser.UnaryExpressionContext ctx) {
		Expression expression = (Expression) propertyTree.get(ctx.expression());
		if (ctx.operator.getText().equals("+")) {
			propertyTree.put(ctx, UnaryAddExpression.getExpression(expression));
		} else if (ctx.operator.getText().equals("-")) {
			propertyTree.put(ctx, UnaryMinusExpression.getExpression(expression));
		} else if (ctx.operator.getText().equals("!")) {
			propertyTree.put(ctx, BoolNotExpression.getExpression(expression));
		} else if (ctx.operator.getText().equals("~")) {
			propertyTree.put(ctx, IntNotExpression.getExpression(expression));
		} else if (ctx.operator.getText().equals("++")) {
			propertyTree.put(ctx, PreIncExpression.getExpression(expression));
		} else if (ctx.operator.getText().equals("--")) {
			propertyTree.put(ctx, PreDecExpression.getExpression(expression));
		}
	}

	@Override
	public void exitFunctionExpression(MomoParser.FunctionExpressionContext ctx) {
		Expression expression = (Expression) propertyTree.get(ctx.expression(0));
		List<Expression> parameters = new ArrayList<>();
		ClassType classType = Environment.scopeTable.classTypeTop();
		/*
		if (classType != null) {
			parameters.add();
		}
		*/
		for (int i = 1; i < ctx.expression().size(); i ++) {
			Expression parameter = (Expression) propertyTree.get(ctx.expression(i));
			parameters.add(parameter);
		}
		propertyTree.put(ctx, FunctionCallExpression.getExpression(expression, parameters));
	}

	@Override
	public void exitNewExpression(MomoParser.NewExpressionContext ctx) {
		boolean hasEmpty = false;
		String last = "FBH";
		List<Expression> dimensionExpressions = new ArrayList<>();
		for (ParseTree parseTree : ctx.children) {
			if (parseTree instanceof MomoParser.ExpressionContext) {
				if (hasEmpty) {
					throw new CompileError("you cannot ask for an array in that way");
				}
				dimensionExpressions.add((Expression) propertyTree.get(parseTree));
			} else if (parseTree.getText().equals("]")) {
				if (last.equals("[")) {
					hasEmpty = true;
					dimensionExpressions.add(null);
				}
			}
			last = parseTree.getText();
		}
		Type baseType = (Type) propertyTree.get(ctx.type());
		propertyTree.put(ctx, NewExpression.getExpression(baseType, dimensionExpressions));
	}

	@Override
	public void exitMultiExpression(MomoParser.MultiExpressionContext ctx) {
		Expression expression1 = (Expression) propertyTree.get(ctx.expression(0));
		Expression expression2 = (Expression) propertyTree.get(ctx.expression(1));
		if (ctx.operator.getText().equals("*")) {
			propertyTree.put(ctx, MultiExpression.getExpression(expression1, expression2));
		} else if (ctx.operator.getText().equals("/")) {
			propertyTree.put(ctx, DivideExpression.getExpression(expression1, expression2));
		} else if (ctx.operator.getText().equals("%")) {
			propertyTree.put(ctx, ModExpression.getExpression(expression1, expression2));
		}
	}

	@Override
	public void exitAddExpression(MomoParser.AddExpressionContext ctx) {
		Expression expression1 = (Expression) propertyTree.get(ctx.expression(0));
		Expression expression2 = (Expression) propertyTree.get(ctx.expression(1));
		if (ctx.operator.getText().equals("+")) {
			propertyTree.put(ctx, AddExpression.getExpression(expression1, expression2));
		} else if (ctx.operator.getText().equals("-")) {
			propertyTree.put(ctx, MinusExpression.getExpression(expression1, expression2));
		}
	}

	@Override
	public void exitShiftExpression(MomoParser.ShiftExpressionContext ctx) {
		Expression expression1 = (Expression) propertyTree.get(ctx.expression(0));
		Expression expression2 = (Expression) propertyTree.get(ctx.expression(1));
		if (ctx.operator.getText().equals("<<")) {
			propertyTree.put(ctx, LeftShiftExpression.getExpression(expression1, expression2));
		} else if (ctx.operator.getText().equals(">>")) {
			propertyTree.put(ctx, RightShiftExpression.getExpression(expression1, expression2));
		}
	}

	@Override
	public void exitCmpExpression(MomoParser.CmpExpressionContext ctx) {
		Expression expression1 = (Expression) propertyTree.get(ctx.expression(0));
		Expression expression2 = (Expression) propertyTree.get(ctx.expression(1));
		if (ctx.operator.getText().equals(">")) {
			propertyTree.put(ctx, GreaterExpression.getExpression(expression1, expression2));
		} else if (ctx.operator.getText().equals(">=")) {
			propertyTree.put(ctx, GreaterEqualExpression.getExpression(expression1, expression2));
		} else if (ctx.operator.getText().equals("<")) {
			propertyTree.put(ctx, SmallerExpression.getExpression(expression1, expression2));
		} else if (ctx.operator.getText().equals("<=")) {
			propertyTree.put(ctx, SmallerEqualExpression.getExpression(expression1, expression2));
		}
	}

	@Override
	public void exitEqualExpression(MomoParser.EqualExpressionContext ctx) {
		Expression expression1 = (Expression) propertyTree.get(ctx.expression(0));
		Expression expression2 = (Expression) propertyTree.get(ctx.expression(1));
		if (ctx.operator.getText().equals("==")) {
			propertyTree.put(ctx, EqualToExpression.getExpression(expression1, expression2));
		} else if (ctx.operator.getText().equals("!=")) {
			propertyTree.put(ctx, NotEqualToExpression.getExpression(expression1, expression2));
		}
	}

	@Override
	public void exitBitExpression(MomoParser.BitExpressionContext ctx) {
		Expression expression1 = (Expression) propertyTree.get(ctx.expression(0));
		Expression expression2 = (Expression) propertyTree.get(ctx.expression(1));
		if (ctx.operator.getText().equals("&")) {
			propertyTree.put(ctx, AndExpression.getExpression(expression1, expression2));
		} else if (ctx.operator.getText().equals("|")) {
			propertyTree.put(ctx, OrExpression.getExpression(expression1, expression2));
		} else if (ctx.operator.getText().equals("^")) {
			propertyTree.put(ctx, XorExpression.getExpression(expression1, expression2));
		}
	}

	@Override
	public void exitLogicExpression(MomoParser.LogicExpressionContext ctx) {
		Expression expression1 = (Expression) propertyTree.get(ctx.expression(0));
		Expression expression2 = (Expression) propertyTree.get(ctx.expression(1));
		if (ctx.operator.getText().equals("&&")) {
			propertyTree.put(ctx, LogicAndExpression.getExpression(expression1, expression2));
		} else if (ctx.operator.getText().equals("||")) {
			propertyTree.put(ctx, LogicOrExpression.getExpression(expression1, expression2));
		}
	}

	@Override
	public void exitAssignExpression(MomoParser.AssignExpressionContext ctx) {
		Expression leftValue = (Expression) propertyTree.get(ctx.expression(0));
		Expression rightValue = (Expression) propertyTree.get(ctx.expression(1));
		propertyTree.put(ctx, AssignExpression.getExpression(leftValue, rightValue));
	}

	@Override
	public void exitTrueConstant(MomoParser.TrueConstantContext ctx) {
		propertyTree.put(ctx, BoolConstant.getConstant(true));
	}

	@Override
	public void exitFalseConstant(MomoParser.FalseConstantContext ctx) {
		propertyTree.put(ctx, BoolConstant.getConstant(false));
	}

	@Override
	public void exitIntConstant(MomoParser.IntConstantContext ctx) {
		propertyTree.put(ctx, IntConstant.getConstant(Integer.valueOf(ctx.getText())));
	}

	@Override
	public void exitStringConstant(MomoParser.StringConstantContext ctx) {
		propertyTree.put(ctx, StringConstant.getConstant(ctx.getText().substring(1, ctx.getText().length() - 1)));
	}

	@Override
	public void exitNullConstant(MomoParser.NullConstantContext ctx) {
		propertyTree.put(ctx, NullConstant.getConstant());
	}


}
