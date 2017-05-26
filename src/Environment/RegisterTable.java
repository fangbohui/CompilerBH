package Environment;

import CFG.Operand.*;

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

	public VirtualRegister addStringRegister(String string) {
		VirtualRegister virtualRegister = new StringRegister(string);
		registers.add(virtualRegister);
		return virtualRegister;
	}
}
