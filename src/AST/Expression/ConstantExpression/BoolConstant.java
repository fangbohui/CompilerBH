package AST.Expression.ConstantExpression;

import AST.Type.BasicType.BoolType;
import CFG.Instruction.Instruction;
import CFG.Operand.ImmediatelyNumber;

import java.util.ArrayList;

public class BoolConstant extends Constant {
	public boolean value;

	private BoolConstant(Boolean value) {
		super(BoolType.getType());
		this.value = value;
	}

	public static BoolConstant getConstant(Boolean value) {
		return new BoolConstant(value);
	}

	public void emit(ArrayList<Instruction> instructions) {
		operand = new ImmediatelyNumber(value ? 1 : 0);
	}
}
