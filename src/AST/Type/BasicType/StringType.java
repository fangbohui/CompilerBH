package AST.Type.BasicType;

import AST.Type.Type;

/**
 * Created by fangbohui on 17-4-2.
 */
public class StringType extends Type {
	private static StringType stringType = new StringType();
	public static Type getType() {
		return stringType;
	}
	@Override
	public Boolean equalTo(Type other) {
		return other instanceof StringType;
	}
}
