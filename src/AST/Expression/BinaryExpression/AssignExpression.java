package AST.Expression.BinaryExpression;

import AST.Expression.Expression;
import AST.Type.BasicType.BoolType;
import AST.Type.BasicType.IntType;
import AST.Type.BasicType.StringType;
import AST.Type.Type;
import Error.CompileError;

/**
 * Created by fangbohui on 17-4-2.
 */
public class AssignExpression extends BinaryExpression {
	private AssignExpression(Type type, Boolean isLV, Expression leftExpression, Expression rightExpression) {
		super(type, isLV, leftExpression, rightExpression);
	}
	public static Expression getExpression(Expression leftExpression, Expression rightExpression) {
		if (!leftExpression.isLeftValue) {
			throw new CompileError("there should be a left value");
		}
		if (!leftExpression.type.equalTo(rightExpression.type)) {
			throw new CompileError("you're assigning two diffenrent types");
		}
		return new AssignExpression(leftExpression.type, true, leftExpression, rightExpression);
	}
}
