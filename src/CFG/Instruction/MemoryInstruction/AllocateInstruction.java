package CFG.Instruction.MemoryInstruction;

import CFG.Instruction.Instruction;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-5-23.
 */
public class AllocateInstruction extends MemoryInstruction {
	public VirtualRegister dest;
	public Operand size;

	private AllocateInstruction(VirtualRegister dest, Operand size) {
		this.dest = dest;
		this.size = size;
	}

	public static Instruction getInstruction(VirtualRegister dest, Operand size) {
		return new AllocateInstruction(dest, size);
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
		operands.add(size);
		return operands;
	}
}
