package AST.Type.MemberClass;

import AST.Function;

/**
 * Created by fangbohui on 17-4-2.
 */
public class MemberFunction extends Member {
	public Function function;
	public MemberFunction(String name, Function function) {
		super(name);
		this.function = function;
	}
}
