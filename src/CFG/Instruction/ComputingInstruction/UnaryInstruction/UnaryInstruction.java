package CFG.Instruction.ComputingInstruction.UnaryInstruction;

import CFG.Instruction.ComputingInstruction.ComputingInstruction;
import CFG.Instruction.Instruction;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-5-18.
 */
public abstract class UnaryInstruction extends ComputingInstruction {
	public VirtualRegister dest;
	public Operand src;

	public UnaryInstruction(VirtualRegister dest, Operand src) {
		this.dest = dest;
		this.src = src;
	}

	public abstract String OPname();

	@Override
	public ArrayList<Operand> getSrcOperands() {
		ArrayList<Operand> operands = new ArrayList<>();
		operands.add(src);
		return operands;
	}

	@Override
	public ArrayList<Operand> getDestOperands() {
		ArrayList<Operand> operands = new ArrayList<>();
		operands.add(dest);
		return operands;
	}
}
