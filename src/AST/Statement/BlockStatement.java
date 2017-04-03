package AST.Statement;

import Environment.Scope;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class BlockStatement extends Statement implements Scope {
	public ArrayList<Statement> statements;

	private BlockStatement() {
		statements = new ArrayList<>();
	}

	public static Statement getStatement() {
		return new BlockStatement();
	}

	public void addStatement(Statement statement) {
		statements.add(statement);
	}
}
