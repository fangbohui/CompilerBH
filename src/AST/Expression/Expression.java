package AST.Expression;

import AST.Node;
import AST.Type.Type;

/**
 * Created by fangbohui on 17-4-2.
 */
public abstract class Expression implements Node {
	public Type type;
	public Boolean isLeftValue;

	public Expression(Type type, Boolean isLeftValue) {
		this.type = type;
		this.isLeftValue = isLeftValue;
	}
}
