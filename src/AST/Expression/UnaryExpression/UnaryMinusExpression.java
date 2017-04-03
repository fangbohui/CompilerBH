package AST.Expression.UnaryExpression;

import AST.Expression.ConstantExpression.IntConstant;
import AST.Expression.Expression;
import AST.Type.BasicType.IntType;
import AST.Type.Type;
import Error.CompileError;

/**
 * Created by fangbohui on 17-4-2.
 */
public class UnaryMinusExpression extends UnaryExpression {
	private UnaryMinusExpression(Type type, Boolean isLV, Expression expression) {
		super(type, isLV, expression);
	}
	public static Expression getExpression(Expression expression) {
		if (!(expression.type instanceof IntType)) {
			throw new CompileError("-X should be a int");
		}
		if (expression instanceof IntConstant) {
			int value = ((IntConstant) expression).value;
			return IntConstant.getConstant(-value);
		}
		return new UnaryMinusExpression(IntType.getType(), false, expression);
	}
}
