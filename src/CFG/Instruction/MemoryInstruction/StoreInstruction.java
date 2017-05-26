package CFG.Instruction.MemoryInstruction;

import CFG.Instruction.Instruction;
import CFG.Operand.Address;
import CFG.Operand.Operand;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-5-23.
 */
public class StoreInstruction extends MemoryInstruction {
	public Operand src;
	public Address dest;

	private StoreInstruction(Operand src, Address dest) {
		this.src = src;
		this.dest = dest;
	}

	public static Instruction getInstruction(Operand src, Address dest) {
		return new StoreInstruction(src, dest);
	}

	@Override
	public ArrayList<Operand> getDestOperands() {
		ArrayList<Operand> operands = new ArrayList<>();
		operands.add(dest);
		return operands;
	}

	@Override
	public ArrayList<Operand> getSrcOperands() {
		ArrayList<Operand> operands = new ArrayList<>();
		operands.add(src);
		return operands;
	}
}
