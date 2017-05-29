package Translator;

import CFG.Block;
import CFG.Graph;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.BinaryInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.EqualityInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.DivideInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.LeftShiftInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.ModInstruction;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.OtherBinaryInstructions.RightShiftInstruction;
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
import CFG.RegisterAllocator;

import java.io.PrintStream;

/**
 * Created by fangbohui on 17-5-24.
 */
public class NASM_Powerful_Translator extends NASM_Translator {
	public Graph graph;
	public RegisterAllocator allocator;

	public NASM_Powerful_Translator(PrintStream output) {
		super(output);
	}

	private String globalVarName(GlobalRegister register) {
		return String.format("qword [global_var_%s]", register.symbol.name);
	}

	private String temporaryVarName(int offset) {
		return String.format("qword [rbp-%d]", offset);
	}

	private String parameterVarName(int offset) {
		return String.format("qword [rbp+%d]", offset + 8);
	}

	private PhysicalRegister loadToSrc(PhysicalRegister dest, Operand src) {
		if (src instanceof ImmediatelyNumber) {
			output.printf("\tmov\t\t%s, %s\n", dest.name, String.valueOf(((ImmediatelyNumber) src).value));
		} else if (src instanceof StringRegister) {
			output.printf("\tmov\t\t%s, %s\n", dest.name, ((StringRegister) src).message());
		} else if (src instanceof VarRegister) {
			if (src instanceof GlobalRegister) {
				output.printf("\tmov\t\t%s, %s\n", dest.name, globalVarName((GlobalRegister) src));
			}
			if (src instanceof TemporaryRegister) {
				int b = 4;
				PhysicalRegister register = allocator.allocating.get(src);
				if (register == null) {
					output.printf("\tmov\t\t%s, %s\n", dest.name, temporaryVarName(graph.frame.getOffset(src)));
				} else {
					return register;
				}
			}
			if (src instanceof ParameterRegister) {
				output.printf("\tmov\t\t%s, %s\n", dest.name, parameterVarName(graph.frame.getOffset(src)));
			}
		}
		return dest;
	}

	private PhysicalRegister loadToDest(PhysicalRegister dest, VirtualRegister src) {
		if (src instanceof TemporaryRegister) {
			int a = 3;
			PhysicalRegister register = allocator.allocating.get(src);
			if (register == null) {
				output.printf("\tmov\t\t%s, %s\n", dest.name, temporaryVarName(graph.frame.getOffset(src)));
			} else {
				return register;
			}
		}
		return dest;
	}

	private void store(PhysicalRegister src, VirtualRegister dest) {
		if (dest instanceof VarRegister) {
			if (dest instanceof GlobalRegister) {
				output.printf("\tmov\t\t%s, %s\n", globalVarName((GlobalRegister) dest), src.name);
			}
			if (dest instanceof TemporaryRegister) {
				PhysicalRegister register = allocator.allocating.get(src);
				if (register == null) {
					output.printf("\tmov\t\t%s, %s\n", temporaryVarName(graph.frame.getOffset(dest)), src.name);
				}
			}
			if (dest instanceof ParameterRegister) {
				output.printf("\tmov\t\t%s, %s\n", parameterVarName(graph.frame.getOffset(dest)), src.name);
			}
		}
	}

	private void move(PhysicalRegister dest, Operand src) {
		if (src instanceof ImmediatelyNumber) {
			output.printf("\tmov\t\t%s, %s\n", dest.name, String.valueOf(((ImmediatelyNumber) src).value));
		} else if (src instanceof StringRegister) {
			output.printf("\tmov\t\t%s, %s\n", dest.name, ((StringRegister) src).message());
		} else if (src instanceof VarRegister) {
			if (src instanceof GlobalRegister) {
				output.printf("\tmov\t\t%s, %s\n", dest.name, globalVarName((GlobalRegister) src));
			}
			if (src instanceof TemporaryRegister) {
				PhysicalRegister register = allocator.allocating.get(src);
				if (register == null) {
					output.printf("\tmov\t\t%s, %s\n", dest.name, temporaryVarName(graph.frame.getOffset(src)));
				} else {
					if (register != dest) {
						output.printf("\tmov\t\t%s, %s\n", dest.name, register.name);
					}
				}
			}
			if (src instanceof ParameterRegister) {
				output.printf("\tmov\t\t%s, %s\n", dest.name, parameterVarName(graph.frame.getOffset(src)));
			}
		}
	}

	private void move(VirtualRegister dest, PhysicalRegister src) {
		if (dest instanceof VarRegister) {
			if (dest instanceof GlobalRegister) {
				output.printf("\tmov\t\t%s, %s\n", globalVarName((GlobalRegister) dest), src.name);
			}
			if (dest instanceof TemporaryRegister) {
				PhysicalRegister register = allocator.allocating.get(dest);
				if (register == null) {
					output.printf("\tmov\t\t%s, %s\n", temporaryVarName(graph.frame.getOffset(dest)), src.name);
				} else {
					if (register != src) {
						output.printf("\tmov\t\t%s, %s\n", register.name, src.name);
					}
				}
			}
			if (dest instanceof ParameterRegister) {
				output.printf("\tmov\t\t%s, %s\n", parameterVarName(graph.frame.getOffset(dest)), src.name);
			}
		}
	}

	@Override
	public void translate(Graph graph) {
		this.graph = graph;
		this.allocator = graph.function.allocator;
		output.printf("\n");
		output.printf("%s:\n", graph.function.name);
		output.printf("\tpush\trbp\n");
		output.printf("\tmov\t\trbp, rsp\n");
		output.printf("\tsub\t\trsp, %d\n", graph.frame.size);
		if (!graph.function.name.equals("main")) {
			for (PhysicalRegister register : allocator.getUsedRegisters()) {
				output.printf("\tmov\t\tqword[rsp-%d], %s\n", register.id * 8, register.name);
			}
		}

		for (int i = 0; i < graph.blockList.size(); i ++) {
			Block block = graph.blockList.get(i);
			output.printf("%s:\n", blockName(block));
			int cnt = -1;
			for (Instruction instruction : block.instructions) {
				++ cnt;
				if (instruction instanceof ComputingInstruction) {
					if (instruction instanceof UnaryInstruction) {
						UnaryInstruction unaryInstruction = (UnaryInstruction) instruction;
						PhysicalRegister src = loadToSrc(NASMRegister.rax, unaryInstruction.src);
						PhysicalRegister dest = loadToDest(NASMRegister.rdx, unaryInstruction.dest);
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
							loadToSrc(NASMRegister.rdx, binaryInstruction.src1);
							loadToSrc(NASMRegister.rax, binaryInstruction.src2);
							output.printf("\tcmp\t\trdx, rax\n");
							output.printf("\t%s\t\tal\n", binaryInstruction.OPname());
							output.printf("\tmovzx\teax, al\n");
							store(NASMRegister.rax, binaryInstruction.dest);
						} else if (binaryInstruction instanceof DivideInstruction) {
							loadToSrc(NASMRegister.rax, binaryInstruction.src1);
							loadToSrc(NASMRegister.rcx, binaryInstruction.src2);
							output.printf("\tcqo\n");
							output.printf("\tidiv\trcx\n");
							store(NASMRegister.rax, binaryInstruction.dest);
						} else if (binaryInstruction instanceof ModInstruction) {
							loadToSrc(NASMRegister.rax, binaryInstruction.src1);
							loadToSrc(NASMRegister.rcx, binaryInstruction.src2);
							output.printf("\tcqo\n");
							output.printf("\tidiv\trcx\n");
							store(NASMRegister.rdx, binaryInstruction.dest);
						} else if (binaryInstruction instanceof LeftShiftInstruction || binaryInstruction instanceof RightShiftInstruction) {
							loadToSrc(NASMRegister.rax, binaryInstruction.src1);
							loadToSrc(NASMRegister.rcx, binaryInstruction.src2);
							output.printf("\t%s\t\trax, cl\n", binaryInstruction.OPname());
							store(NASMRegister.rax, binaryInstruction.dest);
						} else {
							loadToSrc(NASMRegister.rax, binaryInstruction.src1);
							loadToSrc(NASMRegister.rcx, binaryInstruction.src2);
							output.printf("\t%s\t\trax, rcx\n", binaryInstruction.OPname());
							store(NASMRegister.rax, binaryInstruction.dest);
						}
					}
				} else if (instruction instanceof ControlInstruction) {
					if (instruction instanceof BranchInstruction) {
						loadToSrc(NASMRegister.rax, ((BranchInstruction) instruction).condition);
						output.printf("\ttest\trax, rax\n");
						output.printf("\tjz\t\t%s\n", ((BranchInstruction) instruction).falseDest.labelName());
						output.printf("\tjmp\t\t%s\n", ((BranchInstruction) instruction).trueDest.labelName());
					} else if (instruction instanceof JumpInstruction) {
						output.printf("\tjmp\t\t%s\n", ((JumpInstruction) instruction).dest.labelName());
					}
				} else if (instruction instanceof FunctionInstruction) {
					if (instruction instanceof ReturnInstruction) {
						loadToSrc(NASMRegister.rax, ((ReturnInstruction) instruction).src);
						output.printf("\tleave\n");
						output.printf("\tret\n");
					} else if (instruction instanceof FunctionCallInstruction) {
						FunctionCallInstruction callInstruction = (FunctionCallInstruction) instruction;
						int totalSize = callInstruction.parameters.size() * 8;
						totalSize += totalSize % 16;
						if (callInstruction.function.name.startsWith("FBH")) {
							if (callInstruction.parameters.size() >= 1) {
								move(NASMRegister.rdi, callInstruction.parameters.get(0));
							}
							if (callInstruction.parameters.size() >= 2) {
								move(NASMRegister.rsi, callInstruction.parameters.get(1));
							}
							if (callInstruction.parameters.size() >= 3) {
								move(NASMRegister.rdx, callInstruction.parameters.get(2));
							}
							if (callInstruction.parameters.size() >= 4) {
								move(NASMRegister.rcx, callInstruction.parameters.get(3));
							}
						} else {
							output.printf("\tsub\t\trsp, %d\n", totalSize);
							for (int p = callInstruction.parameters.size() - 1; p >= 0; p--) {
								loadToSrc(NASMRegister.rax, callInstruction.parameters.get(p));
								output.printf("\tmov\t\tqword[rsp+%d], rax\n", p * 8);
							}
						}
						output.printf("\tcall\t%s\n", callInstruction.function.name);
						if (callInstruction.dest != null) {
							move(callInstruction.dest, NASMRegister.rax);
						}
						if (!callInstruction.function.name.startsWith("FBH")) {
							output.printf("\tadd\t\trsp, %d\n", totalSize);
						}
					}
				} else if (instruction instanceof MemoryInstruction) {
					if (instruction instanceof AllocateInstruction) {
						AllocateInstruction allocateInstruction = (AllocateInstruction) instruction;
						move(NASMRegister.rdi, allocateInstruction.size);
						output.printf("\tcall\tmalloc\n");
						store(NASMRegister.rax, allocateInstruction.dest);
					} else if (instruction instanceof LoadInstruction) {
						LoadInstruction loadInstruction = (LoadInstruction) instruction;
						loadToSrc(NASMRegister.rax, loadInstruction.src.base);
						loadToSrc(NASMRegister.rdx, loadInstruction.src.index);
						output.printf("\tmov\t\trax, [rax + rdx*8]\n");
						store(NASMRegister.rax, loadInstruction.dest);
					} else if (instruction instanceof MoveInstruction) {
						MoveInstruction moveInstruction = (MoveInstruction) instruction;
						loadToSrc(NASMRegister.rax, moveInstruction.src);
						store(NASMRegister.rax, moveInstruction.dest);
					} else if (instruction instanceof StoreInstruction) {
						StoreInstruction storeInstruction = (StoreInstruction) instruction;
						loadToSrc(NASMRegister.rax, storeInstruction.dest.base);
						loadToSrc(NASMRegister.rdx, storeInstruction.dest.index);
						output.printf("\timul\trdx, 8\n");
						output.printf("\tadd\t\trax, rdx\n");
						loadToSrc(NASMRegister.rdx, storeInstruction.src);
						output.printf("\tmov\t\t[rax], rdx\n");
					}
				}
				output.printf("\n");
			}
		}
		if (!graph.function.name.equals("main")) {
			for (PhysicalRegister register : allocator.getUsedRegisters()) {
				output.printf("\tmov\t\t%s, qword[rsp-%d]\n", register.name, register.id * 8);
			}
		}
		output.printf("\tleave\n");
		output.printf("\tret\n");
	}
}