package AST.Expression.UnaryExpression;

import AST.Expression.ConstantExpression.IntConstant;
import AST.Expression.Expression;
import AST.Type.BasicType.IntType;
import AST.Type.Type;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.MinusInstruction;
import CFG.Instruction.Instruction;
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
public class UnaryAddExpression extends UnaryExpression {
	private UnaryAddExpression(Type type, Boolean isLV, Expression expression) {
		super(type, isLV, expression);
	}
	public static Expression getExpression(Expression expression) {
		if (!(expression.type instanceof IntType)) {
			throw new CompileError("+X should be a int");
		}
		if (expression instanceof IntConstant) {
			int value = ((IntConstant) expression).value;
			return IntConstant.getConstant(value);
		}
		return new UnaryAddExpression(IntType.getType(), false, expression);
	}

	public void emit(ArrayList<Instruction> instructions) {
		operand = expression.operand;
	}
}
