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

	private void dealWithDimension(Type type, Operand operand, int curDimension, int dimension, ArrayList<Instruction> instructions) {
		ArrayType arrayType = (ArrayType) type;
		VirtualRegister size = Environment.registerTable.addTemporaryRegister(null);
		VirtualRegister vr = Environment.registerTable.addTemporaryRegister(null);
		//get correct size
		instructions.add(MultiplyInstruction.getInstruction(size, expressions.get(curDimension).operand, new ImmediatelyNumber(8)));
		instructions.add(AddInstruction.getInstruction(size, size, new ImmediatelyNumber(8)));
		instructions.add(AllocateInstruction.getInstruction(vr, size));
		instructions.add(MinusInstruction.getInstruction(size, size, new ImmediatelyNumber(8)));

		instructions.add(StoreInstruction.getInstruction(expressions.get(curDimension).operand, new Address(vr, new ImmediatelyNumber(0), 8)));
		instructions.add(AddInstruction.getInstruction(vr, vr, new ImmediatelyNumber(8)));
		if (operand instanceof VirtualRegister) {
			instructions.add(MoveInstruction.getInstruction(operand, vr));
		} else if (operand instanceof Address) {
			instructions.add(StoreInstruction.getInstruction(vr, (Address) operand));
		}

		if (curDimension == expressions.size() - 1) {
			if (!(arrayType.reduce() instanceof ClassType)) {
				return;
			}
		}

		VirtualRegister dest = Environment.registerTable.addTemporaryRegister(null);
		instructions.add(AddInstruction.getInstruction(dest, vr, size));
		VirtualRegister condition = Environment.registerTable.addTemporaryRegister(null);


		LabelInstruction whileBody = (LabelInstruction) LabelInstruction.getInstruction("whileBody");
		LabelInstruction loopBegin = (LabelInstruction) LabelInstruction.getInstruction("whileCondition");
		LabelInstruction loopMerge = (LabelInstruction) LabelInstruction.getInstruction("whileMerge");
		instructions.add(JumpInstruction.getInstruction(loopBegin));


		instructions.add(loopBegin);
		instructions.add(NotEqualToInstruction.getInstruction(condition, vr, dest));
		instructions.add(BranchInstruction.getInstruction(condition, whileBody, loopMerge));

		instructions.add(whileBody);
		if (curDimension != dimension - 1) {
			dealWithDimension(arrayType.reduce(), new Address(vr, new ImmediatelyNumber(0), 8), curDimension + 1, dimension, instructions);
		} else if (curDimension == expressions.size() - 1) {
			ClassType classType = (ClassType) arrayType.reduce();
			VirtualRegister tmp = Environment.registerTable.addTemporaryRegister(null);
			instructions.add(AllocateInstruction.getInstruction(tmp, new ImmediatelyNumber(classType.totalSize)));
			instructions.add(StoreInstruction.getInstruction(tmp, new Address(vr, new ImmediatelyNumber(0), 8)));
			if (classType.constructor != null) {
				ArrayList<Operand> parameters = new ArrayList<>();
				parameters.add(tmp);
				instructions.add(FunctionCallInstruction.getInstruction(null, classType.constructor, parameters));
			}
		}
		instructions.add(AddInstruction.getInstruction(vr, vr, new ImmediatelyNumber(8)));
		instructions.add(JumpInstruction.getInstruction(loopBegin));

		instructions.add(loopMerge);
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
		if (expressions.size() == 0) {
			if (type instanceof ClassType) {
				ClassType classType = (ClassType) type;
				instructions.add(AllocateInstruction.getInstruction((VirtualRegister) operand, new ImmediatelyNumber(classType.totalSize)));
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
			return;
		}
		if (dimension == 0) {
			throw new CompileError("there should be at least a expression");
		}
		dealWithDimension(type, operand, 0, dimension, instructions);
	}
}
