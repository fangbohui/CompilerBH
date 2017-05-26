package CFG.Instruction.FunctionInstruction;

import AST.Function;
import AST.Statement.VarStatement;
import CFG.Instruction.Instruction;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;
import Environment.Environment;

import java.util.ArrayList;
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
		if (dest != null) {
			return new FunctionCallInstruction(dest, function, parameters);
		} else {
			return new FunctionCallInstruction(null, function, parameters);
		}
	}

	@Override
	public ArrayList<Operand> getDestOperands() {
		ArrayList<Operand> operands = new ArrayList<>();
		if (dest != null) { // void
			operands.add(dest);
		}
		for (VarStatement varStatement : Environment.program.varList) { // TODO
			if (varStatement.symbol.register != null) {
				operands.add(varStatement.symbol.register);
			}
		}
		return operands;
	}

	@Override
	public ArrayList<Operand> getSrcOperands() {
		ArrayList<Operand> operands = new ArrayList<>();
		operands.addAll(parameters);
		for (VarStatement varStatement : Environment.program.varList) {
			if (varStatement.symbol.register != null) {
				operands.add(varStatement.symbol.register);
			}
		}
		return operands;
	}
}
