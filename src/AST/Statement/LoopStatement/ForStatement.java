package AST.Statement.LoopStatement;

import AST.Expression.ConstantExpression.BoolConstant;
import AST.Expression.Expression;
import AST.Statement.Statement;
import AST.Type.BasicType.BoolType;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.BranchInstruction;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.JumpInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.LabelInstruction;
import Error.CompileError;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class ForStatement extends LoopStatement {
	public Expression init, condition, inc;
	public Statement statement;

	public static Statement getStatement() {
		return new ForStatement();
	}

	public void addInit(Expression init) {
		this.init = init;
	}

	public void addCondition(Expression condition) {
		if (condition == null) {
			this.condition = BoolConstant.getConstant(true);
		} else if (condition.type instanceof BoolType) {
			this.condition = condition;
		} else {
			throw new CompileError("if-condition should be a bool-type");
		}
	}

	public void addInc(Expression inc) {
		this.inc = inc;
	}

	public void addStatement(Statement statement) {
		this.statement = statement;
	}

	public void emit(ArrayList<Instruction> instructions) {
		LabelInstruction forCondition = (LabelInstruction) LabelInstruction.getInstruction("forCondition");
		LabelInstruction forBody = (LabelInstruction) LabelInstruction.getInstruction("forBody");
		loopBegin = (LabelInstruction) LabelInstruction.getInstruction("forIncrease");
		loopMerge = (LabelInstruction) LabelInstruction.getInstruction("forMerge");

		if (init != null) {
			init.emit(instructions);
			init.load(instructions);
		}
		instructions.add(JumpInstruction.getInstruction(forCondition));

		instructions.add(forCondition);
		if (condition == null) {
			addCondition(null);
		}
		condition.emit(instructions);
		instructions.add(BranchInstruction.getInstruction(condition.operand, loopBegin, loopMerge));

		instructions.add(forBody);
		if (statement != null) {
			statement.emit(instructions);
		}
		instructions.add(JumpInstruction.getInstruction(loopBegin));

		instructions.add(loopBegin);
		if (inc != null) {
			inc.emit(instructions);
		}
		instructions.add(JumpInstruction.getInstruction(forCondition));

		instructions.add(loopMerge);
	}
}
