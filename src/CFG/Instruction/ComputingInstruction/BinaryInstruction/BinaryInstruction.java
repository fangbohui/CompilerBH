package CFG.Instruction.ComputingInstruction.BinaryInstruction;

import AST.Expression.BinaryExpression.BinaryExpression;
import CFG.Instruction.ComputingInstruction.ComputingInstruction;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;

import java.util.ArrayList;

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

	public abstract String OPname();

	@Override
	public ArrayList<Operand> getSrcOperands() {
		ArrayList<Operand> operands = new ArrayList<>();
		operands.add(src1);
		operands.add(src2);
		return operands;
	}

	@Override
	public ArrayList<Operand> getDestOperands() {
		ArrayList<Operand> operands = new ArrayList<>();
		operands.add(dest);
		return operands;
	}
}
