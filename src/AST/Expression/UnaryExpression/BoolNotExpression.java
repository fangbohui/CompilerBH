package AST.Expression.UnaryExpression;

import AST.Expression.ConstantExpression.BoolConstant;
import AST.Expression.Expression;
import AST.Type.BasicType.BoolType;
import AST.Type.Type;
import Error.CompileError;

/**
 * Created by fangbohui on 17-4-2.
 */
public class BoolNotExpression extends UnaryExpression {

	private BoolNotExpression(Type type, boolean isLV, Expression expression) {
		super(type, isLV, expression);
	}

	public static Expression getExpression(Expression expression) {
		if (expression.type instanceof BoolType) {
			if (expression instanceof BoolConstant) {
				boolean value = ((BoolConstant)expression).value;
				return BoolConstant.getConstant(!value);
			}
			return new BoolNotExpression(BoolType.getType(), false, expression);
		}
		throw new CompileError("wrong type of BOOL_NOT");
	}

}
