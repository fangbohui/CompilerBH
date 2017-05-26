package AST.Expression.BinaryExpression;

import AST.Expression.ConstantExpression.BoolConstant;
import AST.Expression.ConstantExpression.IntConstant;
import AST.Expression.ConstantExpression.StringConstant;
import AST.Expression.Expression;
import AST.Type.BasicType.BoolType;
import AST.Type.BasicType.IntType;
import AST.Type.BasicType.StringType;
import AST.Type.Type;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.AddInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.GreaterEqualInstruction;
import CFG.Instruction.Instruction;
import CFG.Operand.VirtualRegister;
import Environment.Environment;
import Error.CompileError;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class GreaterEqualExpression extends BinaryExpression {
	private GreaterEqualExpression(Type type, Boolean isLV, Expression leftExpression, Expression rightExpression) {
		super(type, isLV, leftExpression, rightExpression);
	}
	public static Expression getExpression(Expression leftExpression, Expression rightExpression) {
		if (leftExpression.type instanceof IntType && rightExpression.type instanceof IntType) {
			if (leftExpression instanceof IntConstant && rightExpression instanceof IntConstant) {
				int v1 = ((IntConstant) leftExpression).value;
				int v2 = ((IntConstant) rightExpression).value;
				return BoolConstant.getConstant(v1 >= v2);
			} else {
				return new GreaterEqualExpression(BoolType.getType(), false, leftExpression, rightExpression);
			}
		} else if (leftExpression.type instanceof StringType && rightExpression.type instanceof StringType) {
			if (leftExpression instanceof StringConstant && rightExpression instanceof StringConstant) {
				String s1 = ((StringConstant) leftExpression).string;
				String s2 = ((StringConstant) rightExpression).string;
				return BoolConstant.getConstant(s1.compareTo(s2) >= 0);
			} else {
				return new GreaterEqualExpression(BoolType.getType(), false, leftExpression, rightExpression);
			}
		}
		throw new CompileError("> is between strings and ints");
	}

	public void emit(ArrayList<Instruction> instructions) {
		leftExpression.emit(instructions);
		leftExpression.load(instructions);

		rightExpression.emit(instructions);
		rightExpression.load(instructions);

		operand = Environment.registerTable.addTemporaryRegister(null);
		instructions.add(GreaterEqualInstruction.getInstruction((VirtualRegister) operand, leftExpression.operand, rightExpression.operand));
	}
}
