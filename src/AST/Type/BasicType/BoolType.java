package AST.Type.BasicType;

import AST.Type.Type;

/**
 * Created by fangbohui on 17-4-2.
 */
public class BoolType extends Type {
	private static BoolType boolType = new BoolType();
	public static Type getType() {
		return boolType;
	}
	@Override
	public Boolean equalTo(Type other) {
		return (other instanceof BoolType);
	}
}
