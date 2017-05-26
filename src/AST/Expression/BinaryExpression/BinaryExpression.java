package AST.Expression.BinaryExpression;

import AST.Expression.Expression;
import AST.Type.Type;
import CFG.Instruction.Instruction;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public abstract class BinaryExpression extends Expression {
	public Expression leftExpression;
	public Expression rightExpression;
	protected BinaryExpression(Type type, Boolean isLV, Expression leftExpression, Expression rightExpression) {
		super(type, isLV);
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}

	public abstract void emit(ArrayList<Instruction> instructions);
	public void load(ArrayList<Instruction> instructions) {}
}
