package AST.Expression;

import AST.Function;
import AST.Type.ArrayType;
import AST.Type.ClassType;
import AST.Type.Type;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.AddInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.MinusInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.MultiplyInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.NotEqualToInstruction;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.BranchInstruction;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.JumpInstruction;
import CFG.Instruction.FunctionInstruction.FunctionCallInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.LabelInstruction;
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
import com.sun.org.apache.xpath.internal.operations.Minus;
import jdk.nashorn.internal.ir.EmptyNode;

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

	private Address dealWithDimension(Type type, VirtualRegister operand, int curDimension, int dimension, ArrayList<Instruction> instructions) {
		if (curDimension == expressions.size()) {
			if (type instanceof ClassType) {
				ClassType classType = (ClassType) type;
				instructions.add(AllocateInstruction.getInstruction(operand, new ImmediatelyNumber(classType.totalSize)));
				if (constructor == null) {
					if (classType.constructor != null) {
						constructor = classType.constructor;
					}
				}
				if (constructor != null) {
					ArrayList<Operand> parameters = new ArrayList<>();
					parameters.add(operand);
					instructions.add(FunctionCallInstruction.getInstruction(null, constructor, parameters));
				}
			}
			return new Address(operand, 8);
		}
		ArrayType arrayType = (ArrayType) type;
		VirtualRegister size = Environment.registerTable.addTemporaryRegister(null);
		//get correct size
		instructions.add(MultiplyInstruction.getInstruction(size, expressions.get(curDimension).operand, new ImmediatelyNumber(8)));
		instructions.add(AddInstruction.getInstruction(size, size, new ImmediatelyNumber(8)));
		instructions.add(AllocateInstruction.getInstruction(operand, size));
		instructions.add(MinusInstruction.getInstruction(size, size, new ImmediatelyNumber(8)));

		Address address = new Address(operand, 8);
		instructions.add(StoreInstruction.getInstruction(size, address));
		instructions.add(AddInstruction.getInstruction(operand, operand, new ImmediatelyNumber(8)));

		VirtualRegister cur = Environment.registerTable.addTemporaryRegister(null);
		instructions.add(MoveInstruction.getInstruction(cur, operand));
		VirtualRegister dest = Environment.registerTable.addTemporaryRegister(null);
		instructions.add(AddInstruction.getInstruction(dest, operand, size));
		VirtualRegister condition = Environment.registerTable.addTemporaryRegister(null);

		//store the size && a[i] means a[i + 1]

		// do the rest job
		LabelInstruction whileBody = (LabelInstruction) LabelInstruction.getInstruction("whileBody");
		LabelInstruction loopBegin = (LabelInstruction) LabelInstruction.getInstruction("whileCondition");
		LabelInstruction loopMerge = (LabelInstruction) LabelInstruction.getInstruction("whileMerge");
		instructions.add(JumpInstruction.getInstruction(loopBegin));


		instructions.add(loopBegin);
		instructions.add(NotEqualToInstruction.getInstruction(condition, cur, dest));
		instructions.add(BranchInstruction.getInstruction(condition, whileBody, loopMerge));

		instructions.add(whileBody);
		if (curDimension != dimension - 1) {
			StoreInstruction.getInstruction(cur, dealWithDimension(arrayType.reduce(), cur, curDimension + 1, dimension, instructions));
		}
		instructions.add(AddInstruction.getInstruction(cur, cur, new ImmediatelyNumber(8)));
		instructions.add(JumpInstruction.getInstruction(loopBegin));

		instructions.add(loopMerge);
		return address;
	}

	public void emit(ArrayList<Instruction> instructions) {
//		return;
		int dimension = 0;
		for (Expression expression : expressions) {
			if (expression != null) {
				expression.emit(instructions);
				expression.load(instructions);
				dimension ++;
			}
		}
		operand = Environment.registerTable.addTemporaryRegister(null);
		dealWithDimension(type, (VirtualRegister) operand, 0, dimension, instructions);
	}
}
