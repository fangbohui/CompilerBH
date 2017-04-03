package AST.Statement;

import AST.Expression.Expression;

/**
 * Created by fangbohui on 17-4-2.
 */
public class ExpressionStatement extends Statement {
	public Expression expression;

	private ExpressionStatement(Expression expression) {
		this.expression = expression;
	}

	public static Statement getStatement(Expression expression) {
		return new ExpressionStatement(expression);
	}
}
