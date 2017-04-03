package Environment;

import AST.Type.ClassType;
import Error.CompileError;
import java.util.HashMap;
import java.util.Map;

public class ClassTable {
	private HashMap<String, ClassType> classTypeHashMap;

	public ClassTable() {
		classTypeHashMap = new HashMap<>();
	}

	public void put(String name, ClassType classType) {
		if (classTypeHashMap.containsKey(name)) {
			throw new CompileError("you're asking for 2 same-name classes");
		}
		classTypeHashMap.put(name, classType);
	}

	public ClassType get(String name) {
		return classTypeHashMap.get(name);
	}

	public boolean containsName(String name) {
		return classTypeHashMap.containsKey(name);
	}
}
