package AST.Expression.BinaryExpression;

import AST.Expression.ConstantExpression.BoolConstant;
import AST.Expression.ConstantExpression.IntConstant;
import AST.Expression.ConstantExpression.NullConstant;
import AST.Expression.ConstantExpression.StringConstant;
import AST.Expression.Expression;
import AST.Type.BasicType.BoolType;
import AST.Type.BasicType.IntType;
import AST.Type.BasicType.NullType;
import AST.Type.Type;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.AddInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.EqualToInstruction;
import CFG.Instruction.Instruction;
import CFG.Operand.VirtualRegister;
import Environment.Environment;
import Error.CompileError;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.beans.binding.BooleanExpression;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class EqualToExpression extends BinaryExpression {
	private EqualToExpression(Type type, Boolean isLV, Expression leftExpression, Expression rightExpression) {
		super(type, isLV, leftExpression, rightExpression);
	}
	public static Expression getExpression(Expression leftExpression, Expression rightExpression) {
		if (!leftExpression.type.equalTo(rightExpression.type)) {
			throw new CompileError("you're comparing two diffenrent types");
		}
		if (leftExpression instanceof NullConstant && rightExpression instanceof NullConstant) {
			return BoolConstant.getConstant(true);
		} else if (leftExpression instanceof IntConstant && rightExpression instanceof IntConstant) {
			int v1 = ((IntConstant) leftExpression).value;
			int v2 = ((IntConstant) rightExpression).value;
			return BoolConstant.getConstant(v1 == v2);
		} else if (leftExpression instanceof BoolConstant && rightExpression instanceof BoolConstant) {
			boolean v1 = ((BoolConstant) leftExpression).value;
			boolean v2 = ((BoolConstant) rightExpression).value;
			return BoolConstant.getConstant(v1 == v2);
		} else if (leftExpression instanceof StringConstant && rightExpression instanceof StringConstant) {
			String s1 = ((StringConstant) leftExpression).string;
			String s2 = ((StringConstant) rightExpression).string;
			return BoolConstant.getConstant(s1.equals(s2));
		} else {
			return new EqualToExpression(BoolType.getType(), false, leftExpression, rightExpression);
		}
	}

	public void emit(ArrayList<Instruction> instructions) {
		leftExpression.emit(instructions);
		leftExpression.load(instructions);

		rightExpression.emit(instructions);
		rightExpression.load(instructions);

		operand = Environment.registerTable.addTemporaryRegister(null);
		instructions.add(EqualToInstruction.getInstruction((VirtualRegister) operand, leftExpression.operand, rightExpression.operand));
	}
}
