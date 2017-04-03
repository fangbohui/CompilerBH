package AST.Expression.UnaryExpression;

import AST.Expression.Expression;
import AST.Type.BasicType.IntType;
import AST.Type.Type;
import Error.CompileError;

/**
 * Created by fangbohui on 17-4-2.
 */
public class PreIncExpression extends UnaryExpression {
	private PreIncExpression(Type type, Boolean isLV, Expression expression) {
		super(type, isLV, expression);
	}
	public static Expression getExpression(Expression expression) {
		if (!expression.isLeftValue) {
			throw new CompileError("++X should be a left value");
		}
		if (!(expression.type instanceof IntType)) {
			throw new CompileError("++X should be a int");
		}
		return new PreIncExpression(IntType.getType(), false, expression);
	}
}
