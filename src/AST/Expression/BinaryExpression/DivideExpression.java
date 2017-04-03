package AST.Expression.BinaryExpression;

import AST.Expression.ConstantExpression.IntConstant;
import AST.Expression.Expression;
import AST.Type.BasicType.IntType;
import AST.Type.Type;
import Error.CompileError;

/**
 * Created by fangbohui on 17-4-2.
 */
public class DivideExpression extends BinaryExpression {
	private DivideExpression(Type type, Boolean isLV, Expression leftExpression, Expression rightExpression) {
		super(type, isLV, leftExpression, rightExpression);
	}
	public static Expression getExpression(Expression leftExpression, Expression rightExpression) {
		if (leftExpression.type instanceof IntType && rightExpression.type instanceof IntType) {
			if (leftExpression instanceof IntConstant && rightExpression instanceof IntConstant) {
				int v1 = ((IntConstant) leftExpression).value;
				int v2 = ((IntConstant) rightExpression).value;
				return IntConstant.getConstant(v1 / v2);
			}
			return new DivideExpression(IntType.getType(), false, leftExpression, rightExpression);
		}
		throw new CompileError("- should between int");
	}
}
