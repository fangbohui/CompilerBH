package CFG.Instruction.FunctionInstruction;

import AST.Statement.VarStatement;
import CFG.Instruction.Instruction;
import CFG.Operand.Operand;
import Environment.Environment;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-5-20.
 */
public class ReturnInstruction extends FunctionInstruction {
	public Operand src;

	private ReturnInstruction(Operand src) {
		this.src = src;
	}

	public static Instruction getInstruction(Operand src) {
		return new ReturnInstruction(src);
	}

	@Override
	public ArrayList<Operand> getDestOperands() {
		ArrayList<Operand> operands = new ArrayList<>();
		return operands;
	}

	@Override
	public ArrayList<Operand> getSrcOperands() {
		ArrayList<Operand> operands = new ArrayList<>();
		if (src != null) {
			operands.add(src);
		}
		return operands;
	}
}
