package CFG.Operand;

/**
 * Created by fangbohui on 17-5-22.
 */
public class StringRegister extends VirtualRegister {
	public String string;

	public StringRegister(String string) {
		this.string = string;
	}

	public String message() {
		return String.format("___message___%d", this.id);
	}
}
