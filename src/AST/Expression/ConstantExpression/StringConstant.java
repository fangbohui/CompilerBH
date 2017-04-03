package AST.Expression.ConstantExpression;

import AST.Type.BasicType.StringType;

/**
 * Created by fangbohui on 17-4-2.
 */
public class StringConstant extends Constant {
	public String value;
	private StringConstant(String value) {
		super(StringType.getType());
		this.value = value;
	}
	public static StringConstant getConstant(String value) {
		return new StringConstant(value);
	}
}
