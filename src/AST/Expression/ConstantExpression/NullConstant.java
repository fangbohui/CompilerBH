package AST.Expression.ConstantExpression;

import AST.Type.BasicType.NullType;

public class NullConstant extends Constant {
	private NullConstant() {
		super(NullType.getType());
	}
	public static NullConstant getConstant() {
		return new NullConstant();
	}
}
