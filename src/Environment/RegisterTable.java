package Environment;

import CFG.Operand.GlobalRegister;
import CFG.Operand.ParameterRegister;
import CFG.Operand.TemporaryRegister;
import CFG.Operand.VirtualRegister;

import java.util.Set;
import java.util.HashSet;

/**
 * Created by fangbohui on 17-5-17.
 */
public class RegisterTable {
	public Set<VirtualRegister> registers;

	public RegisterTable() {
		registers = new HashSet<>();
	}

	public VirtualRegister addGlobalRegister(Symbol symbol) {
		VirtualRegister virtualRegister = new GlobalRegister(symbol);
		registers.add(virtualRegister);
		return virtualRegister;
	}

	public VirtualRegister addParameterRegister(Symbol symbol) {
		VirtualRegister virtualRegister = new ParameterRegister(symbol);
		registers.add(virtualRegister);
		return virtualRegister;
	}

	public VirtualRegister addTemporaryRegister(Symbol symbol) {
		VirtualRegister virtualRegister = new TemporaryRegister(symbol);
		registers.add(virtualRegister);
		return virtualRegister;
	}
}
