package AST.Expression.BinaryExpression;

import AST.Expression.Expression;
import AST.Type.BasicType.BoolType;
import AST.Type.BasicType.IntType;
import AST.Type.BasicType.StringType;
import AST.Type.Type;
import CFG.Instruction.Instruction;
import CFG.Instruction.MemoryInstruction.LoadInstruction;
import CFG.Instruction.MemoryInstruction.MoveInstruction;
import CFG.Operand.Address;
import CFG.Operand.VirtualRegister;
import Environment.Environment;
import Error.CompileError;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class AssignExpression extends BinaryExpression {
	private AssignExpression(Type type, Boolean isLV, Expression leftExpression, Expression rightExpression) {
		super(type, isLV, leftExpression, rightExpression);
	}
	public static Expression getExpression(Expression leftExpression, Expression rightExpression) {
		if (!leftExpression.isLeftValue) {
			throw new CompileError("there should be a left value");
		}
		if (!leftExpression.type.equalTo(rightExpression.type)) {
			throw new CompileError("you're assigning two diffenrent types");
		}
		return new AssignExpression(leftExpression.type, true, leftExpression, rightExpression);
	}

	public void emit(ArrayList<Instruction> instructions) {
		leftExpression.emit(instructions);

		rightExpression.emit(instructions);
		rightExpression.load(instructions);

		operand = leftExpression.operand;
		instructions.add(MoveInstruction.getInstruction(leftExpression.operand, rightExpression.operand));
	}

	@Override
	public void load(ArrayList<Instruction> instructions) {
		if (operand instanceof Address) {
			Address address = (Address) operand;
			operand = Environment.registerTable.addTemporaryRegister(null);
			instructions.add(LoadInstruction.getInstruction((VirtualRegister) operand, address));
		}
	}
}
