package CFG.Instruction.MemoryInstruction;

import CFG.Instruction.Instruction;
import CFG.Operand.Address;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-5-23.
 */
public class LoadInstruction extends MemoryInstruction {
	public VirtualRegister dest;
	public Address src;

	private LoadInstruction(VirtualRegister dest, Address src) {
		this.dest = dest;
		this.src = src;
	}

	public static Instruction getInstruction(VirtualRegister dest, Address src) {
		return new LoadInstruction(dest, src);
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
		operands.add(src.base);
		return operands;
	}
}
