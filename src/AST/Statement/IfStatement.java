package AST.Statement;

import AST.Expression.ConstantExpression.BoolConstant;
import Error.CompileError;
import AST.Expression.Expression;
import AST.Type.BasicType.BoolType;

/**
 * Created by fangbohui on 17-4-2.
 */
public class IfStatement extends Statement {
	public Expression condition;
	public Statement positiveStatement, negativeStatement;

	private IfStatement(Expression condition, Statement positiveStatement, Statement negativeStatement) {
		this.condition = condition;
		this.positiveStatement = positiveStatement;
		this.negativeStatement = negativeStatement;
	}

	public static Statement getStatement(Expression condition, Statement positiveStatement, Statement negativeStatement) {
		if (condition instanceof BoolConstant) {
			if (((BoolConstant)condition).value) {
				return positiveStatement;
			} else {
				return negativeStatement;
			}
		}
		if (condition.type instanceof BoolType) {
			return new IfStatement(condition, positiveStatement, negativeStatement);
		}
		throw new CompileError("If-condition should be a bool");
	}
}
