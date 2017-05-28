package AST.Expression.VarExpression;

import AST.Expression.Expression;
import AST.Type.ArrayType;
import AST.Type.BasicType.IntType;
import AST.Type.Type;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.AddInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.MultiplyInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.MemoryInstruction.LoadInstruction;
import CFG.Instruction.MemoryInstruction.MoveInstruction;
import CFG.Operand.Address;
import CFG.Operand.ImmediatelyNumber;
import CFG.Operand.VirtualRegister;
import Environment.Environment;
import Error.CompileError;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class IndexExpression extends Expression {
	public Expression array, index;

	private IndexExpression(Type type, boolean isLV, Expression array, Expression index) {
		super(type, isLV);
		this.array = array;
		this.index = index;
	}

	public static Expression getExpression(Expression array, Expression index) {
		if (!(array.type instanceof ArrayType)) {
			throw new CompileError("there should be a array-type in the left");
		}
		if (!(index.type instanceof IntType)) {
			throw new CompileError("there should be an int-type of the index");
		}
		ArrayType arrayType = (ArrayType)array.type;
		return new IndexExpression(arrayType.reduce(), array.isLeftValue, array, index);
	}

	public void emit(ArrayList<Instruction> instructions) {
		array.emit(instructions);
		array.load(instructions);
		index.emit(instructions);
		index.load(instructions);
		VirtualRegister offset = Environment.registerTable.addTemporaryRegister(null);
		instructions.add(MultiplyInstruction.getInstruction(offset, index.operand, new ImmediatelyNumber(8)));
		VirtualRegister address = Environment.registerTable.addTemporaryRegister(null);
		instructions.add(AddInstruction.getInstruction(address, array.operand, offset));
		//instructions.add(AddInstruction.getInstruction(address, array.operand, new ImmediatelyNumber(8)));
		operand = new Address(address, 8);
	}

	public void load(ArrayList<Instruction> instructions) {
		if (operand instanceof Address) {
			Address address = (Address) operand;
			operand = Environment.registerTable.addTemporaryRegister(null);
			instructions.add(LoadInstruction.getInstruction((VirtualRegister) operand, address));
		}
	}
}
