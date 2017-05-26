package AST.Expression;

import AST.Function;
import AST.Type.ArrayType;
import AST.Type.ClassType;
import AST.Type.Type;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.AddInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.MultiplyInstruction;
import CFG.Instruction.FunctionInstruction.FunctionCallInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.MemoryInstruction.AllocateInstruction;
import CFG.Instruction.MemoryInstruction.MoveInstruction;
import CFG.Instruction.MemoryInstruction.StoreInstruction;
import CFG.Operand.Address;
import CFG.Operand.ImmediatelyNumber;
import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;
import Environment.Environment;
import Error.CompileError;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.List;

public class NewExpression extends Expression {
	public List<Expression> expressions;
	public Function constructor;

	private NewExpression(Type type, boolean isLV, List<Expression> expressions) {
		super(type, isLV);
		this.expressions = expressions;
		this.constructor = null;
	}

	public static Expression getExpression(Type type, List<Expression> dimensionExpressions) {
		if (dimensionExpressions.isEmpty()) {
			if (type instanceof ClassType) {
				return new NewExpression(type, false, dimensionExpressions);
			}
			throw new CompileError("you are newing some non-class-nor-array things");
		} else {
			Type arrayType = ArrayType.getType(type, dimensionExpressions.size());
			return new NewExpression(arrayType, false, dimensionExpressions);
		}
	}

	public void emit(ArrayList<Instruction> instructions) {
		return;
		/*
		for (Expression expression : expressions) {
			if (expression != null) {
				expression.emit(instructions);
				expression.load(instructions);
			}
		}

		operand = Environment.registerTable.addTemporaryRegister(null);
		if (type instanceof ArrayType) {
			ArrayType arrayType = (ArrayType) type;
			VirtualRegister size = Environment.registerTable.addTemporaryRegister(null);
			instructions.add(MultiplyInstruction.getInstruction(size, expressions.get(0).operand, new ImmediatelyNumber(8)));
			instructions.add(AddInstruction.getInstruction(size, size, new ImmediatelyNumber(4)));
			instructions.add(AllocateInstruction.getInstruction((VirtualRegister) operand, size));
			instructions.add(StoreInstruction.getInstruction(expressions.get(0).operand, new Address((VirtualRegister) operand, 8)));
			instructions.add(AddInstruction.getInstruction((VirtualRegister) operand, operand, new ImmediatelyNumber(8)));
		} else { // ClassType
			ClassType classType = (ClassType) type;
			instructions.add(AllocateInstruction.getInstruction((VirtualRegister) operand, new ImmediatelyNumber(classType.totalSize)));
			if (constructor == null) {
				if (classType.constructor != null) {
					constructor = classType.constructor;
				} else {
					throw new CompileError("this class doesn't have a constructor!");
				}
			}
			if (constructor != null) {
				ArrayList<Operand> parameters = new ArrayList<>();
				parameters.add(operand);
				instructions.add(FunctionCallInstruction.getInstruction(null, constructor, parameters));
			}
		}
		*/
	}
}
