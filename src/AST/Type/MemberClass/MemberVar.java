package AST.Type.MemberClass;

import AST.Expression.Expression;
import AST.Type.Type;

/**
 * Created by fangbohui on 17-4-2.
 */
public class MemberVar extends Member {
	public Type type;
	public Expression expression;
	public MemberVar(String name, Type type) {
		super(name);
		this.type = type;
	}
}
