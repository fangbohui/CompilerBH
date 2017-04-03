package AST.Expression.ConstantExpression;

import AST.Type.BasicType.BoolType;

public class BoolConstant extends Constant {
	public boolean value;
	private BoolConstant(Boolean value) {
		super(BoolType.getType());
		this.value = value;
	}
	public static BoolConstant getConstant(Boolean value) {
		return new BoolConstant(value);
	}
}
