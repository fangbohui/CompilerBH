package Translator;

import AST.Statement.VarStatement;
import CFG.Graph;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.EqualityInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.*;
import CFG.Operand.ImmediatelyNumber;
import CFG.Operand.StringRegister;
import CFG.Operand.VirtualRegister;
import Environment.Environment;

import java.io.PrintStream;

/**
 * Created by fangbohui on 17-5-24.
 */
public class Translator {
	public static PrintStream output;
	public static int rsp_offset;

	public Translator(PrintStream ooutput) {
		output = ooutput;
		rsp_offset = 0;
	}

	public static String getInstruction(String type) {
		return String.format("%8s\n", type);
	}

	public static String getInstruction(String type, String operand) {
		if (type.equals("push")) {
			rsp_offset++;
		}
		if (type.equals("pop")) {
			rsp_offset--;
		}
		return String.format("%8s %20s\n", type, operand);
	}

	public static String getInstruction(String type, String operand1, String operand2) {
		if (type.equals("mov") && operand1.equals(operand2)) {
			return "";
		}
		return String.format("%8s %20s, %20s\n", type, operand1, operand2);
	}

	public static String getCall(String func) {
		StringBuilder str = new StringBuilder();
		if (rsp_offset % 2 == 1) {
			str.append(Translator.getInstruction("sub", "rsp", "8"));
			str.append(Translator.getInstruction("call", func));
			str.append(Translator.getInstruction("add", "rsp", "8"));
		} else {
			str.append(Translator.getInstruction("call", func));
		}
		return str.toString();
	}

	static public String getDataSection() {
		StringBuilder str = new StringBuilder();
		str.append("SECTION .data\n");

		for (VirtualRegister register : Environment.registerTable.registers) {
			if (register instanceof StringRegister) {
				String string = ((StringRegister) register).string;
				str.append(Translator.getInstruction("dq", String.valueOf(string.length())));
				str.append(((StringRegister) register).message() + ":\n");
				str.append(Translator.getInstruction("db", Translator.getStringConst(string)));
			}
		}
		str.append("__println_IntFormat:\n");
		str.append(Translator.getInstruction("db", "\"%ld\", 10, 0"));
		str.append("__print_IntFormat:\n");
		str.append(Translator.getInstruction("db", "\"%ld\", 0"));
		str.append("__printFormat:\n");
		str.append(Translator.getInstruction("db", "\"%s\", 0"));
		str.append("__getIntFormat:\n");
		str.append(Translator.getInstruction("db", "\"%ld\", 0"));
		str.append("__getStringFormat:\n");
		str.append(Translator.getInstruction("db", "\"%s\", 0"));
		str.append("__toStringFormat:\n");
		str.append(Translator.getInstruction("db", "\"%ld\", 0"));
		str.append("__parseIntFormat:\n");
		str.append(Translator.getInstruction("db", "\"%ld\", 0"));
		return str.toString();
	}

	static public String getBssSection() {
		StringBuilder str = new StringBuilder();
		str.append("SECTION .bss\n");
		for (VarStatement varStatement : Environment.program.varList) {
			str.append(String.format("global_var_%s:\n", varStatement.symbol.name));
			str.append(Translator.getInstruction("resq", "1"));
		}
		str.append("@getIntBuf:\n");
		str.append(Translator.getInstruction("resq", "1"));
		str.append("@parseIntBuf:\n");
		str.append(Translator.getInstruction("resq", "1"));
		return str.toString();
	}

	static public String getStringConst(String s) {
		StringBuilder str = new StringBuilder();
		str.append('\"');
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '\\') {
				str.append("\", ");
				if (s.charAt(i + 1) == 'n')
					str.append("10");
				if (s.charAt(i + 1) == '\"')
					str.append("34");
				if (s.charAt(i + 1) == '\\')
					str.append("92");
				str.append(", \"");
				i++;
			} else {
				str.append(s.charAt(i));
			}
		}
		str.append("\", 0");
		return str.toString();
	}

	static public String getBuiltinFunction() {
		StringBuilder str = new StringBuilder();
		//print_Int
		str.append(Translator.getNASMprint("print_Int"));
		//println_Int
		str.append(Translator.getNASMprint("println_Int"));
		//print
		str.append(Translator.getNASMprint("FBH_print"));
		//println
		str.append(Translator.getNASMprintln());
		//getInt
		str.append(Translator.getNASMgetInt());
		//getString
		str.append(Translator.getNASMgetString());
		//toString
		str.append(Translator.getNASMtoString());
		//arraySize
		str.append(Translator.getNASMarraySize());
		//stringLength
		str.append(Translator.getNASMstringLength());
		//stringParseInt
		str.append(Translator.getNASMstringParseInt());
		//stringSubstring
		str.append(Translator.getNASMstringSubstring());
		//stringOrd
		str.append(Translator.getNASMstringOrd());
		//stringConnection
		str.append(Translator.getNASMstringConnection());
		//stringCompare
		VirtualRegister useless = Environment.registerTable.addTemporaryRegister(null);
		ImmediatelyNumber number1 = new ImmediatelyNumber(233);
		ImmediatelyNumber number2 = new ImmediatelyNumber(233);
		str.append(Translator.getNASMstringCompare((EqualityInstruction) EqualToInstruction.getInstruction(useless, number1, number2)));
		str.append(Translator.getNASMstringCompare((EqualityInstruction) NotEqualToInstruction.getInstruction(useless, number1, number2)));
		str.append(Translator.getNASMstringCompare((EqualityInstruction) GreaterInstruction.getInstruction(useless, number1, number2)));
		str.append(Translator.getNASMstringCompare((EqualityInstruction) GreaterEqualInstruction.getInstruction(useless, number1, number2)));
		str.append(Translator.getNASMstringCompare((EqualityInstruction) LessInstruction.getInstruction(useless, number1, number2)));
		str.append(Translator.getNASMstringCompare((EqualityInstruction) LessEqualInstruction.getInstruction(useless, number1, number2)));
		return str.toString();
	}

	static public String getNASMprint(String Format) {
		StringBuilder str = new StringBuilder();
		str.append(Format + ":\n");
		rsp_offset = 1;
		str.append(Translator.getInstruction("mov", "rsi", "rdi"));
		str.append(Translator.getInstruction("mov", "rdi", "__" + "print" + "Format"));
		str.append(Translator.getCall("printf"));
		str.append(Translator.getInstruction("ret"));

		return str.toString();
	}

	static public String getNASMprintln() {
		StringBuilder str = new StringBuilder();
		str.append("FBH_println:\n");
		str.append(Translator.getCall("puts"));
		str.append(Translator.getInstruction("ret"));

		return str.toString();
	}

	static public String getNASMgetInt() {
		StringBuilder str = new StringBuilder();
		str.append("FBH_getInt:\n");
		rsp_offset = 1;
		str.append(Translator.getInstruction("mov", "rdi", "__getIntFormat"));
		str.append(Translator.getInstruction("mov", "rsi", "@getIntBuf"));
		str.append(Translator.getCall("scanf"));
		str.append(Translator.getInstruction("mov", "rax", "qword [@getIntBuf]"));
		str.append(Translator.getInstruction("ret"));
		return str.toString();
	}

	static public String getNASMgetString() {
		StringBuilder str = new StringBuilder();
		str.append("FBH_getString:\n");
		rsp_offset = 1;
		str.append(Translator.getInstruction("push", "r15"));
		str.append(Translator.getInstruction("mov", "rdi", "300"));
		str.append(Translator.getCall("malloc"));
		str.append(Translator.getInstruction("mov", "r15", "rax"));
		str.append(Translator.getInstruction("add", "r15", "8"));
		str.append(Translator.getInstruction("mov", "rdi", "__getStringFormat"));
		str.append(Translator.getInstruction("mov", "rsi", "r15"));
		str.append(Translator.getCall("scanf"));
		str.append(Translator.getInstruction("mov", "rdi", "r15"));
		str.append(Translator.getCall("strlen"));
		str.append(Translator.getInstruction("mov", "qword [r15 - 8]", "rax"));
		str.append(Translator.getInstruction("mov", "rax", "r15"));
		str.append(Translator.getInstruction("pop", "r15"));
		str.append(Translator.getInstruction("ret"));
		return str.toString();
	}

	static public String getNASMtoString() {
		StringBuilder str = new StringBuilder();
		str.append("FBH_toString:\n");
		rsp_offset = 1;
		str.append(Translator.getInstruction("push", "r15"));
		str.append(Translator.getInstruction("push", "rdi"));
		str.append(Translator.getInstruction("mov", "rdi", "20"));
		str.append(Translator.getCall("malloc"));
		str.append(Translator.getInstruction("mov", "r15", "rax"));
		str.append(Translator.getInstruction("add", "r15", "8"));
		str.append(Translator.getInstruction("mov", "rdi", "r15"));
		str.append(Translator.getInstruction("mov", "rsi", "__toStringFormat"));
		str.append(Translator.getInstruction("pop", "rdx"));
		str.append(Translator.getCall("sprintf"));
		str.append(Translator.getInstruction("mov", "rdi", "r15"));
		str.append(Translator.getCall("strlen"));
		str.append(Translator.getInstruction("mov", "qword [r15 - 8]", "rax"));
		str.append(Translator.getInstruction("mov", "rax", "r15"));
		str.append(Translator.getInstruction("pop", "r15"));
		str.append(Translator.getInstruction("ret"));
		return str.toString();
	}

	static public String getNASMarraySize() {
		StringBuilder str = new StringBuilder();
		str.append("FBH_array_size:\n");
		str.append(Translator.getInstruction("mov", "rax", "qword [rdi - 8]"));
		str.append(Translator.getInstruction("ret"));
		return str.toString();
	}

	static public String getNASMstringLength() {
		StringBuilder str = new StringBuilder();
		str.append("FBH_string_length:\n");
		str.append(Translator.getInstruction("mov", "rax", "qword [rdi - 8]"));
		str.append(Translator.getInstruction("ret"));
		return str.toString();
	}

	static public String getNASMstringParseInt() {
		StringBuilder str = new StringBuilder();
		str.append("FBH_string_parseInt:\n");
		rsp_offset = 1;
		str.append(Translator.getInstruction("mov", "rsi", "__getIntFormat"));
		str.append(Translator.getInstruction("mov", "rdx", "@parseIntBuf"));
		str.append(Translator.getCall("sscanf"));
		str.append(Translator.getInstruction("mov", "rax", "qword [@parseIntBuf]"));
		str.append(Translator.getInstruction("ret"));
		return str.toString();
	}

	static public String getNASMstringSubstring() {
		StringBuilder str = new StringBuilder();
		str.append("FBH_string_substring:\n");
		rsp_offset = 1;
		str.append(Translator.getInstruction("push", "r15"));
		str.append(Translator.getInstruction("push", "r14"));
		str.append(Translator.getInstruction("mov", "r15", "rdi"));
		str.append(Translator.getInstruction("add", "r15", "rsi"));
		str.append(Translator.getInstruction("mov", "r14", "rdx"));
		str.append(Translator.getInstruction("sub", "r14", "rsi"));
		str.append(Translator.getInstruction("add", "r14", "1"));
		str.append(Translator.getInstruction("mov", "rdi", "r14"));
		str.append(Translator.getInstruction("add", "rdi", "9"));
		str.append(Translator.getCall("malloc"));
		str.append(Translator.getInstruction("add", "rax", "8"));
		str.append(Translator.getInstruction("mov", "rdi", "rax"));
		str.append(Translator.getInstruction("mov", "rsi", "r15"));
		str.append(Translator.getInstruction("mov", "rdx", "r14"));
		str.append(Translator.getCall("memcpy"));
		str.append(Translator.getInstruction("mov", "qword [rax - 8]", "r14"));
		str.append(Translator.getInstruction("mov", "r15", "rax"));
		str.append(Translator.getInstruction("add", "r15", "r14"));
		str.append(Translator.getInstruction("mov", "r15", "0"));
		str.append(Translator.getInstruction("pop", "r14"));
		str.append(Translator.getInstruction("pop", "r15"));
		str.append(Translator.getInstruction("ret"));
		return str.toString();
	}

	static public String getNASMstringOrd() {
		StringBuilder str = new StringBuilder();
		str.append("FBH_string_ord:\n");
		rsp_offset = 1;
		str.append(Translator.getInstruction("add", "rdi", "rsi"));
		str.append(Translator.getInstruction("movsx", "rax", "byte [rdi]"));
		str.append(Translator.getInstruction("ret"));
		return str.toString();
	}

	static public String getNASMstringConnection() {
		StringBuilder str = new StringBuilder();
		str.append("FBH_string_connect:\n");
		rsp_offset = 1;
		str.append(Translator.getInstruction("push", "r15"));//length -> result
		str.append(Translator.getInstruction("push", "r14"));//left
		str.append(Translator.getInstruction("push", "r13"));//right
		str.append(Translator.getInstruction("mov", "r15", "qword [rdi - 8]"));
		str.append(Translator.getInstruction("add", "r15", "qword [rsi - 8]"));
		str.append(Translator.getInstruction("add", "r15", "9"));
		str.append(Translator.getInstruction("mov", "r14", "rdi"));
		str.append(Translator.getInstruction("mov", "r13", "rsi"));
		str.append(Translator.getInstruction("mov", "rdi", "r15"));
		str.append(Translator.getCall("malloc"));
		str.append(Translator.getInstruction("sub", "r15", "9"));
		str.append(Translator.getInstruction("mov", "qword [rax]", "r15"));
		str.append(Translator.getInstruction("mov", "r15", "rax"));
		str.append(Translator.getInstruction("add", "r15", "8"));
		str.append(Translator.getInstruction("mov", "rdi", "r15"));
		str.append(Translator.getInstruction("mov", "rsi", "r14"));
		str.append(Translator.getCall("strcpy"));
		str.append(Translator.getInstruction("add", "r15", "qword [r14 - 8]"));
		str.append(Translator.getInstruction("mov", "r14", "rax"));
		str.append(Translator.getInstruction("mov", "rdi", "r15"));
		str.append(Translator.getInstruction("mov", "rsi", "r13"));
		str.append(Translator.getCall("strcpy"));
		str.append(Translator.getInstruction("mov", "rax", "r14"));
		str.append(Translator.getInstruction("pop", "r13"));
		str.append(Translator.getInstruction("pop", "r14"));
		str.append(Translator.getInstruction("pop", "r15"));
		str.append(Translator.getInstruction("ret"));
		return str.toString();
	}

	static public String getNASMstringCompare(EqualityInstruction equalityInstruction) {
		StringBuilder str = new StringBuilder();
		str.append("FBH_string_" + equalityInstruction.symbolName() + ":\n");
		rsp_offset = 1;
		str.append(Translator.getCall("strcmp"));
		str.append(Translator.getInstruction("cmp", "eax", "0"));
		str.append(Translator.getInstruction("mov", "rax", "0"));
		str.append(Translator.getInstruction(equalityInstruction.OPname(), "al"));
		str.append(Translator.getInstruction("ret"));
		return str.toString();
	}


	public void translate(Graph graph) {
	}
	public void translate() throws Exception {
	}
}
