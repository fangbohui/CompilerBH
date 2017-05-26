package AST.Expression.UnaryExpression;

import AST.Expression.Expression;
import AST.Type.BasicType.IntType;
import AST.Type.Type;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.MinusInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.MemoryInstruction.MoveInstruction;
import CFG.Instruction.MemoryInstruction.StoreInstruction;
import CFG.Operand.Address;
import CFG.Operand.ImmediatelyNumber;
import CFG.Operand.VirtualRegister;
import Environment.Environment;
import Error.CompileError;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class SucDecExpression extends UnaryExpression {
	private SucDecExpression(Type type, Boolean isLV, Expression expression) {
		super(type, isLV, expression);
	}
	public static Expression getExpression(Expression expression) {
		if (!expression.isLeftValue) {
			throw new CompileError("X-- should be a left value");
		}
		if (!(expression.type instanceof IntType)) {
			throw new CompileError("X-- should be a int");
		}
		return new SucDecExpression(IntType.getType(), false, expression);
	}

	public void emit(ArrayList<Instruction> instructions) {
		expression.emit(instructions);
		expression.load(instructions);
		operand = Environment.registerTable.addTemporaryRegister(null);
		instructions.add(MoveInstruction.getInstruction(operand, expression.operand));
		instructions.add(MinusInstruction.getInstruction((VirtualRegister) operand, operand, new ImmediatelyNumber(1)));
		if (expression.operand instanceof Address) {
			Address address = (Address) expression.operand;
			address = new Address(address.base, address.index, address.scale);
			instructions.add(StoreInstruction.getInstruction(operand, address));
		}
	}
}
