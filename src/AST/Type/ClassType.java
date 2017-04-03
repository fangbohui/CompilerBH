package AST.Type;

import AST.Function;
import AST.Node;
import AST.Type.BasicType.NullType;
import AST.Type.MemberClass.*;
import Environment.Scope;
import Error.CompileError;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fangbohui on 17-4-2.
 */
public class ClassType extends Type implements Scope {
	public String name;
	public Map<String, MemberVar> memberVarMap;
	public Map<String, MemberFunction> memberFunctionMap;
	public Function constructor;

	private ClassType(String name) {
		this.name = name;
		memberVarMap = new HashMap<>();
		memberFunctionMap = new HashMap<>();
		constructor = null;
	}

	public static Type getType(String name) {
		return new ClassType(name);
	}

	public void addMember(String name, Type type) {
		if (memberFunctionMap.containsKey(name) || memberVarMap.containsKey(name)) {
			throw new CompileError("repeating member names in a class");
		}
		if (type instanceof Function) {
			Function function = (Function)type;
			function.name = this.name + '.' + function.name;
			MemberFunction memberFunction = new MemberFunction(name, function);
			memberFunctionMap.put(name, memberFunction);
		} else {
			MemberVar memberVar = new MemberVar(name, type);
			memberVarMap.put(name, memberVar);
		}
	}

	public void addConstructor(Function function) {
		if (constructor != null) {
			throw new CompileError("You have 2 constructions in a class");
		}
		if (function.parameters.size() != 0) {
			throw new CompileError("A constructor should have no parameters");
		}
		function.name = this.name + '.' + function.name;
		constructor = function;
	}

	public Member getMember(String name) {
		Member member = null;
		if (memberVarMap.containsKey(name)) {
			member = memberVarMap.get(name);
		}
		if (memberFunctionMap.containsKey(name)) {
			member = memberFunctionMap.get(name);
		}
		if (member == null) {
			throw new CompileError("There is no such a member! QAQ");
		}
		return member;
	}


	@Override
	public Boolean equalTo(Type other) {
		return other instanceof NullType || other == this;
	}
}
