package Translator;

import AST.Function;
import CFG.Block;
import CFG.Graph;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.BinaryInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.EqualityInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.MULMODInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.*;
import CFG.Instruction.ComputingInstruction.ComputingInstruction;
import CFG.Instruction.ComputingInstruction.UnaryInstruction.OtherUnaryInstruction.UnaryMinusInstruction;
import CFG.Instruction.ComputingInstruction.UnaryInstruction.UnaryInstruction;
import CFG.Instruction.ControlInstruction.ControlInstruction;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.BranchInstruction;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.JumpInstruction;
import CFG.Instruction.FunctionInstruction.FunctionCallInstruction;
import CFG.Instruction.FunctionInstruction.FunctionInstruction;
import CFG.Instruction.FunctionInstruction.ReturnInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.MemoryInstruction.*;
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
		return String.format("qword [global_var_%s]", register.symbol.name);
	}

	private String temporaryVarName(int offset) {
		return String.format("qword [rbp-%s]", offset);
	}

	private String parameterVarName(int offset) {
		return String.format("qword [rbp-%s]", offset);
	}

	private void load(PhysicalRegister dest, Operand src) {
		if (src instanceof ImmediatelyNumber) {
			output.printf("\tmov\t\t%s, %s\n", dest.name, String.valueOf(((ImmediatelyNumber) src).value));
		} else if (src instanceof StringRegister) {
			output.printf("\tmov\t\t%s, %s\n", dest.name, ((StringRegister) src).message());
		} else if (src instanceof VarRegister) {
			if (src instanceof GlobalRegister) {
				output.printf("\tmov\t\t%s, %s\n", dest.name, globalVarName((GlobalRegister) src));
			}
			if (src instanceof TemporaryRegister) {
				output.printf("\tmov\t\t%s, %s\n", dest.name, temporaryVarName(graph.frame.getOffset(src)));
			}
			if (src instanceof ParameterRegister) {
				output.printf("\tmov\t\t%s, %s\n", dest.name, parameterVarName(graph.frame.getOffset(src)));
			}
		}
	}

	private void store(PhysicalRegister src, VirtualRegister dest) {
		if (dest instanceof VarRegister) {
			if (dest instanceof GlobalRegister) {
				output.printf("\tmov\t\t%s, %s\n", globalVarName((GlobalRegister) dest), src.name);
			}
			if (dest instanceof TemporaryRegister) {
				output.printf("\tmov\t\t%s, %s\n", temporaryVarName(graph.frame.getOffset(dest)), src.name);
			}
			if (dest instanceof ParameterRegister) {
				output.printf("\tmov\t\t%s, %s\n", parameterVarName(graph.frame.getOffset(dest)), src.name);
			}
		}
	}

	@Override
	public void translate(Graph graph) {
		this.graph = graph;
		output.printf("\n");
		output.printf("%s:\n", graph.function.name);
		output.printf("\tpush\trbp\n");
		output.printf("\tmov\t\trbp, rsp\n");

		for (int i = 0; i < graph.blockList.size(); i ++) {
			Block block = graph.blockList.get(i);
			output.printf("%s:\n", blockName(block));
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
							output.printf("\tcmp\t\trdx, rax\n");
							output.printf("\t%s\t\tal\n", binaryInstruction.OPname());
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
						} else if (binaryInstruction instanceof LeftShiftInstruction || binaryInstruction instanceof RightShiftInstruction) {
							load(NASMRegister.rax, binaryInstruction.src1);
							load(NASMRegister.rcx, binaryInstruction.src2);
							output.printf("\t%s\t\trax, cl\n", binaryInstruction.OPname());
							store(NASMRegister.rax, binaryInstruction.dest);
						} else {
							load(NASMRegister.rax, binaryInstruction.src1);
							load(NASMRegister.rdx, binaryInstruction.src2);
							output.printf("\t%s\t\trax, rdx\n", binaryInstruction.OPname());
							store(NASMRegister.rax, binaryInstruction.dest);
						}
					}
				} else if (instruction instanceof ControlInstruction) {
					if (instruction instanceof BranchInstruction) {
						load(NASMRegister.rax, ((BranchInstruction) instruction).condition);
						output.printf("\ttest\trax, rax\n");
						output.printf("\tjz\t\t%s\n", ((BranchInstruction) instruction).falseDest.labelName());
						output.printf("\tjmp\t\t%s\n", ((BranchInstruction) instruction).trueDest.labelName());
					} else if (instruction instanceof JumpInstruction) {
						output.printf("\tjmp\t\t%s\n", ((JumpInstruction) instruction).dest.labelName());
					}
				} else if (instruction instanceof FunctionInstruction) {
					if (instruction instanceof ReturnInstruction) {
						load(NASMRegister.rax, ((ReturnInstruction) instruction).src);
						output.printf("\tleave\n");
						output.printf("\tret\n");
					} else if (instruction instanceof FunctionCallInstruction) {
						FunctionCallInstruction callInstruction = (FunctionCallInstruction) instruction;

						if (callInstruction.function.name.startsWith("FBH")) {
							if (callInstruction.parameters.size() >= 1) {
								load(NASMRegister.rdi, callInstruction.parameters.get(0));
							}
							if (callInstruction.parameters.size() >= 2) {
								load(NASMRegister.rsi, callInstruction.parameters.get(1));
							}
							if (callInstruction.parameters.size() >= 3) {
								load(NASMRegister.rdx, callInstruction.parameters.get(2));
							}
							if (callInstruction.parameters.size() >= 4) {
								load(NASMRegister.rcx, callInstruction.parameters.get(3));
							}
						} else {
							for (int p = callInstruction.parameters.size() - 1; p >= 0; p--) {
								int offset = graph.frame.getOffset(callInstruction.parameters.get(p));
								output.printf("\tpush\tqword [rbp-%d]\n", offset);
							}
						}
						output.printf("\tcall\t%s\n", callInstruction.function.name);
						if (callInstruction.dest != null) {
							store(NASMRegister.rax, callInstruction.dest);
						}
					}
				} else if (instruction instanceof MemoryInstruction) {
					if (instruction instanceof AllocateInstruction) {
						AllocateInstruction allocateInstruction = (AllocateInstruction) instruction;
						load(NASMRegister.rdi, allocateInstruction.size);
						output.printf("\tcall\tmalloc\n");
						store(NASMRegister.rax, allocateInstruction.dest);
					} else if (instruction instanceof LoadInstruction) {
						LoadInstruction loadInstruction = (LoadInstruction) instruction;
						load(NASMRegister.rax, loadInstruction.src.base);
						load(NASMRegister.rdx, loadInstruction.src.index);
						output.printf("\tmov\t\trax [rax + rdx*4]\n");
						store(NASMRegister.rax, loadInstruction.dest);
					} else if (instruction instanceof MoveInstruction) {
						MoveInstruction moveInstruction = (MoveInstruction) instruction;
						load(NASMRegister.rax, moveInstruction.src);
						store(NASMRegister.rax, moveInstruction.dest);
					} else if (instruction instanceof StoreInstruction) {
						StoreInstruction storeInstruction = (StoreInstruction) instruction;
						load(NASMRegister.rax, storeInstruction.dest.base);
						load(NASMRegister.rdx, storeInstruction.dest.index);
						output.printf("\tmov\t\trax [rax + rdx*4]\n");
						store(NASMRegister.rax, storeInstruction.dest.base);
					}
				}
				output.printf("\n");
			}
		}

		output.printf("\tpop \trbp\n");
		output.printf("\tret\n");
	}
}
