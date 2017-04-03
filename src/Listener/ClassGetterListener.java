package Listener;

import AST.Type.ClassType;
import Environment.Environment;
import Parser.MomoParser;

/**
 * Created by fangbohui on 17-4-3.
 */
public class ClassGetterListener extends BaseListener {
	@Override
	public void exitClassDefinition(MomoParser.ClassDefinitionContext ctx) {
		String name = ctx.IDEN().getText();
		ClassType classType = (ClassType) ClassType.getType(name);
		Environment.program.addClassType(classType);
		Environment.classTable.put(name, classType);
		propertyTree.put(ctx, classType);
	}
}
