package Translator;

import AST.Function;
import CFG.Block;
import CFG.Graph;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.BinaryInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.EqualityInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.MULMODInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.DivideInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.MinusInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.ModInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.MultiplyInstruction;
import CFG.Instruction.ComputingInstruction.ComputingInstruction;
import CFG.Instruction.ComputingInstruction.UnaryInstruction.OtherUnaryInstruction.UnaryMinusInstruction;
import CFG.Instruction.ComputingInstruction.UnaryInstruction.UnaryInstruction;
import CFG.Instruction.ControlInstruction.ControlInstruction;
import CFG.Instruction.FunctionInstruction.FunctionCallInstruction;
import CFG.Instruction.FunctionInstruction.FunctionInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.MemoryInstruction.MemoryInstruction;
import CFG.Operand.*;
import Environment.Environment;

import java.io.PrintStream;

/**
 * Created by fangbohui on 17-5-24.
 */
public class NASM_Naive_Translator extends NASM_Translator {
	public Graph graph;

	public NASM_Naive_Translator(PrintStream output) {
		super(output);
	}

	private String globalVarName(GlobalRegister register) {
		return String.format("qword [rel global_var_%s]", register.symbol.name);
	}

	private void load(PhysicalRegister dest, Operand src) {
		if (src instanceof ImmediatelyNumber) {
			output.printf("\tmov \t%s, %s\n", dest.name, String.valueOf(((ImmediatelyNumber) src).value));
		} else if (src instanceof StringRegister) {
			output.printf("\tmov \t%s, %s\n", dest.name, ((StringRegister) src).message());
		} else if (src instanceof VarRegister) {
			if (src instanceof GlobalRegister) {
				output.printf("\tmov \t%s, %s\n", dest.name, globalVarName((GlobalRegister) src));
			}
			if (src instanceof TemporaryRegister) {
				//output.printf("\tmov \t%s, qword [rel global_var_%s]\n", dest.name, ((GlobalRegister) src).symbol.name);
				// TODO
			}
			if (src instanceof ParameterRegister) {
				//output.printf();
				// TODO
			}
		}
	}

	private void store(PhysicalRegister src, VirtualRegister dest) {
		if (dest instanceof VarRegister) {
			if (dest instanceof GlobalRegister) {
				output.printf("\tmov \t%s, %s\n", globalVarName((GlobalRegister) dest), src.name);
			}
			if (dest instanceof TemporaryRegister) {}
			if (dest instanceof ParameterRegister) {}
		}
	}

	@Override
	public void translate(Graph graph) {
		this.graph = graph;
		output.printf("\n");
		output.printf("%s:\n", graph.function.name);
		output.printf("\tpush\trbp\n");
		output.printf("\tmov \trbp\n");

		for (int i = 0; i < graph.blockList.size(); i ++) {
			Block block = graph.blockList.get(i);
			output.printf("%s_%s:\n", graph.function.name, block.name);
			for (Instruction instruction : block.instructions) {
				if (instruction instanceof ComputingInstruction) {
					if (instruction instanceof UnaryInstruction) {
						UnaryInstruction unaryInstruction = (UnaryInstruction) instruction;
						load(NASMRegister.rax, unaryInstruction.src);
						if (unaryInstruction instanceof UnaryMinusInstruction) {
							output.printf("\t%s \trax\n", unaryInstruction.OPname());
						} else {
							output.printf("\ttest\trax, rax\n");
							output.printf("\tsete\tal\n");
							output.printf("\tmovzx\trax, al\n");
						}
						store(NASMRegister.rax, unaryInstruction.dest);
					} else if (instruction instanceof BinaryInstruction) {
						BinaryInstruction binaryInstruction = (BinaryInstruction) instruction;
						if (binaryInstruction instanceof EqualityInstruction) {
							load(NASMRegister.rdx, binaryInstruction.src1);
							load(NASMRegister.rax, binaryInstruction.src2);
							output.printf("\tcmp \trdx, rax\n");
							output.printf("\t%s \tal\n");
							output.printf("\tmovzx\teax, al\n");
							store(NASMRegister.rax, binaryInstruction.dest);
						} else if (binaryInstruction instanceof DivideInstruction) {
							load(NASMRegister.rax, binaryInstruction.src1);
							load(NASMRegister.rsi, binaryInstruction.src2);
							output.printf("\tcqo\n");
							output.printf("\tidiv\trsi\n");
							store(NASMRegister.rax, binaryInstruction.dest);
						} else if (binaryInstruction instanceof ModInstruction) {
							load(NASMRegister.rax, binaryInstruction.src1);
							load(NASMRegister.rcx, binaryInstruction.src2);
							output.printf("\tcqo\n");
							output.printf("\tidiv\trcx\n");
							store(NASMRegister.rdx, binaryInstruction.dest);
						} else {
							load(NASMRegister.rax, binaryInstruction.src1);
							load(NASMRegister.rdx, binaryInstruction.src2);
							output.printf("\t%s \trax, rdx\n", binaryInstruction.OPname());
							store(NASMRegister.rax, binaryInstruction.dest);
						}
					}
				} else if (instruction instanceof ControlInstruction) {

				} else if (instruction instanceof FunctionInstruction) {

				} else if (instruction instanceof MemoryInstruction) {

				}
			}
		}

		output.printf("\tpop \trbp\n");
		output.printf("\tret\n");
	}
}
