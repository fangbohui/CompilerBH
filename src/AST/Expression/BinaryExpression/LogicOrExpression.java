package AST.Expression.BinaryExpression;

import AST.Expression.ConstantExpression.BoolConstant;
import AST.Expression.Expression;
import AST.Type.BasicType.BoolType;
import AST.Type.Type;
import Error.CompileError;

/**
 * Created by fangbohui on 17-4-3.
 */
public class LogicOrExpression extends BinaryExpression {
	private LogicOrExpression(Type type, boolean isLV, Expression leftExpression, Expression rightExpression) {
		super(type, isLV, leftExpression, rightExpression);
	}

	public static Expression getExpression(Expression leftExpression, Expression rightExpression) {
		if (leftExpression.type instanceof BoolType && rightExpression.type instanceof BoolType) {
			if (leftExpression instanceof BoolConstant && rightExpression instanceof BoolConstant) {
				boolean v1 = ((BoolConstant) leftExpression).value;
				boolean v2 = ((BoolConstant) rightExpression).value;
				return BoolConstant.getConstant(v1 || v2);
			}
			return new LogicOrExpression(BoolType.getType(), false, leftExpression, rightExpression);
		}
		throw new CompileError("you are doing '||' on 2 different types");
	}
}
