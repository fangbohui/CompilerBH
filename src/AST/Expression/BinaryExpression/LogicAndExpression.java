package AST.Expression.BinaryExpression;

import AST.Expression.ConstantExpression.BoolConstant;
import AST.Expression.Expression;
import AST.Type.BasicType.BoolType;
import AST.Type.Type;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.AddInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.AndInstruction;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.BranchInstruction;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.JumpInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.LabelInstruction;
import CFG.Instruction.MemoryInstruction.MoveInstruction;
import CFG.Operand.ImmediatelyNumber;
import CFG.Operand.VirtualRegister;
import Environment.Environment;
import Error.CompileError;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-3.
 */
public class LogicAndExpression extends BinaryExpression {
	private LogicAndExpression(Type type, boolean isLV, Expression leftExpression, Expression rightExpression) {
		super(type, isLV, leftExpression, rightExpression);
	}

	public static Expression getExpression(Expression leftExpression, Expression rightExpression) {
		if (leftExpression.type instanceof BoolType && rightExpression.type instanceof BoolType) {
			if (leftExpression instanceof BoolConstant && rightExpression instanceof BoolConstant) {
				boolean v1 = ((BoolConstant) leftExpression).value;
				boolean v2 = ((BoolConstant) rightExpression).value;
				return BoolConstant.getConstant(v1 && v2);
			}
			return new LogicAndExpression(BoolType.getType(), false, leftExpression, rightExpression);
		}
		throw new CompileError("you are doing '&&' on 2 different types");
	}

	public void emit(ArrayList<Instruction> instructions) {
		LabelInstruction leftTrue = (LabelInstruction) LabelInstruction.getInstruction("leftTrue");
		LabelInstruction leftFalse = (LabelInstruction) LabelInstruction.getInstruction("leftFalse");
		LabelInstruction mergeBranch = (LabelInstruction) LabelInstruction.getInstruction("mergeBranch");

		leftExpression.emit(instructions);
		leftExpression.load(instructions);
		instructions.add(BranchInstruction.getInstruction(leftExpression.operand, leftTrue, leftFalse));

		instructions.add(leftTrue);
		rightExpression.emit(instructions);
		rightExpression.load(instructions);
		operand = rightExpression.operand;
		instructions.add(JumpInstruction.getInstruction(mergeBranch));

		instructions.add(leftFalse);
		instructions.add(MoveInstruction.getInstruction(operand, new ImmediatelyNumber(0)));
		instructions.add(JumpInstruction.getInstruction(mergeBranch));

		instructions.add(mergeBranch);
	}
}
