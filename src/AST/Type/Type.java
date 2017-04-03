package AST.Type;

import AST.Node;

public abstract class Type implements Node {
	public abstract Boolean equalTo(Type other);
}
