package CFG.Instruction.MemoryInstruction;

import CFG.Instruction.Instruction;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;
import Error.InternalError;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-5-17.
 */
public class MoveInstruction extends MemoryInstruction {
	public VirtualRegister dest;
	public Operand src;

	private MoveInstruction(VirtualRegister dest, Operand src) {
		this.dest = dest;
		this.src = src;
	}

	public static Instruction getInstruction(Operand dest, Operand src) {
		if (dest instanceof VirtualRegister) {
			return new MoveInstruction((VirtualRegister) dest, src);
		} else {
			throw new InternalError();
		}
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
