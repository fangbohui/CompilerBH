package CFG.Instruction;

import CFG.Block;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-5-18.
 */
public class LabelInstruction extends Instruction {
	public String name;
	public Block block;

	private LabelInstruction(String name) {
		this.name = name;
	}

	public static Instruction getInstruction(String name) {
		return new LabelInstruction(name);
	}

	@Override
	public ArrayList<Operand> getDestOperands() {
		ArrayList<Operand> operands = new ArrayList<>();
		return operands;
	}

	@Override
	public ArrayList<Operand> getSrcOperands() {
		ArrayList<Operand> operands = new ArrayList<>();
		return operands;
	}
}
