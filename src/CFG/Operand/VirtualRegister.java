package CFG.Operand;


import Environment.*;

import java.util.List;

/**
 * Created by fangbohui on 17-5-17.
 */
public abstract class VirtualRegister extends Operand {
	public int name;
	public VirtualRegister() {
		this.name = Environment.registerTable.registers.size();
	}
}
