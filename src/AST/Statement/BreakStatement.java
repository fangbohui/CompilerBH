package AST.Statement;

import AST.Statement.LoopStatement.LoopStatement;
import Environment.Environment;
import Error.CompileError;

/**
 * Created by fangbohui on 17-4-2.
 */
public class BreakStatement extends Statement {
	public LoopStatement goal;

	private BreakStatement(LoopStatement goal) {
		this.goal = goal;
	}

	public static Statement getStatement() {
		if (Environment.scopeTable.loopStatementTop() == null) {
			throw new CompileError("break should be in the loop");
		}
		return new BreakStatement(Environment.scopeTable.loopStatementTop());
	}
}
