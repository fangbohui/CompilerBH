package CFG;

import AST.Function;
import AST.Statement.VarStatement;
import CFG.Instruction.ControlInstruction.ControlInstruction;
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
		// TODO i dont need to save the registers now
		// frame.size += 16 * 8;
		for (Symbol parameter : function.parameters) {
			frame.parameters.put(parameter.register, frame.size);
			frame.size += 8;
		}
		for (VirtualRegister register : registers) {
			frame.temporary.put(register, frame.size);
			frame.size += 8;
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

		computingFrame();
	}
}
