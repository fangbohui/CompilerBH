package AST.Expression.UnaryExpression;

import AST.Expression.Expression;
import AST.Type.Type;

/**
 * Created by fangbohui on 17-4-2.
 */
public class UnaryExpression extends Expression {
	public Expression expression;

	public UnaryExpression(Type type, Boolean isLeftValue, Expression expression) {
		super(type, isLeftValue);
		this.expression = expression;
	}
}
