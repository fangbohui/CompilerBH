package CFG;

import AST.Function;
import CFG.Instruction.Instruction;
import CFG.Instruction.LabelInstruction;
import CFG.Operand.VirtualRegister;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by fangbohui on 17-5-17.
 */
public class Block {
	public Function function;
	public String name;
	public int id;
	public LabelInstruction labelInstruction;
	public ArrayList<Instruction> instructions;
	public ArrayList<Block> pred, succ;
	public Liveness liveness;

	public class Liveness {
		public HashSet<VirtualRegister> livein;
		public HashSet<VirtualRegister> liveout;
		public ArrayList<VirtualRegister> usedRegisters;
		public ArrayList<VirtualRegister> definedRegisters;

		public Liveness() {
			livein = new HashSet<>();
			liveout = new HashSet<>();
			usedRegisters = new ArrayList<>();
			definedRegisters = new ArrayList<>();
		}
	}

	public Block(Function function, String name, int id, LabelInstruction labelInstruction) {
		this.function = function;
		this.name = name;
		this.id = id;
		this.labelInstruction = labelInstruction;
		this.instructions = new ArrayList<>();
		this.pred = new ArrayList<>();
		this.succ = new ArrayList<>();
		this.liveness = new Liveness();
	}
}
