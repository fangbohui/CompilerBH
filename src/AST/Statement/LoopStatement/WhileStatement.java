package AST.Statement.LoopStatement;

import AST.Expression.Expression;
import AST.Statement.Statement;
import AST.Type.BasicType.BoolType;
import Error.CompileError;

/**
 * Created by fangbohui on 17-4-2.
 */
public class WhileStatement extends LoopStatement {
	public Expression condition;
	public Statement statement;

	public static Statement getStatement() {
		return new WhileStatement();
	}

	public void addCondition(Expression condition) {
		if (!(condition.type instanceof BoolType)) {
			throw new CompileError("you're putting a non-bool type on the whileStatement");
		}
		this.condition = condition;
	}

	public void addStatement(Statement statement) {
		this.statement = statement;
	}
}
