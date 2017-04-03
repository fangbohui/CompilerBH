package Error;

import Listener.BaseListener;

public class CompileError extends Error {
	public CompileError(String errorMessage) {
		super("Compilation error:" + BaseListener.row + ":" + BaseListener.column + ": " + errorMessage + "!");
	}
}