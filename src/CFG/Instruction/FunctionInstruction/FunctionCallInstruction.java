package CFG.Instruction.FunctionInstruction;

import AST.Function;
import CFG.Instruction.Instruction;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;

import java.util.List;

/**
 * Created by fangbohui on 17-5-17.
 */
public class FunctionCallInstruction extends FunctionInstruction {
	public VirtualRegister dest;
	public Function function;
	public List<Operand> parameters;

	private FunctionCallInstruction(VirtualRegister dest, Function function, List<Operand> parameters) {
		this.dest = dest;
		this.function = function;
		this.parameters = parameters;
	}

	public static Instruction getInstruction(VirtualRegister dest, Function function, List<Operand> parameters) {
		if (dest instanceof VirtualRegister) {
			return new FunctionCallInstruction(dest, function, parameters);
		} else {
			return new FunctionCallInstruction(null, function, parameters);
		}
	}
}
