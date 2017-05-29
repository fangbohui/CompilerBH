package CFG;

import CFG.Operand.TemporaryRegister;
import CFG.Operand.VirtualRegister;
import Translator.NASMRegister;
import Translator.PhysicalRegister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by fangbohui on 17-5-29.
 */
public class InterferenceGraph {
	public HashSet<VirtualRegister> nodes;
	public HashMap<VirtualRegister, HashSet<VirtualRegister>> banned;
	public static ArrayList<PhysicalRegister> registerList = new ArrayList<PhysicalRegister>() {{
		add(NASMRegister.rdi);
		add(NASMRegister.rsi);
		add(NASMRegister.rbx);
		add(NASMRegister.r8);
		add(NASMRegister.r9);
		add(NASMRegister.r10);
		add(NASMRegister.r11);
		add(NASMRegister.r12);
		add(NASMRegister.r13);
		add(NASMRegister.r14);
		add(NASMRegister.r15);
	}};

	public InterferenceGraph() {
		nodes = new HashSet<>();
		banned = new HashMap<>();
	}

	public void addNode(VirtualRegister register) {
		nodes.add(register);
		banned.put(register, new HashSet<>());
	}

	public void ban(VirtualRegister r1, VirtualRegister r2) {
		if (r1 == r2) {
			return;
		}
		if (r1 instanceof TemporaryRegister && r2 instanceof TemporaryRegister) {
			banned.get(r1).add(r2);
			banned.get(r2).add(r1);
		}
	}
}
