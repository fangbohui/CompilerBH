package AST;

import AST.Statement.BlockStatement;
import AST.Type.*;
import AST.Type.BasicType.IntType;
import Environment.*;
import Error.CompileError;
import java.util.ArrayList;
import java.util.List;

public class Function extends Type implements Node, Scope {
	public String name;
	public Type type;
	public List<Symbol> parameters;
	public BlockStatement statements;

	private Function(String name, Type type, List<Symbol> parameters) {
		this.name = name;
		this.type = type;
		this.parameters = parameters;
	}

	public static Function getFunction(String name, Type returnType, List<Symbol> parameters) {
		if (Environment.scopeTable.classTypeTop() == null) { // not in any class but you want a function
			if (Environment.symbolTable.containsName(name)) {
				throw new CompileError("repeating function names");
			}
		}
		if (name.equals("main")) {
			if (!(returnType instanceof IntType)) {
				throw new CompileError("main function is returning without a int");
			}
			if (parameters.size() != 0) {
				throw new CompileError("main funciton should have no parameters");
			}
		} else {
			for (int i = 0; i < parameters.size(); i ++) {
				for (int j = i + 1; j < parameters.size(); j ++) {
					if (parameters.get(i).name.equals(parameters.get(j).name)) {
						throw new CompileError("a function has 2 same parameters");
					}
				}
			}
		}
		return new Function(name, returnType, parameters);
	}

	public List<Type> getParameterTypes() {
		List<Type> parametersTypes = new ArrayList<>();
		parameters.forEach(parameter -> parametersTypes.add(parameter.type));
		return parametersTypes;
	}

	public void addStatement(BlockStatement blockStatement) {
		this.statements = blockStatement;
	}

	public Boolean equalTo(Type other) {
		return false;
	}
}
