package AST.Expression.ConstantExpression;

import AST.Type.BasicType.IntType;
import CFG.Instruction.Instruction;
import CFG.Operand.ImmediatelyNumber;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class IntConstant extends Constant {
	public int value;
	private IntConstant(int value) {
		super(IntType.getType());
		this.value = value;
	}
	public static IntConstant getConstant(int value) {
		return new IntConstant(value);
	}

	public void emit(ArrayList<Instruction> instructions) {
		operand = new ImmediatelyNumber(value);
	}
}
