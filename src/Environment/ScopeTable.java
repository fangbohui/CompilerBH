package Environment;

import AST.Type.ClassType;
import AST.Function;
import AST.Statement.LoopStatement.LoopStatement;
import java.util.Stack;

/**
 * Created by fangbohui on 17-4-1.
 */
public class ScopeTable {
	private Stack<Scope> scopes;
	private Stack<Function> functionScopes;
	private Stack<ClassType> classScopes;
	private Stack<LoopStatement> loopScopes;

	public ScopeTable() {
		scopes = new Stack<>();
		functionScopes = new Stack<>();
		classScopes = new Stack<>();
		loopScopes = new Stack<>();
	}

	public void enterScope(Scope scope) {
		scopes.push(scope);
		if (scope instanceof Function) {
			functionScopes.push((Function)scope);
		}
		if (scope instanceof ClassType) {
			classScopes.push((ClassType)scope);
		}
		if (scope instanceof LoopStatement) {
			loopScopes.push((LoopStatement)scope);
		}
	}

	public void exitScope() {
		if (scopes.empty()) {
			throw new InternalError();
		}
		Scope scope = scopes.pop();
		if (scope instanceof Function) {
			if (functionScopes.empty()) {
				throw new InternalError();
			}
			functionScopes.pop();
		}
		if (scope instanceof ClassType) {
			if (classScopes.empty()) {
				throw new InternalError();
			}
			classScopes.pop();
		}
		if (scope instanceof LoopStatement) {
			if (loopScopes.empty()) {
				throw new InternalError();
			}
			loopScopes.pop();
		}
	}

	public Scope top() {
		if (scopes.empty()) {
			return null;
		}
		return scopes.peek();
	}

	public Function functionTop() {
		if (functionScopes.empty()) {
			return null;
		}
		return functionScopes.peek();
	}

	public ClassType classTypeTop() {
		if (classScopes.empty()) {
			return null;
		}
		return classScopes.peek();
	}

	public LoopStatement loopStatementTop() {
		if (loopScopes.empty()) {
			return null;
		}
		return loopScopes.peek();
	}

}
