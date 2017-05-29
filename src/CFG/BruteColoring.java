package CFG;

import CFG.Operand.VirtualRegister;
import Translator.PhysicalRegister;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by fangbohui on 17-5-29.
 */
public class BruteColoring {
	public InterferenceGraph interferenceGraph;
	private HashSet<VirtualRegister> visit;
	public HashMap<VirtualRegister, PhysicalRegister> allocating;

	public BruteColoring(InterferenceGraph interferenceGraph) {
		this.interferenceGraph = interferenceGraph;
		this.allocating = new HashMap<>();
		this.visit = new HashSet<>();
	}

	public void color(VirtualRegister node) {
		HashSet<PhysicalRegister> colored = new HashSet<>();
		for (VirtualRegister register : interferenceGraph.banned.get(node)) {
			if (allocating.containsKey(register)) {
				colored.add(allocating.get(register));
			}
		}
		colored.add(null);
		for (PhysicalRegister color : InterferenceGraph.registerList) {
			if (!allocating.containsKey(node) && !colored.contains(color)) {
				allocating.put(node, color);
				break;
			}
		}
		if (!allocating.containsKey(node)) {
			allocating.put(node, null);
		}
	}

	private void dfs(VirtualRegister node) {
		color(node);
		for (VirtualRegister neighbor : interferenceGraph.banned.get(node)) {
			if (!visit.contains(neighbor)) {
				visit.add(neighbor);
			}
		}
	}

	public HashMap<VirtualRegister, PhysicalRegister> analysis() {
		for (VirtualRegister node : interferenceGraph.nodes) {
			if (!visit.contains(node)) {
				visit.add(node);
				dfs(node);
			}
		}
		return allocating;
	}
}
