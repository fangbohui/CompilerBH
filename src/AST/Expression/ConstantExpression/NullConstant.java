package AST.Expression.ConstantExpression;

import AST.Type.BasicType.NullType;
import CFG.Instruction.Instruction;
import CFG.Operand.ImmediatelyNumber;

import java.util.ArrayList;

public class NullConstant extends Constant {
	private NullConstant() {
		super(NullType.getType());
	}
	public static NullConstant getConstant() {
		return new NullConstant();
	}

	public void emit(ArrayList<Instruction> instructions) {
		operand = new ImmediatelyNumber(0);
	}
}
