package CFG.Operand;

import Environment.Symbol;

/**
 * Created by fangbohui on 17-5-17.
 */
public class VarRegister extends VirtualRegister {
	public Symbol symbol;

	public VarRegister(Symbol symbol) {
		this.symbol = symbol;
	}
}
