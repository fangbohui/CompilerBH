// Generated from /home/xzj/下载/fangbohui-compiler2017bh-56b699b20866/src/Parser/Momo.g4 by ANTLR 4.7
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MomoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MomoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MomoParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MomoParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MomoParser#classDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDefinition(MomoParser.ClassDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MomoParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(MomoParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MomoParser#varDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefinition(MomoParser.VarDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MomoParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MomoParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MomoParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(MomoParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MomoParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MomoParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MomoParser#conditionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionStatement(MomoParser.ConditionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link MomoParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MomoParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link MomoParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MomoParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link MomoParser#controlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(MomoParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link MomoParser#controlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(MomoParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link MomoParser#controlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MomoParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constantExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(MomoParser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shiftExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(MomoParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(MomoParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpression(MomoParser.AssignExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(MomoParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idenExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdenExpression(MomoParser.IdenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpression(MomoParser.AddExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cmpExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmpExpression(MomoParser.CmpExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitExpression(MomoParser.BitExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiExpression(MomoParser.MultiExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpression(MomoParser.LogicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldExpression(MomoParser.FieldExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpression(MomoParser.IndexExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(MomoParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualExpression(MomoParser.EqualExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpression(MomoParser.SubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExpression}
	 * labeled alternative in {@link MomoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(MomoParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(MomoParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(MomoParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(MomoParser.StringTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidType(MomoParser.VoidTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(MomoParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classType}
	 * labeled alternative in {@link MomoParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(MomoParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueConstant}
	 * labeled alternative in {@link MomoParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueConstant(MomoParser.TrueConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseConstant}
	 * labeled alternative in {@link MomoParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseConstant(MomoParser.FalseConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intConstant}
	 * labeled alternative in {@link MomoParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntConstant(MomoParser.IntConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringConstant}
	 * labeled alternative in {@link MomoParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstant(MomoParser.StringConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullConstant}
	 * labeled alternative in {@link MomoParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullConstant(MomoParser.NullConstantContext ctx);
}