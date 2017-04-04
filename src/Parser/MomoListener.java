// Generated from /home/fangbohui/IdeaProjects/compiler2017bh/src/Parser/Momo.g4 by ANTLR 4.6
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MomoParser}.
 */
public interface MomoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MomoParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MomoParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MomoParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MomoParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MomoParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(MomoParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MomoParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(MomoParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MomoParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(MomoParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MomoParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(MomoParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MomoParser#varDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVarDefinition(MomoParser.VarDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MomoParser#varDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVarDefinition(MomoParser.VarDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MomoParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MomoParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MomoParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MomoParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MomoParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(MomoParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MomoParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(MomoParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MomoParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MomoParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MomoParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MomoParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MomoParser#conditionStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionStatement(MomoParser.ConditionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MomoParser#conditionStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionStatement(MomoParser.ConditionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link MomoParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MomoParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link MomoParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MomoParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link MomoParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MomoParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link MomoParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MomoParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link MomoParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(MomoParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link MomoParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(MomoParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link MomoParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(MomoParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link MomoParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(MomoParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link MomoParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MomoParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link MomoParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MomoParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(MomoParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(MomoParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(MomoParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(MomoParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(MomoParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(MomoParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(MomoParser.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(MomoParser.AssignExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(MomoParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(MomoParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idenExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdenExpression(MomoParser.IdenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idenExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdenExpression(MomoParser.IdenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(MomoParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(MomoParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cmpExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCmpExpression(MomoParser.CmpExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cmpExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCmpExpression(MomoParser.CmpExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpression(MomoParser.ThisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpression(MomoParser.ThisExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBitExpression(MomoParser.BitExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBitExpression(MomoParser.BitExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiExpression(MomoParser.MultiExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiExpression(MomoParser.MultiExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpression(MomoParser.LogicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpression(MomoParser.LogicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fieldExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFieldExpression(MomoParser.FieldExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fieldExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFieldExpression(MomoParser.FieldExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpression(MomoParser.IndexExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpression(MomoParser.IndexExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(MomoParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(MomoParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualExpression(MomoParser.EqualExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualExpression(MomoParser.EqualExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubExpression(MomoParser.SubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubExpression(MomoParser.SubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(MomoParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(MomoParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(MomoParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(MomoParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(MomoParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(MomoParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 */
	void enterStringType(MomoParser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 */
	void exitStringType(MomoParser.StringTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(MomoParser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(MomoParser.VoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(MomoParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(MomoParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 */
	void enterClassType(MomoParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 */
	void exitClassType(MomoParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueConstant}
	 * labeled alternative in {@link MomoParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterTrueConstant(MomoParser.TrueConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueConstant}
	 * labeled alternative in {@link MomoParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitTrueConstant(MomoParser.TrueConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseConstant}
	 * labeled alternative in {@link MomoParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterFalseConstant(MomoParser.FalseConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseConstant}
	 * labeled alternative in {@link MomoParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitFalseConstant(MomoParser.FalseConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intConstant}
	 * labeled alternative in {@link MomoParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterIntConstant(MomoParser.IntConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intConstant}
	 * labeled alternative in {@link MomoParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitIntConstant(MomoParser.IntConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringConstant}
	 * labeled alternative in {@link MomoParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterStringConstant(MomoParser.StringConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringConstant}
	 * labeled alternative in {@link MomoParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitStringConstant(MomoParser.StringConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullConstant}
	 * labeled alternative in {@link MomoParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterNullConstant(MomoParser.NullConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullConstant}
	 * labeled alternative in {@link MomoParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitNullConstant(MomoParser.NullConstantContext ctx);
}