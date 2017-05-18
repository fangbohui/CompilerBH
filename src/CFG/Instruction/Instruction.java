package CFG.Instruction;

import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fangbohui on 17-5-17.
 */
public abstract class Instruction {
	public Instruction rebuild() {
		return this;
	}
}
