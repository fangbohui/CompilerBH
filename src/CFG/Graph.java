package CFG;

import AST.Function;
import AST.Statement.VarStatement;
import CFG.Instruction.ControlInstruction.ControlInstruction;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.BranchInstruction;
import CFG.Instruction.ControlInstruction.OtherControlInstruction.JumpInstruction;
import CFG.Instruction.Instruction;
import CFG.Instruction.LabelInstruction;
import CFG.Operand.TemporaryRegister;
import CFG.Operand.VirtualRegister;
import Environment.Symbol;
import Environment.Environment;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by fangbohui on 17-5-20.
 */
public class Graph {
	public Function function;
	public ArrayList<Block> blockList;
	public Block beginning, entry, exit;
	public Frame frame;

	public Graph(Function function) {
		this.function = function;
		this.initGraph();
	}

	private Block addBlock(String name, LabelInstruction labelInstruction) {
		Block block = new Block(function, name, blockList.size(), labelInstruction);
		blockList.add(block);
		return block;
	}

	public void livenessAnalysis() {
		for (Block block : blockList) {
			block.liveness.usedRegisters = new ArrayList<>();
			block.liveness.definedRegisters = new ArrayList<>();
			for (Instruction instruction : block.instructions) {
				for (VirtualRegister virtualRegister : instruction.getSrcRegisters()) {
					if (!block.liveness.definedRegisters.contains(virtualRegister)) {
						block.liveness.usedRegisters.add(virtualRegister);
					}
				}
				for (VirtualRegister virtualRegister : instruction.getDestRegisters()) {
					block.liveness.definedRegisters.add(virtualRegister);
				}
			}
		}
		for (Block block : blockList) {
			block.liveness.livein = new HashSet<>();
			block.liveness.liveout = new HashSet<>();
		}
		while (true) {
			for (Block block : blockList) {
				block.liveness.livein = new HashSet<>();
				for (VirtualRegister virtualRegister : block.liveness.liveout) {
					block.liveness.livein.add(virtualRegister);
				}
				for (VirtualRegister virtualRegister : block.liveness.definedRegisters) {
					block.liveness.livein.remove(virtualRegister);
				}
				for (VirtualRegister virtualRegister : block.liveness.usedRegisters) {
					block.liveness.livein.add(virtualRegister);
				}
			}
			boolean changed = false;
			for (Block block : blockList) {
				HashSet<VirtualRegister> last = block.liveness.liveout;
				block.liveness.liveout = new HashSet<>();
				for (Block succ : block.succ) {
					for (VirtualRegister virtualRegister : succ.liveness.livein) {
						block.liveness.liveout.add(virtualRegister);
					}
				}
				if (!block.liveness.liveout.equals(last)) {
					changed = true;
				}
			}
			if (!changed) {
				break;
			}
		}
	}

	private void computingFrame() {
		HashSet<VirtualRegister> registers = new HashSet<>();
		for (Block block : blockList) {
			for (Instruction instruction : block.instructions) {
				for (VirtualRegister virtualRegister : instruction.getDestRegisters()) {
					if (virtualRegister instanceof TemporaryRegister) {
						registers.add(virtualRegister);
					}
				}
				for (VirtualRegister virtualRegister : instruction.getSrcRegisters()) {
					if (virtualRegister instanceof TemporaryRegister) {
						registers.add(virtualRegister);
					}
				}
			}
		}
		frame = new Frame();
		for (Symbol parameter : function.parameters) {
			frame.size += 8;
			frame.parameters.put(parameter.register, frame.size);
		}
		for (VirtualRegister register : registers) {
			frame.size += 8;
			frame.temporary.put(register, frame.size);
		}
		frame.size += 16 * 8;
		if (frame.size % 16 != 0) {
			frame.size += 16 - frame.size % 16;
		}
	}

	private void initGraph() {
		ArrayList<Instruction> instructions = new ArrayList<>();
		function.beginning = (LabelInstruction) LabelInstruction.getInstruction("beginning");
		function.entry = (LabelInstruction) LabelInstruction.getInstruction("entry");
		function.exit = (LabelInstruction) LabelInstruction.getInstruction("exit");
		/**/
		instructions.add(function.beginning);
		if (function.name.equals("main")) {
			for (VarStatement varStatement : Environment.program.varList) {
				varStatement.emit(instructions);
			}
		}
		instructions.add(JumpInstruction.getInstruction(function.entry));
		/**/
		instructions.add(function.entry);
		function.statements.emit(instructions);
		instructions.add(JumpInstruction.getInstruction(function.exit));
		/**/
		instructions.add(function.exit);
		/**/

		blockList = new ArrayList<>();
		int i;
		int next = 0;
		for (i = 0; i < instructions.size(); i = next) {
			if (instructions.get(i) instanceof LabelInstruction) {
				LabelInstruction labelInstruction = (LabelInstruction) instructions.get(i);
				Block block = addBlock(labelInstruction.name, labelInstruction);
				labelInstruction.block = block;
				for (next = i + 1; next < instructions.size(); next ++) {
					if (instructions.get(next) instanceof LabelInstruction) {
						break;
					}
					block.instructions.add(instructions.get(next));
					if (instructions.get(next) instanceof ControlInstruction) {
						break;
					}
				}
			} else {
				next = i + 1;
			}
		}

		for (Block block : blockList) {
			if (block.name.equals("beginning")) {
				beginning = block;
			} else if (block.name.equals("entry")) {
				beginning = entry;
			} else if (block.name.equals("exit")) {
				beginning = exit;
			}
		}

		for (Block block : blockList) {
			if (block.instructions.size() == 0) {
				continue;
			}
			Instruction lastInstruction = block.instructions.get(block.instructions.size() - 1);
			if (!(lastInstruction instanceof ControlInstruction)) {
				continue;
			}
			if (lastInstruction instanceof JumpInstruction) {
				Block block1 = ((JumpInstruction) lastInstruction).dest.block;
				block.succ.add(block1);
				block1.pred.add(block);
			} else if (lastInstruction instanceof BranchInstruction) {
				Block block1 = ((BranchInstruction) lastInstruction).trueDest.block;
				Block block2 = ((BranchInstruction) lastInstruction).falseDest.block;
				block.succ.add(block1);
				block1.pred.add(block);
				block.succ.add(block2);
				block2.pred.add(block);
			}
		}

		computingFrame();
	}
}
