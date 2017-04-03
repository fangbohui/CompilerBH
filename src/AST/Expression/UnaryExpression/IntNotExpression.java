package AST.Expression.UnaryExpression;

import Error.CompileError;
import AST.Expression.Expression;
import AST.Type.BasicType.IntType;
import AST.Type.Type;
import AST.Expression.ConstantExpression.*;

/**
 * Created by fangbohui on 17-4-2.
 */
public class IntNotExpression extends UnaryExpression {
	private IntNotExpression(Type type, Boolean isLV, Expression expression) {
		super(type, isLV, expression);
	}
	public static Expression getExpression(Expression expression) {
		if (expression.type instanceof IntType) {
			if (expression instanceof IntConstant) {
				int literal = ((IntConstant)expression).value;
				return IntConstant.getConstant(~literal);
			}
			return new IntNotExpression(IntType.getType(), false, expression);
		}
		throw new CompileError("you should't do an int_not to a non_int type");
	}
}
