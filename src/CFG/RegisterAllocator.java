package CFG;

import AST.Function;
import CFG.Instruction.ComputingInstruction.BinaryInstruction.BinaryInstruction;
import CFG.Instruction.Instruction;
import CFG.Operand.VirtualRegister;
import Translator.PhysicalRegister;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by fangbohui on 17-5-29.
 */
public class RegisterAllocator {
	public HashMap<VirtualRegister, PhysicalRegister> allocating;
	public Function function;

	public RegisterAllocator(Function function) {
		this.function = function;
		allocating = new HashMap<>();
		function.graph.livenessAnalysis();
		InterferenceGraph interferenceGraph = new InterferenceGraph();

		for (Block block : function.graph.blockList) {
			for (Instruction instruction : block.instructions) {
				for (VirtualRegister register : instruction.getDestRegisters()) {
					interferenceGraph.addNode(register);
				}
				for (VirtualRegister register : instruction.getSrcRegisters()) {
					interferenceGraph.addNode(register);
				}
			}
		}

		for (Block block : function.graph.blockList) {
			HashSet<VirtualRegister> liveout = new HashSet<>();
			for (VirtualRegister register : block.liveness.liveout) {
				liveout.add(register);
			}
			for (int i = block.instructions.size() - 1; i >= 0; i --) {
				Instruction instruction = block.instructions.get(i);
				if (instruction instanceof BinaryInstruction) {
					for (VirtualRegister out : liveout) {
						interferenceGraph.ban(((BinaryInstruction) instruction).dest, out);
					}
					liveout.remove(((BinaryInstruction) instruction).dest);
					if (((BinaryInstruction) instruction).src2 instanceof VirtualRegister){
						liveout.add((VirtualRegister) ((BinaryInstruction) instruction).src2);
					}
					for (VirtualRegister out : liveout) {
						interferenceGraph.ban(((BinaryInstruction) instruction).dest, out);
					}
					liveout.remove(((BinaryInstruction) instruction).dest);
					if (((BinaryInstruction) instruction).src1 instanceof VirtualRegister){
						liveout.add((VirtualRegister) ((BinaryInstruction) instruction).src1);
					}
				} else {
					for (VirtualRegister defined : instruction.getDestRegisters()) {
						for (VirtualRegister out : liveout) {
							interferenceGraph.ban(defined, out);
						}
					}
					for (VirtualRegister defined : instruction.getDestRegisters()) {
						liveout.remove(defined);
					}
					for (VirtualRegister used : instruction.getSrcRegisters()) {
						liveout.add(used);
					}
				}
			}
		}


		allocating = new BruteColoring(interferenceGraph).analysis();
	}

	public HashSet<PhysicalRegister> getUsedRegisters() {
		HashSet<PhysicalRegister> registers = new HashSet<>();
		for (VirtualRegister register : allocating.keySet()) {
			PhysicalRegister physicalRegister = allocating.get(register);
			if (physicalRegister != null) {
				registers.add(physicalRegister);
			}
		}
		return registers;
	}
}
