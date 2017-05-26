package AST.Expression.UnaryExpression;

import AST.Expression.Expression;
import AST.Type.Type;
import CFG.Instruction.Instruction;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public abstract class UnaryExpression extends Expression {
	public Expression expression;

	public UnaryExpression(Type type, Boolean isLeftValue, Expression expression) {
		super(type, isLeftValue);
		this.expression = expression;
	}

	public abstract void emit(ArrayList<Instruction> instructions);
}
