package Environment;

import AST.Type.Type;
import CFG.Operand.VirtualRegister;

/**
 * Created by fangbohui on 17-4-1.
 */
public class Symbol {
	public String name;
	public Type type;
	public Scope scope;
	public VirtualRegister register;

	public Symbol(String name, Type type) {
		this.name = name;
		this.type = type;
		this.scope = Environment.scopeTable.top();
		this.register = null;
	}
}
