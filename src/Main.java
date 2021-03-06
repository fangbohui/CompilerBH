import java.io.*;

import AST.Function;
import CFG.Graph;
import CFG.RegisterAllocator;
import Environment.Environment;
import Listener.BuildTreeListener;
import Listener.ClassGetterListener;
import Listener.DefinitionGetterListener;
import Listener.SyntaxErrorListener;
import Parser.MomoLexer;
import Parser.MomoParser;
import Translator.NASM_Naive_Translator;
import Translator.NASM_Powerful_Translator;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import Error.CompileError;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

	public static void main(String[] args) throws Exception {

		int LOCAL;
		LOCAL = 2-2;
		InputStream is;
		if (LOCAL == 1) {
			is = new FileInputStream("/home/xzj/rua/fangbohui-compiler2017bh-56b699b20866/src/test.txt");
		} else {
			is = new FileInputStream("/home/fangbohui/IdeaProjects/compiler2017bh/src/test.txt");
		}

		Environment.inintiallize();
		ANTLRInputStream input = new ANTLRInputStream(is);
		MomoLexer lexer = new MomoLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MomoParser parser = new MomoParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new SyntaxErrorListener());
		ParseTree tree = parser.program();
		ParseTreeWalker walker = new ParseTreeWalker() ;
		walker.walk(new ClassGetterListener(), tree);
		walker.walk(new DefinitionGetterListener(), tree);
		walker.walk(new BuildTreeListener(), tree);

		if (!Environment.hasMain) {
			throw new CompileError("You don't have a main function");
		}

		for (Function function : Environment.program.functionList) {
			function.graph = new Graph(function);
			function.allocator = new RegisterAllocator(function);
		}

		OutputStream os;

		if (LOCAL == 1) {
			os = new FileOutputStream("/home/xzj/rua/fangbohui-compiler2017bh-56b699b20866/src/fbh.asm");
		} else {
			os = new FileOutputStream("/home/fangbohui/IdeaProjects/compiler2017bh/src/test.txt");
		}

/*
		if (LOCAL == 0) {
			new NASM_Naive_Translator(new PrintStream(System.out)).translate();
		} else {
			new NASM_Naive_Translator(new PrintStream(os)).translate();
		}
*/
		if (LOCAL == 0) {
			new NASM_Powerful_Translator(new PrintStream(System.out)).translate();
		} else {
			new NASM_Powerful_Translator(new PrintStream(os)).translate();
		}



		// Compile : nasm -felf64 fbh.asm && gcc fbh.o && time ./a.out
	}
}
