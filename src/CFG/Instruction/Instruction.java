package CFG.Instruction;

import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-5-17.
 */
public abstract class Instruction {
	public abstract ArrayList<Operand> getDestOperands();
	public abstract ArrayList<Operand> getSrcOperands();

	public ArrayList<VirtualRegister> getDestRegisters() {
		ArrayList<VirtualRegister> registers = new ArrayList<>();
		for (Operand operand : getDestOperands()) {
			if (operand instanceof VirtualRegister) {
				registers.add((VirtualRegister) operand);
			}
		}
		return registers;
	}

	public ArrayList<VirtualRegister> getSrcRegisters() {
		ArrayList<VirtualRegister> registers = new ArrayList<>();
		for (Operand operand : getSrcOperands()) {
			if (operand instanceof VirtualRegister) {
				registers.add((VirtualRegister) operand);
			}
		}
		return registers;
	}
}
