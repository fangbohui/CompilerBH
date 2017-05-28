package Translator;

import AST.Function;
import AST.Statement.VarStatement;
import CFG.Operand.StringRegister;
import CFG.Operand.VirtualRegister;
import Environment.Environment;

import java.io.PrintStream;

/**
 * Created by fangbohui on 17-5-24.
 */
public class NASM_Translator extends Translator {
	public NASM_Translator(PrintStream output) {
		super(output);
	}

	public void translate() throws Exception {
		output.printf("\tdefault rel\n\n");
		for (Function function : Environment.program.functionList) {
			output.printf("\tglobal %s\n", function.name);
		}
		output.printf("\n");
		output.printf("extern printf, malloc, strcpy, scanf, strlen, sscanf, sprintf, memcpy, strcmp, puts\n");
		output.printf("\n");
		output.printf("\tSECTION .text\n");

		for (Function function : Environment.program.functionList) {
			translate(function.graph);
			output.printf("\n");
		}
		output.printf("\n%s\n", getBuiltinFunction());

		output.println(getDataSection());
		output.println(getBssSection());
	}
}
