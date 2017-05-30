package CFG.Instruction.ComputingInstruction.UnaryInstruction.OtherUnaryInstruction;

import CFG.Instruction.ComputingInstruction.UnaryInstruction.UnaryInstruction;
import CFG.Instruction.Instruction;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;

/**
 * Created by fangbohui on 17-5-17.
 */
public class BitNotInstruction extends UnaryInstruction {
	private BitNotInstruction(VirtualRegister dest, Operand src) {
		super(dest, src);
	}

	public static Instruction getInstruction(VirtualRegister dest, Operand src) {
		return new BitNotInstruction(dest, src);
	}

	public String OPname() {
		return String.format("not");
	}
}
