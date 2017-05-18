package CFG.Instruction.ComputingInstruction.UnaryInstruction;

import CFG.Instruction.Instruction;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;

/**
 * Created by fangbohui on 17-5-18.
 */
public abstract class UnaryInstruction extends Instruction {
	public VirtualRegister dest;
	public Operand src;

	public UnaryInstruction(VirtualRegister dest, Operand src) {
		this.dest = dest;
		this.src = src;
	}
}
