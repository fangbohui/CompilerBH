package AST.Statement.LoopStatement;

import AST.Expression.Expression;
import AST.Statement.Statement;
import AST.Type.BasicType.BoolType;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.BranchInstruction;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.JumpInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.LabelInstruction;
import Error.CompileError;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class WhileStatement extends LoopStatement {
	public Expression condition;
	public Statement statement;

	public static Statement getStatement() {
		return new WhileStatement();
	}

	public void addCondition(Expression condition) {
		if (!(condition.type instanceof BoolType)) {
			throw new CompileError("you're putting a non-bool type on the whileStatement");
		}
		this.condition = condition;
	}

	public void addStatement(Statement statement) {
		this.statement = statement;
	}

	public void emit(ArrayList<Instruction> instructions) {
		LabelInstruction whileBody = (LabelInstruction) LabelInstruction.getInstruction("whileBody");
		loopBegin = (LabelInstruction) LabelInstruction.getInstruction("whileCondition");
		loopMerge = (LabelInstruction) LabelInstruction.getInstruction("whileMerge");

		instructions.add(JumpInstruction.getInstruction(loopBegin));

		instructions.add(loopBegin);
		if (condition != null) {
			condition.emit(instructions);
		}
		instructions.add(BranchInstruction.getInstruction(condition.operand, whileBody, loopMerge));

		instructions.add(whileBody);
		if (statement != null) {
			statement.emit(instructions);
		}
		instructions.add(JumpInstruction.getInstruction(loopBegin));

		instructions.add(loopMerge);
	}
}
