package CFG.Operand;


import Environment.*;

/**
 * Created by fangbohui on 17-5-17.
 */
public abstract class VirtualRegister extends Operand {
	public int id;
	public VirtualRegister() {
		this.id = Environment.registerTable.registers.size();
	}
}
