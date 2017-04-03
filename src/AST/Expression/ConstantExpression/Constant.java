package AST.Expression.ConstantExpression;

import AST.Expression.Expression;
import AST.Type.Type;

/**
 * Created by fangbohui on 17-4-2.
 */
public abstract class Constant extends Expression {
	public Constant(Type type) {
		super(type, false);
	}
}
