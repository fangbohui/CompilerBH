package AST.Type;

import AST.Type.BasicType.NullType;
import AST.Type.BasicType.VoidType;
import Error.CompileError;

public class ArrayType extends Type {
	public Type baseType;
	public int dimension;

	public ArrayType(Type newBaseType, int newDimension) {
		this.baseType = newBaseType;
		this.dimension = newDimension;
	}

	public static Type getType(Type baseType, int dimension) {
		if (baseType instanceof VoidType) {
			throw new CompileError("void-array is not allowed");
		}
		if (dimension == 0) {
			throw new InternalError();
		}
		return new ArrayType(baseType, dimension);
	}

	public static Type getType(Type baseType) {
		if (baseType instanceof VoidType) {
			throw new CompileError("void-array is not allowed");
		}
		if (baseType instanceof ArrayType) {
			ArrayType arrayType = (ArrayType)baseType;
			return new ArrayType(arrayType.baseType, arrayType.dimension + 1);
		} else {
			return new ArrayType(baseType, 1);
		}
	}

	public Type reduce() {
		if (dimension == 1) {
			return baseType;
		} else {
			return ArrayType.getType(baseType, dimension - 1);
		}
	}

	@Override
	public Boolean equalTo(Type other) {
		if (other instanceof NullType) {
			return true;
		}
		if (other instanceof ArrayType) {
			ArrayType arrayType = (ArrayType)other;
			return arrayType.baseType.equalTo(baseType) && arrayType.dimension == dimension;
		}
		return false;
	}

	// TODO
}
