package AST.Expression.BinaryExpression;

import AST.Expression.ConstantExpression.BoolConstant;
import AST.Expression.ConstantExpression.IntConstant;
import AST.Expression.ConstantExpression.StringConstant;
import AST.Expression.Expression;
import AST.Type.BasicType.BoolType;
import AST.Type.BasicType.IntType;
import AST.Type.BasicType.StringType;
import AST.Type.Type;
import Error.CompileError;

/**
 * Created by fangbohui on 17-4-2.
 */
public class SmallerExpression extends BinaryExpression {
	private SmallerExpression(Type type, Boolean isLV, Expression leftExpression, Expression rightExpression) {
		super(type, isLV, leftExpression, rightExpression);
	}
	public static Expression getExpression(Expression leftExpression, Expression rightExpression) {
		if (leftExpression.type instanceof IntType && rightExpression.type instanceof IntType) {
			if (leftExpression instanceof IntConstant && rightExpression instanceof IntConstant) {
				int v1 = ((IntConstant) leftExpression).value;
				int v2 = ((IntConstant) rightExpression).value;
				return BoolConstant.getConstant(v1 < v2);
			} else {
				return new SmallerExpression(BoolType.getType(), false, leftExpression, rightExpression);
			}
		} else if (leftExpression.type instanceof StringType && rightExpression.type instanceof StringType) {
			if (leftExpression instanceof StringConstant && rightExpression instanceof StringConstant) {
				String s1 = ((StringConstant) leftExpression).value;
				String s2 = ((StringConstant) rightExpression).value;
				return BoolConstant.getConstant(s1.compareTo(s2) < 0);
			} else {
				return new SmallerExpression(BoolType.getType(), false, leftExpression, rightExpression);
			}
		}
		throw new CompileError("> is between strings and ints");
	}
}
