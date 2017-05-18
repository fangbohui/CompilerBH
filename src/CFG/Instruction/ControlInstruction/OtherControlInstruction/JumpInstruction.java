package CFG.Instruction.ControlInstruction.OtherControlInstruction;

import CFG.Instruction.ControlInstruction.ControlInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.LabelInstruction;
import CFG.Operand.Operand;

/**
 * Created by fangbohui on 17-5-18.
 */
public class JumpInstruction extends ControlInstruction {
	public LabelInstruction dest;

	private JumpInstruction(LabelInstruction dest) {
		this.dest = dest;
	}

	public static Instruction getInstruction(LabelInstruction dest) {
		return new JumpInstruction(dest);
	}
}
