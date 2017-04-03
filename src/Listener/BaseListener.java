package Listener;

import AST.Node;
import Parser.MomoBaseListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * Created by fangbohui on 17-4-3.
 */
public abstract class BaseListener extends MomoBaseListener {
	public static int row, column;
	static ParseTreeProperty<Node> propertyTree = new ParseTreeProperty<>();

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		row = ctx.getStart().getLine();
		column = ctx.getStart().getCharPositionInLine();
	}
}
