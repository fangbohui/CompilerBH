package AST.Statement;

import AST.Statement.LoopStatement.LoopStatement;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.JumpInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.MemoryInstruction.MoveInstruction;
import Environment.Environment;
import Error.CompileError;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class ContinueStatement extends Statement {
	public LoopStatement goal;

	private ContinueStatement(LoopStatement goal) {
		this.goal = goal;
	}

	public static Statement getStatement() {
		if (Environment.scopeTable.loopStatementTop() == null) {
			throw new CompileError("continue should be in the loop");
		}
		return new ContinueStatement(Environment.scopeTable.loopStatementTop());
	}

	public void emit(ArrayList<Instruction> instructions) {
		instructions.add(JumpInstruction.getInstruction(goal.loopBegin));
	}
}
