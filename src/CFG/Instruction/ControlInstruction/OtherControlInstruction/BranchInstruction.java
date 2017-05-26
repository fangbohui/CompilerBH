package CFG.Instruction.ControlInstruction.OtherControlInstruction;

import AST.Statement.VarStatement;
import CFG.Instruction.ControlInstruction.ControlInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.LabelInstruction;
import CFG.Operand.Operand;
import Environment.Environment;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-5-18.
 */
public class BranchInstruction extends ControlInstruction {
	public Operand condition;
	public LabelInstruction trueDest, falseDest;

	private BranchInstruction(Operand condition, LabelInstruction trueDest, LabelInstruction falseDest) {
		this.condition = condition;
		this.trueDest = trueDest;
		this.falseDest = falseDest;
	}

	public static Instruction getInstruction(Operand condition, LabelInstruction trueDest, LabelInstruction falseDest) {
		return new BranchInstruction(condition, trueDest, falseDest);
	}

	@Override
	public ArrayList<Operand> getDestOperands() {
		ArrayList<Operand> operands = new ArrayList<>();
		return operands;
	}

	@Override
	public ArrayList<Operand> getSrcOperands() {
		ArrayList<Operand> operands = new ArrayList<>();
		operands.add(condition);
		return operands;
	}
}
