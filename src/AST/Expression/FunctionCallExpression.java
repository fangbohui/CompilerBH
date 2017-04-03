package AST.Expression;

import AST.Expression.VarExpression.FieldExpression;
import AST.Function;
import AST.Type.ClassType;
import AST.Type.Type;
import Error.CompileError;
import java.util.List;

/**
 * Created by fangbohui on 17-4-2.
 */
public class FunctionCallExpression extends Expression {
	public Function function;
	public List<Expression> parameters;

	private FunctionCallExpression(Type type, boolean isLV, Function function, List<Expression> parameters) {
		super(type, isLV);
		this.function = function;
		this.parameters = parameters;
	}

	public static Expression getExpression(Function function, List<Expression> parameters) {
		return new FunctionCallExpression(function.type, false, function, parameters);
	}

	public static Expression getExpression(Expression expression, List<Expression> parameters) {
		if (expression instanceof NewExpression) {
			NewExpression newExpression = (NewExpression)expression;
			if (newExpression.type instanceof ClassType) {
				if (parameters.size() > 0) {
					throw new CompileError("there should be no parameter in the constructor");
				}
				ClassType classType = (ClassType)newExpression.type;
				newExpression.constructor = classType.constructor;
				newExpression.parameters = parameters;
				return newExpression;
			}
			throw new CompileError("there is no constructor");
		}
		if (expression.type instanceof Function) {
			Function function = (Function)expression.type;
			if (expression instanceof FieldExpression) {
				parameters.add(0, ((FieldExpression)expression).className);
			}
			if (parameters.size() != function.parameters.size()) {
				throw new CompileError("wrong number of function parameters");
			}
			for (int i = 0; i < parameters.size(); i ++) {
				if (i == 0 && expression instanceof FieldExpression) {
					continue;
				}
				if (!parameters.get(i).type.equalTo(function.parameters.get(i).type)) {
					throw new CompileError("wrong type of function parameters");
				}
			}
			return new FunctionCallExpression(function.type, false, function, parameters);
		}
		throw new CompileError("I guess there should be a function");
	}
}
