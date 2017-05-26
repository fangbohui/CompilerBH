package AST.Statement;

import AST.Expression.Expression;
import CFG.Instruction.Instruction;
import CFG.Instruction.MemoryInstruction.MoveInstruction;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class ExpressionStatement extends Statement {
	public Expression expression;

	private ExpressionStatement(Expression expression) {
		this.expression = expression;
	}

	public static Statement getStatement(Expression expression) {
		return new ExpressionStatement(expression);
	}

	public void emit(ArrayList<Instruction> instructions) {
		if (expression != null) {
			expression.emit(instructions);
			expression.load(instructions);
		}
	}
}
