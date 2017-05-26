package AST.Expression.BinaryExpression;

import AST.Expression.ConstantExpression.IntConstant;
import AST.Expression.Expression;
import AST.Type.BasicType.IntType;
import AST.Type.Type;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.AddInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.AndInstruction;
import CFG.Instruction.Instruction;
import CFG.Operand.VirtualRegister;
import Environment.Environment;
import Error.CompileError;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class AndExpression extends BinaryExpression {
	private AndExpression(Type type, Boolean isLV, Expression leftExpression, Expression rightExpression) {
		super(type, isLV, leftExpression, rightExpression);
	}
	public static Expression getExpression(Expression leftExpression, Expression rightExpression) {
		if (leftExpression.type instanceof IntType && rightExpression.type instanceof IntType) {
			if (leftExpression instanceof IntConstant && rightExpression instanceof IntConstant) {
				int v1 = ((IntConstant) leftExpression).value;
				int v2 = ((IntConstant) rightExpression).value;
				return IntConstant.getConstant(v1 & v2);
			}
			return new AndExpression(IntType.getType(), false, leftExpression, rightExpression);
		}
		throw new CompileError("& should between int");
	}

	public void emit(ArrayList<Instruction> instructions) {
		leftExpression.emit(instructions);
		leftExpression.load(instructions);

		rightExpression.emit(instructions);
		rightExpression.load(instructions);

		operand = Environment.registerTable.addTemporaryRegister(null);
		instructions.add(AndInstruction.getInstruction((VirtualRegister) operand, leftExpression.operand, rightExpression.operand));
	}
}
