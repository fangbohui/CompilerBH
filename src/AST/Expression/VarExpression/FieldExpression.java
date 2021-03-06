package AST.Expression.VarExpression;

import AST.Expression.Expression;
import AST.Type.ArrayType;
import AST.Type.BasicType.StringType;
import AST.Type.ClassType;
import AST.Type.MemberClass.Member;
import AST.Type.MemberClass.MemberFunction;
import AST.Type.MemberClass.MemberVar;
import AST.Type.Type;
import CFG.Instruction.Instruction;
import CFG.Instruction.MemoryInstruction.LoadInstruction;
import CFG.Instruction.MemoryInstruction.MoveInstruction;
import CFG.Operand.Address;
import CFG.Operand.ImmediatelyNumber;
import CFG.Operand.VirtualRegister;
import Environment.Environment;
import Error.CompileError;
import Error.InternalError;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public class FieldExpression extends Expression {
	public Expression className;
	public String fieldName;

	private FieldExpression(Type type, Boolean isLV, Expression className, String fieldName) {
		super(type, isLV);
		this.className = className;
		this.fieldName = fieldName;
	}

	public static Expression getExpression(Expression className, String fieldName) {
		if (className.type instanceof ClassType) {
			ClassType classType = (ClassType)className.type;
			Member member = classType.getMember(fieldName);
			if (member instanceof MemberVar) {
				return new FieldExpression(((MemberVar)member).type, className.isLeftValue, className, fieldName);
			} else {
				return new FieldExpression(((MemberFunction)member).function, className.isLeftValue, className, fieldName);
			}
		} else if (className.type instanceof ArrayType){
			if (fieldName.equals("size")) {
				return new FieldExpression(Environment.symbolTable.get("FBH_array_size").type, className.isLeftValue, className, fieldName);
			}
			throw new CompileError("array cannot do that thing");
		} else if (className.type instanceof StringType) {
			if (fieldName.equals("length")) {
				return new FieldExpression(Environment.symbolTable.get("FBH_string_length").type, className.isLeftValue, className, fieldName);
			}
			else if (fieldName.equals("substring")) {
				return new FieldExpression(Environment.symbolTable.get("FBH_string_substring").type, className.isLeftValue, className, fieldName);
			}
			else if (fieldName.equals("parseInt")) {
				return new FieldExpression(Environment.symbolTable.get("FBH_string_parseInt").type, className.isLeftValue, className, fieldName);
			}
			else if (fieldName.equals("ord")) {
				return new FieldExpression(Environment.symbolTable.get("FBH_string_ord").type, className.isLeftValue, className, fieldName);
			}
			throw new CompileError("string cannot do that thing");
		}
		throw new InternalError();
	}

	public void emit(ArrayList<Instruction> instructions) {
		ClassType classType = (ClassType) className.type;
		Member member = classType.getMember(fieldName);
		if (member instanceof MemberVar) {
			MemberVar memberVar = (MemberVar) member;
			className.emit(instructions);
			className.load(instructions);
			VirtualRegister base = (VirtualRegister) className.operand;
			ImmediatelyNumber offset = new ImmediatelyNumber(memberVar.offset / 8);
			operand = new Address(base, offset, 8);
		}
	}

	@Override
	public void load(ArrayList<Instruction> instructions) {
		if (operand instanceof Address) {
			Address address = (Address) operand;
			operand = Environment.registerTable.addTemporaryRegister(null);
			instructions.add(LoadInstruction.getInstruction((VirtualRegister) operand, address));
		}
	}
}
