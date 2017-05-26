package AST.Expression.VarExpression;

import AST.Function;
import AST.Type.ClassType;
import CFG.Instruction.Instruction;
import Error.CompileError;
import AST.Expression.Expression;
import AST.Type.Type;
import Environment.Environment;
import Environment.Symbol;
import sun.reflect.generics.scope.ClassScope;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class IdenExpression extends Expression {
	public Symbol symbol;

	private IdenExpression(Type type, boolean isLV, Symbol symbol) {
		super(type, isLV);
		this.symbol = symbol;
	}

	public static Expression getExpression(String name) {
		if (!Environment.symbolTable.containsName(name)) {
			throw new CompileError("there is no such an ID");
		}
		Symbol symbol = Environment.symbolTable.get(name);
		if (symbol.scope instanceof ClassType) {
			return FieldExpression.getExpression(IdenExpression.getExpression("this"), name);
		} else if (symbol.scope instanceof Function) {
			return new IdenExpression(symbol.type, false, symbol);
		} else {
			return new IdenExpression(symbol.type, true, symbol); // loopStatement
		}
	}

	public void emit(ArrayList<Instruction> instructions) {
		operand = symbol.register;
	}
}
