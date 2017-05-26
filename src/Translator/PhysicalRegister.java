package Translator;

/**
 * Created by fangbohui on 17-5-25.
 */
public abstract class PhysicalRegister {
	public int id;
	public String name;

	public PhysicalRegister(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
