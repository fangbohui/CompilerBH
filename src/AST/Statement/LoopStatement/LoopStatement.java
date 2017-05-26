package AST.Statement.LoopStatement;

import AST.Statement.Statement;
import CFG.Instruction.LabelInstruction;
import Environment.Scope;

/**
 * Created by fangbohui on 17-4-2.
 */
public abstract class LoopStatement extends Statement implements Scope {
	public LabelInstruction loopBegin, loopMerge;
}
