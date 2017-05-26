package AST.Statement;

import AST.Expression.ConstantExpression.BoolConstant;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.BranchInstruction;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.JumpInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.LabelInstruction;
import Error.CompileError;
import AST.Expression.Expression;
import AST.Type.BasicType.BoolType;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class IfStatement extends Statement {
	public Expression condition;
	public Statement positiveStatement, negativeStatement;

	private IfStatement(Expression condition, Statement positiveStatement, Statement negativeStatement) {
		this.condition = condition;
		this.positiveStatement = positiveStatement;
		this.negativeStatement = negativeStatement;
	}

	public static Statement getStatement(Expression condition, Statement positiveStatement, Statement negativeStatement) {
		if (condition instanceof BoolConstant) {
			if (((BoolConstant)condition).value) {
				return positiveStatement;
			} else {
				return negativeStatement;
			}
		}
		if (condition.type instanceof BoolType) {
			return new IfStatement(condition, positiveStatement, negativeStatement);
		}
		throw new CompileError("If-condition should be a bool");
	}

	public void emit(ArrayList<Instruction> instructions) {
		LabelInstruction ifTrue = (LabelInstruction) LabelInstruction.getInstruction("ifTrue");
		LabelInstruction ifFalse = (LabelInstruction) LabelInstruction.getInstruction("ifFalse");
		LabelInstruction ifMerge = (LabelInstruction) LabelInstruction.getInstruction("ifMerge");

		condition.emit(instructions);
		condition.load(instructions);
		instructions.add(BranchInstruction.getInstruction(condition.operand, ifTrue, ifFalse));

		instructions.add(ifTrue);
		if (positiveStatement != null) {
			positiveStatement.emit(instructions);
		}
		instructions.add(JumpInstruction.getInstruction(ifMerge));

		instructions.add(ifFalse);
		if (negativeStatement != null) {
			negativeStatement.emit(instructions);
		}
		instructions.add(JumpInstruction.getInstruction(ifMerge));

		instructions.add(ifMerge);
	}
}
