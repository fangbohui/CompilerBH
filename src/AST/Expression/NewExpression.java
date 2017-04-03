package AST.Expression;

import AST.Function;
import AST.Type.ArrayType;
import AST.Type.ClassType;
import AST.Type.Type;
import Error.CompileError;
import java.util.ArrayList;
import java.util.List;

public class NewExpression extends Expression {
	public List<Expression> expressions;
	public List<Expression> parameters;
	public Function constructor;

	private NewExpression(Type type, boolean isLV, List<Expression> expressions) {
		super(type, isLV);
		this.expressions = expressions;
		this.parameters = new ArrayList<>();
		this.constructor = null;
	}

	public static Expression getExpression(Type type, List<Expression> dimensionExpressions) {
		if (dimensionExpressions.isEmpty()) {
			if (type instanceof ClassType) {
				return new NewExpression(type, false, dimensionExpressions);
			}
			throw new CompileError("you are newing some non-class-nor-array things");
		} else {
			Type arrayType = ArrayType.getType(type, dimensionExpressions.size());
			return new NewExpression(arrayType, false, dimensionExpressions);
		}
	}
}
