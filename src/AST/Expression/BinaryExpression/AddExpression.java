package AST.Expression.BinaryExpression;

import AST.Expression.ConstantExpression.IntConstant;
import AST.Expression.ConstantExpression.StringConstant;
import AST.Expression.Expression;
import AST.Expression.FunctionCallExpression;
import AST.Function;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.AddInstruction;
import CFG.Instruction.Instruction;
import CFG.Operand.VirtualRegister;
import Environment.Environment;
import Error.CompileError;
import AST.Type.BasicType.IntType;
import AST.Type.BasicType.StringType;
import AST.Type.Type;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class AddExpression extends BinaryExpression {
	private AddExpression(Type type, Boolean isLV, Expression leftExpression, Expression rightExpression) {
		super(type, isLV, leftExpression, rightExpression);
	}
	public static Expression getExpression(Expression leftExpression, Expression rightExpression) {
		if (leftExpression.type instanceof IntType && rightExpression.type instanceof IntType) {
			if (leftExpression instanceof IntConstant && rightExpression instanceof IntConstant) {
				int v1 = ((IntConstant) leftExpression).value;
				int v2 = ((IntConstant) rightExpression).value;
				return IntConstant.getConstant(v1 + v2);
			}
			return new AddExpression(IntType.getType(), false, leftExpression, rightExpression);
		} else if (leftExpression.type instanceof StringType && rightExpression.type instanceof StringType) {
			if (leftExpression instanceof StringConstant && rightExpression instanceof  StringConstant) {
				String v1 = ((StringConstant) leftExpression).string;
				String v2 = ((StringConstant) rightExpression).string;
				return StringConstant.getConstant(v1 + v2);
			}
			return FunctionCallExpression.getExpression(
					(Function)Environment.symbolTable.get("FBH_string_connect").type,
					new ArrayList<Expression>() {{
						add(leftExpression);
						add(rightExpression);
					}}
			);
		}
		throw new CompileError("+ should between int or string");
	}

	public void emit(ArrayList<Instruction> instructions) {
		leftExpression.emit(instructions);
		leftExpression.load(instructions);

		rightExpression.emit(instructions);
		rightExpression.load(instructions);

		operand = Environment.registerTable.addTemporaryRegister(null);
		instructions.add(AddInstruction.getInstruction((VirtualRegister) operand, leftExpression.operand, rightExpression.operand));
	}
}
