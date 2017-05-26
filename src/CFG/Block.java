package CFG;

import AST.Function;
import CFG.Instruction.Instruction;
import CFG.Instruction.LabelInstruction;

import java.util.ArrayList;

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

	public Block(Function function, String name, int id, LabelInstruction labelInstruction) {
		this.function = function;
		this.name = name;
		this.id = id;
		this.labelInstruction = labelInstruction;
		this.instructions = new ArrayList<>();
		this.pred = new ArrayList<>();
		this.succ = new ArrayList<>();
	}
}
