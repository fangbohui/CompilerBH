package AST.Type.BasicType;

import AST.Type.ArrayType;
import AST.Type.ClassType;
import AST.Type.Type;

/**
 * Created by fangbohui on 17-4-2.
 */
public class NullType extends Type {
	private static NullType nullType = new NullType();
	public static Type getType() {
		return nullType;
	}
	@Override
	public Boolean equalTo(Type other) {
		return (other instanceof NullType || other instanceof ArrayType || other instanceof ClassType);
	}
}
