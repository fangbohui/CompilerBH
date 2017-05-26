package Translator;

import AST.Function;
import Environment.Environment;

import java.io.PrintStream;

/**
 * Created by fangbohui on 17-5-24.
 */
public abstract class NASM_Translator extends Translator {
	public NASM_Translator(PrintStream output) {
		super(output);
	}

	@Override
	public void translate() throws Exception {
		output.printf("\tdefault rel\n");
		for (Function function : Environment.program.functionList) {
			output.printf("\tglobal %s\n", function.name);
		}
		output.printf("\textern malloc\n");
		output.printf("\textern printf\n");
		output.printf("\textern puts\n");

		output.printf("\tSECTION .text");

		for (Function function : Environment.program.functionList) {
			translate(function.graph);
		}
	}
}
