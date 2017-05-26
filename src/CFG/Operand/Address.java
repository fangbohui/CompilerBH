package CFG.Operand;

import CFG.Instruction.Instruction;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-5-17.
 */
public class Address extends Operand {
	public VirtualRegister base;
	public ImmediatelyNumber index;
	public int scale;

	public Address(VirtualRegister base, ImmediatelyNumber index, int scale) {
		this.base = base;
		this.index = index;
		this.scale = scale;
	}

	public Address(VirtualRegister base, int scale) {
		this.base = base;
		this.index = new ImmediatelyNumber(0);
		this.scale = scale;
	}
}
