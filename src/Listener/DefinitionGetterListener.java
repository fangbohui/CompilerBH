package Listener;

import AST.Function;
import AST.Type.ArrayType;
import AST.Type.BasicType.BoolType;
import AST.Type.BasicType.IntType;
import AST.Type.BasicType.StringType;
import AST.Type.BasicType.VoidType;
import AST.Type.ClassType;
import AST.Type.Type;
import Environment.*;
import Parser.MomoParser;
import Error.CompileError;

import java.util.ArrayList;
import java.util.List;

public class DefinitionGetterListener extends BaseListener {
	@Override
	public void exitFunctionDefinition(MomoParser.FunctionDefinitionContext ctx) {
		String name;
		Type type = VoidType.getType();
		ClassType classType = Environment.scopeTable.classTypeTop();

		boolean isConstructor = (ctx.type().size() != ctx.IDEN().size());

		if (isConstructor) { // means this is a constructor
			if (classType == null) {
				throw new CompileError("you have a constructor function in the global area");
			}
			name = ctx.IDEN(0).getText();
			if (!name.equals(classType.name)) {
				throw new CompileError("constructor should have the same name with the class");
			}
		}

		name = ctx.IDEN(0).getText();
		type = (Type) propertyTree.get(ctx.type(0));

		List<Symbol> parameters = new ArrayList<Symbol>() {{
			if (classType != null) {
				add(new Symbol("this", classType));
			}
			int pos = 1;
			if (isConstructor) {
				pos = 0;
			}
			for (int i = 1; i < ctx.type().size(); i ++) {
				String parameterName = ctx.IDEN(pos).getText();
				Type parameterType = (Type) propertyTree.get(ctx.type(i));
				add(new Symbol(parameterName, classType));
				pos ++;
			}
		}};

		Function function = Function.getFunction(name, type, parameters);
		if (classType == null) {
			Environment.symbolTable.add(name, function);
		} else {
			if (isConstructor) {
				classType.addConstructor(function);
			} else {
				classType.addMember(name, function);
			}
		}
		Environment.program.addfunction(function);
		propertyTree.put(ctx, function);
	}

	@Override
	public void enterClassDefinition(MomoParser.ClassDefinitionContext ctx) {
		ClassType classType = (ClassType) propertyTree.get(ctx);
		Environment.enterScope(classType);
	}

	@Override
	public void exitClassDefinition(MomoParser.ClassDefinitionContext ctx) {
		ClassType classType = (ClassType) propertyTree.get(ctx);
		ctx.varDefinition().forEach(statementContext -> {
			String memberName = statementContext.IDEN().getText();
			Type memberType = (Type) propertyTree.get(statementContext.type());
			classType.addMember(memberName, memberType);
		});
		Environment.exitScope();
	}

	@Override
	public void exitVoidType(MomoParser.VoidTypeContext ctx) {
		propertyTree.put(ctx, VoidType.getType());
	}

	@Override
	public void exitIntType(MomoParser.IntTypeContext ctx) {
		propertyTree.put(ctx, IntType.getType());
	}

	@Override
	public void exitBoolType(MomoParser.BoolTypeContext ctx) {
		propertyTree.put(ctx, BoolType.getType());
	}

	@Override
	public void exitStringType(MomoParser.StringTypeContext ctx) {
		propertyTree.put(ctx, StringType.getType());
	}

	@Override
	public void exitClassType(MomoParser.ClassTypeContext ctx) {
		String name = ctx.getText();
		if (!Environment.classTable.containsName(name)) {
			throw new CompileError("there is no such a CLASS");
		}
		propertyTree.put(ctx, Environment.classTable.get(name));
	}

	@Override
	public void exitArrayType(MomoParser.ArrayTypeContext ctx) {
		Type baseType = (Type) propertyTree.get(ctx.type());
		propertyTree.put(ctx, ArrayType.getType(baseType));
	}
}
