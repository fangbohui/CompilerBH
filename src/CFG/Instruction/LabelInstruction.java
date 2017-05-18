package CFG.Instruction;

/**
 * Created by fangbohui on 17-5-18.
 */
public class LabelInstruction extends Instruction {
	public String name;

	private LabelInstruction(String name) {
		this.name = name;
	}

	public static Instruction getInstruction(String name) {
		return new LabelInstruction(name);
	}
}
