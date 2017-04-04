import java.io.*;

import Environment.Environment;
import Listener.BuildTreeListener;
import Listener.ClassGetterListener;
import Listener.DefinitionGetterListener;
import Parser.MomoLexer;
import Parser.MomoParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import Error.CompileError;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

	public static void main(String[] args) throws Exception {

		InputStream is = new FileInputStream("/home/fangbohui/IdeaProjects/Compiler2017BH/src/test.txt");

		Environment.inintiallize();
		ANTLRInputStream input = new ANTLRInputStream(is);
		MomoLexer lexer = new MomoLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MomoParser parser = new MomoParser(tokens);
		if (parser.getNumberOfSyntaxErrors() > 0) {
			throw new CompileError("Syntax Error");
		}
		ParseTree tree = parser.program();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(new ClassGetterListener(), tree);
		walker.walk(new DefinitionGetterListener(), tree);
		walker.walk(new BuildTreeListener(), tree);

		if (!Environment.hasMain) {
			throw new CompileError("You don't have a main function");
		}

	}
}
