package AST.Expression.ConstantExpression;

import AST.Type.BasicType.StringType;
import CFG.Instruction.Instruction;
import CFG.Operand.ImmediatelyNumber;
import CFG.Operand.StringRegister;
import Environment.Environment;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class StringConstant extends Constant {
	public String string;
	private StringConstant(String string) {
		super(StringType.getType());
		this.string = string;
	}
	public static StringConstant getConstant(String value) {
		return new StringConstant(value);
	}



	public void emit(ArrayList<Instruction> instructions) {
		operand = Environment.registerTable.addStringRegister(string);
	}
}
