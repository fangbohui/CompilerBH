package AST.Statement;

import AST.Expression.Expression;
import AST.Function;
import AST.Type.BasicType.VoidType;
import Error.CompileError;
import Environment.Environment;

/**
 * Created by fangbohui on 17-4-2.
 */
public class ReturnStatement extends Statement {
	public Expression expression;
	public Function function;

	private ReturnStatement(Expression expression, Function function) {
		this.expression = expression;
		this.function = function;
	}

	public static Statement getStatement(Expression expression) {
		if (Environment.scopeTable.functionTop() == null) {
			throw new CompileError("return should be in the function");
		}
		Function function = Environment.scopeTable.functionTop();
		if (expression == null) {
			if (function.type instanceof VoidType) {
				return new ReturnStatement(expression, function);
			}
		} else if (expression.type.equalTo(function.type)) {
			return new ReturnStatement(expression, function);
		}
		throw new CompileError("return-type is different from function-type");
	}
}
