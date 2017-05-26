package CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions;

import CFG.Instruction.ComputingInstruction.BinaryInstruction.BinaryInstruction;
import CFG.Instruction.Instruction;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;

/**
 * Created by fangbohui on 17-5-18.
 */
public class AddInstruction extends BinaryInstruction {
	private AddInstruction(VirtualRegister dest, Operand src1, Operand src2) {
		super(dest, src1, src2);
	}

	public static Instruction getInstruction(VirtualRegister dest, Operand src1, Operand src2) {
		return new AddInstruction(dest, src1, src2);
	}

	public String OPname() {
		return "add";
	}
}
