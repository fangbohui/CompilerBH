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
public abstract class NASM_Translator extends Translator {
	public NASM_Translator(PrintStream output) {
		super(output);
	}

	@Override
	public void translate() throws Exception {
		output.printf("\tdefault rel\n\n");
		for (Function function : Environment.program.functionList) {
			output.printf("\tglobal %s\n", function.name);
		}
		for (VarStatement varStatement : Environment.program.varList) {
			output.printf("\tglobal global_var_%s\n", varStatement.symbol.name);
		}
		output.printf("\n");
		output.printf("\textern malloc\n");
		output.printf("\textern printf\n");
		output.printf("\textern puts\n");
		output.printf("\n");
		output.printf("\tSECTION .text\n");

		for (Function function : Environment.program.functionList) {
			translate(function.graph);
		}
		output.printf("\n\tSECTION .text\n");
		for (VirtualRegister register : Environment.registerTable.registers) {
			if (register instanceof StringRegister) {
				String string = ((StringRegister) register).string;
				output.printf("%s:\n", ((StringRegister) register).message());
				output.printf("\tdb\t\t\"%s\", 0\n", string);
			}
		}
	}
}
