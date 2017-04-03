package AST;

import java.util.ArrayList;
import java.util.List;

import AST.Statement.VarStatement;
import Environment.Scope;
import AST.Type.*;

public class Program implements Node, Scope {
	public List<Function> functionList;
	public List<ClassType> classTypeList;
	public List<VarStatement> varList;

	private Program() {
		functionList = new ArrayList<>();
		classTypeList = new ArrayList<>();
		varList = new ArrayList<>();
	}

	public static Program getProgram() {
		return new Program();
	}

	public void addClassType(ClassType classType) {
		classTypeList.add(classType);
	}

	public void addVarDefinition(VarStatement var) {
		varList.add(var);
	}

	public void addfunction(Function function) {
		functionList.add(function);
	}

}
