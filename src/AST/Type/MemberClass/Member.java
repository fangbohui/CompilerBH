package AST.Type.MemberClass;

import AST.Type.ClassType;
import Environment.*;
import AST.Type.*;

/**
 * Created by fangbohui on 17-4-2.
 */
public abstract class Member {
	public String name;
	public ClassType scope;

	Member(String name) {
		this.name = name;
		this.scope = Environment.scopeTable.classTypeTop();
 	}
}
