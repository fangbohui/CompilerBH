package Environment;

import AST.Type.Type;
import java.util.HashMap;
import java.util.Stack;
import Error.CompileError;

public class SymbolTable {
	private HashMap<String, Stack<Symbol>> stringStack;
	private Stack<HashMap<String, Symbol>> symbolTable;

	public SymbolTable() {
		stringStack = new HashMap<>();
		symbolTable = new Stack<>();
	}

	public Symbol add(String name, Type type) {
		if (symbolTable.peek().containsKey(name)) {
			throw new CompileError("repeating name " + name);
		}
		if (!stringStack.containsKey(name)) {
			stringStack.put(name, new Stack<>());
		}
		Symbol symbol = new Symbol(name, type);
		stringStack.get(name).push(symbol);
		symbolTable.peek().put(name, symbol);
		return symbol;
	}

	public Symbol get(String name) {
		return stringStack.get(name).peek();
	}

	public boolean containsName(String name) {
		return (stringStack.containsKey(name)) && (!stringStack.get(name).empty());
	}

	public void enterScope() {
		symbolTable.push(new HashMap<>());
	}

	public void exitScope() {
		symbolTable.pop().forEach((name, symbol) -> stringStack.get(name).pop());
	}
}
