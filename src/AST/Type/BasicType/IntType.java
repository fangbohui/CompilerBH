package AST.Type.BasicType;

import AST.Type.Type;

/**
 * Created by fangbohui on 17-4-2.
 */
public class IntType extends Type {
	private static IntType intType = new IntType();
	public static Type getType() {
		return intType;
	}
	@Override
	public Boolean equalTo(Type other) {
		return other instanceof IntType;
	}
}
