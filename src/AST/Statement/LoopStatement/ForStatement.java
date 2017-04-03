package AST.Statement.LoopStatement;

import AST.Expression.ConstantExpression.BoolConstant;
import AST.Expression.Expression;
import AST.Statement.Statement;
import AST.Type.BasicType.BoolType;
import Error.CompileError;

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
		}
		throw new CompileError("if-condition should be a bool-type");
	}

	public void addInc(Expression inc) {
		this.inc = inc;
	}

	public void addStatement(Statement statement) {
		this.statement = statement;
	}
}
