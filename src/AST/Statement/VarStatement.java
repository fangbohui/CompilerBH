package AST.Statement;

import AST.Expression.Expression;
import AST.Function;
import AST.Type.BasicType.VoidType;
import CFG.Instruction.Instruction;
import CFG.Instruction.MemoryInstruction.MoveInstruction;
import Environment.Symbol;
import Error.CompileError;

import java.util.ArrayList;

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

	public void emit(ArrayList<Instruction> instructions) {
		if (expression != null) {
			expression.emit(instructions);
			expression.load(instructions);
			instructions.add(MoveInstruction.getInstruction(symbol.register, expression.operand));
		}
	}
}
