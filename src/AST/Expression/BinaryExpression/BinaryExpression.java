package AST.Expression.BinaryExpression;

import AST.Expression.Expression;
import AST.Type.Type;

/**
 * Created by fangbohui on 17-4-2.
 */
public class BinaryExpression extends Expression {
	public Expression leftExpression;
	public Expression rightExpression;
	protected BinaryExpression(Type type, Boolean isLV, Expression leftExpression, Expression rightExpression) {
		super(type, isLV);
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}
}
