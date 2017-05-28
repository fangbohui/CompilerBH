package CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions;

import CFG.Instruction.ComputingInstruction.BinaryInstruction.BinaryInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.EqualityInstruction;
import CFG.Instruction.Instruction;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;

/**
 * Created by fangbohui on 17-5-18.
 */
public class LessInstruction extends EqualityInstruction {
	private LessInstruction(VirtualRegister dest, Operand src1, Operand src2) {
		super(dest, src1, src2);
	}

	public static Instruction getInstruction(VirtualRegister dest, Operand src1, Operand src2) {
		return new LessInstruction(dest, src1, src2);
	}

	public String OPname() {
		return "setl";
	}

	public String symbolName() {
		return  "l";
	}
}
