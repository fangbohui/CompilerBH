package AST.Type.BasicType;

import AST.Type.Type;

/**
 * Created by fangbohui on 17-4-2.
 */
public class VoidType extends Type {
	private static VoidType voidType = new VoidType();
	public static Type getType() {
		return voidType;
	}
	@Override
	public Boolean equalTo(Type other) {
		return false;
	}
}
