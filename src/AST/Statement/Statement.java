package AST.Statement;

import AST.Node;
import CFG.Instruction.Instruction;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-2.
 */
public abstract class Statement implements Node {
	public abstract void emit(ArrayList<Instruction> instructions);
}
