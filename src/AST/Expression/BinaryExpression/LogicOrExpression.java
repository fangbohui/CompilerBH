package AST.Expression.BinaryExpression;

import AST.Expression.ConstantExpression.BoolConstant;
import AST.Expression.Expression;
import AST.Type.BasicType.BoolType;
import AST.Type.Type;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.BranchInstruction;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.JumpInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.LabelInstruction;
import CFG.Instruction.MemoryInstruction.MoveInstruction;
import CFG.Operand.ImmediatelyNumber;
import Error.CompileError;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-3.
 */
public class LogicOrExpression extends BinaryExpression {
	private LogicOrExpression(Type type, boolean isLV, Expression leftExpression, Expression rightExpression) {
		super(type, isLV, leftExpression, rightExpression);
	}

	public static Expression getExpression(Expression leftExpression, Expression rightExpression) {
		if (leftExpression.type instanceof BoolType && rightExpression.type instanceof BoolType) {
			if (leftExpression instanceof BoolConstant && rightExpression instanceof BoolConstant) {
				boolean v1 = ((BoolConstant) leftExpression).value;
				boolean v2 = ((BoolConstant) rightExpression).value;
				return BoolConstant.getConstant(v1 || v2);
			}
			return new LogicOrExpression(BoolType.getType(), false, leftExpression, rightExpression);
		}
		throw new CompileError("you are doing '||' on 2 different types");
	}

	public void emit(ArrayList<Instruction> instructions) {
		LabelInstruction leftTrue = (LabelInstruction) LabelInstruction.getInstruction("leftTrue");
		LabelInstruction leftFalse = (LabelInstruction) LabelInstruction.getInstruction("leftFalse");
		LabelInstruction mergeBranch = (LabelInstruction) LabelInstruction.getInstruction("mergeBranch");

		leftExpression.emit(instructions);
		leftExpression.load(instructions);
		instructions.add(BranchInstruction.getInstruction(leftExpression.operand, leftTrue, leftFalse));

		instructions.add(leftTrue);
		operand = rightExpression.operand;
		instructions.add(MoveInstruction.getInstruction(operand, new ImmediatelyNumber(1)));
		instructions.add(JumpInstruction.getInstruction(mergeBranch));

		instructions.add(leftFalse);
		rightExpression.emit(instructions);
		rightExpression.load(instructions);
		instructions.add(JumpInstruction.getInstruction(mergeBranch));

		instructions.add(mergeBranch);
	}
}
