package Translator;

/**
 * Created by fangbohui on 17-5-25.
 */
public class NASMRegister extends PhysicalRegister {
	private NASMRegister(int id, String name) {
		super(id, name);
	}

	public int size() {
		return 8;
	}

	public static PhysicalRegister rax = new NASMRegister(0, "rax");
	public static PhysicalRegister rcx = new NASMRegister(1, "rcx");
	public static PhysicalRegister rdx = new NASMRegister(2, "rdx");
	public static PhysicalRegister rbx = new NASMRegister(3, "rbx");
	public static PhysicalRegister rsp = new NASMRegister(4, "rsp");
	public static PhysicalRegister rbp = new NASMRegister(5, "rbp");
	public static PhysicalRegister rsi = new NASMRegister(6, "rsi");
	public static PhysicalRegister rdi = new NASMRegister(7, "rdi");
	public static PhysicalRegister r8 = new NASMRegister(8, "r8");
	public static PhysicalRegister r9 = new NASMRegister(9, "r9");
	public static PhysicalRegister r10 = new NASMRegister(10, "r10");
	public static PhysicalRegister r11 = new NASMRegister(11, "r11");
	public static PhysicalRegister r12 = new NASMRegister(12, "r12");
	public static PhysicalRegister r13 = new NASMRegister(13, "r13");
	public static PhysicalRegister r14 = new NASMRegister(14, "r14");
	public static PhysicalRegister r15 = new NASMRegister(15, "r15");
}
