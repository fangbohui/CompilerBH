package AST.Expression.BinaryExpression;

import AST.Expression.ConstantExpression.BoolConstant;
import AST.Expression.ConstantExpression.IntConstant;
import AST.Expression.ConstantExpression.NullConstant;
import AST.Expression.ConstantExpression.StringConstant;
import AST.Expression.Expression;
import AST.Type.BasicType.BoolType;
import AST.Type.Type;
import Error.CompileError;

/**
 * Created by fangbohui on 17-4-2.
 */
public class NotEqualToExpression extends BinaryExpression {
	private NotEqualToExpression(Type type, Boolean isLV, Expression leftExpression, Expression rightExpression) {
		super(type, isLV, leftExpression, rightExpression);
	}
	public static Expression getExpression(Expression leftExpression, Expression rightExpression) {
		if (!leftExpression.type.equalTo(rightExpression.type)) {
			throw new CompileError("you're comparing two diffenrent types");
		}
		if (leftExpression instanceof NullConstant && rightExpression instanceof NullConstant) {
			return BoolConstant.getConstant(true);
		} else if (leftExpression instanceof IntConstant && rightExpression instanceof IntConstant) {
			int v1 = ((IntConstant) leftExpression).value;
			int v2 = ((IntConstant) rightExpression).value;
			return BoolConstant.getConstant(v1 != v2);
		} else if (leftExpression instanceof BoolConstant && rightExpression instanceof BoolConstant) {
			boolean v1 = ((BoolConstant) leftExpression).value;
			boolean v2 = ((BoolConstant) rightExpression).value;
			return BoolConstant.getConstant(v1 != v2);
		} else if (leftExpression instanceof StringConstant && rightExpression instanceof StringConstant) {
			String s1 = ((StringConstant) leftExpression).value;
			String s2 = ((StringConstant) rightExpression).value;
			return BoolConstant.getConstant(!s1.equals(s2));
		} else {
			return new NotEqualToExpression(BoolType.getType(), false, leftExpression, rightExpression);
		}
	}
}
