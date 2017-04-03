package AST.Statement;

import AST.Expression.Expression;
import AST.Function;
import AST.Type.BasicType.VoidType;
import Environment.Symbol;
import Error.CompileError;

/**
 * Created by fangbohui on 17-4-2.
 */
public class VarStatement extends Statement {
	public Symbol symbol;
	public Expression expression;

	private VarStatement(Symbol symbol, Expression expression) {
		this.symbol = symbol;
		this.expression = expression;
	}

	public static Statement getStatement(Symbol symbol, Expression expression) {
		if (symbol.type instanceof VoidType) {
			throw new CompileError("you cannot ask for a void-type var");
		}
		if (expression == null || symbol.type.equalTo(expression.type)) {
			return new VarStatement(symbol, expression);
		}
		throw new CompileError("you're using 2 different types to var");
	}

}
