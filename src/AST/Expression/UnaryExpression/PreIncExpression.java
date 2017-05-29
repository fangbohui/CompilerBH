package AST.Expression.UnaryExpression;

import AST.Expression.Expression;
import AST.Type.BasicType.IntType;
import AST.Type.Type;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.AddInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.MinusInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.MemoryInstruction.MoveInstruction;
import CFG.Instruction.MemoryInstruction.StoreInstruction;
import CFG.Operand.Address;
import CFG.Operand.ImmediatelyNumber;
import CFG.Operand.VirtualRegister;
import Error.CompileError;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class PreIncExpression extends UnaryExpression {
	private PreIncExpression(Type type, Boolean isLV, Expression expression) {
		super(type, isLV, expression);
	}
	public static Expression getExpression(Expression expression) {
		if (!expression.isLeftValue) {
			throw new CompileError("++X should be a left value");
		}
		if (!(expression.type instanceof IntType)) {
			throw new CompileError("++X should be a int");
		}
		return new PreIncExpression(IntType.getType(), false, expression);
	}

	public void emit(ArrayList<Instruction> instructions) {
		expression.emit(instructions);
		if (expression.operand instanceof Address) {
			Address address = (Address) expression.operand;
			address = new Address(address.base, address.index, address.scale);
			expression.load(instructions);
			operand = expression.operand;
			instructions.add(AddInstruction.getInstruction((VirtualRegister) operand, operand, new ImmediatelyNumber(1)));
			instructions.add(StoreInstruction.getInstruction(operand, address));
		} else {
			expression.load(instructions);
			operand = expression.operand;
			instructions.add(AddInstruction.getInstruction((VirtualRegister) operand, operand, new ImmediatelyNumber(1)));
		}
	}
}
