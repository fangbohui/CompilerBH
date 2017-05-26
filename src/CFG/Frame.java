package CFG;

import CFG.Operand.Operand;
import CFG.Operand.VirtualRegister;

import java.util.HashMap;

/**
 * Created by fangbohui on 17-5-25.
 */
public class Frame {
	public int size;
	public HashMap<VirtualRegister, Integer> temporary, parameters;

	public Frame() {
		size = 0;
		temporary = new HashMap<VirtualRegister, Integer>();
		parameters = new HashMap<VirtualRegister, Integer>();
	}

	public Integer getOffset(Operand operand) {
		if (temporary.containsKey(operand)) {
			return temporary.get(operand);
		}
		if (parameters.containsKey(operand)) {
			return parameters.get(operand);
		}
		return -1;
	}
}
