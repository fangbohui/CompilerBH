package CFG.Instruction.MemoryInstruction;

import CFG.Instruction.Instruction;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;
import Error.InternalError;

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
}
