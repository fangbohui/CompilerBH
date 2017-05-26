package Translator;

import CFG.Graph;

import java.io.PrintStream;

/**
 * Created by fangbohui on 17-5-24.
 */
public abstract class Translator {
	public PrintStream output;

	public Translator(PrintStream output) {
		this.output = output;
	}

	public abstract void translate(Graph graph);
	public abstract void translate() throws Exception;
}
