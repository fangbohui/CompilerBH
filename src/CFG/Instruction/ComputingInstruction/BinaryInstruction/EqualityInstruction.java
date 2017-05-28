package CFG.Instruction.ComputingInstruction.BinaryInstruction;

import CFG.Instruction.Instruction;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;

/**
 * Created by fangbohui on 17-5-26.
 */
public abstract class EqualityInstruction extends BinaryInstruction {
	public EqualityInstruction(VirtualRegister dest, Operand src1, Operand src2) {
		super(dest, src1, src2);
	}
	public abstract String symbolName();
}
