package AST.Expression;

import AST.Node;
import AST.Type.Type;
import CFG.Instruction.Instruction;
import CFG.Operand.Operand;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public abstract class Expression implements Node {
	public Type type;
	public Boolean isLeftValue;
	public Operand operand;

	public Expression(Type type, Boolean isLeftValue) {
		this.type = type;
		this.isLeftValue = isLeftValue;
	}

	public abstract void emit(ArrayList<Instruction> instructions);
	public void load(ArrayList<Instruction> instructions) {}
}
