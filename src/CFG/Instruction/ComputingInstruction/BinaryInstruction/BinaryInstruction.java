package CFG.Instruction.ComputingInstruction.BinaryInstruction;

import AST.Expression.BinaryExpression.BinaryExpression;
import CFG.Instruction.ComputingInstruction.ComputingInstruction;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;

/**
 * Created by fangbohui on 17-5-18.
 */
public abstract class BinaryInstruction extends ComputingInstruction {
	public VirtualRegister dest;
	public Operand src1, src2;

	public BinaryInstruction(VirtualRegister dest, Operand src1, Operand src2) {
		this.dest = dest;
		this.src1 = src1;
		this.src2 = src2;
	}
}
