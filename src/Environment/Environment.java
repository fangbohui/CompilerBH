package Environment;

import AST.Function;
import AST.Program;
import AST.Type.ArrayType;
import AST.Type.BasicType.BoolType;
import AST.Type.BasicType.IntType;
import AST.Type.BasicType.StringType;
import AST.Type.BasicType.VoidType;
import Environment.*;

import java.util.ArrayList;

/**
 * Created by fangbohui on 17-4-1.
 */
public class Environment {
	public static Program program;
	public static ScopeTable scopeTable;
	public static SymbolTable symbolTable;
	public static ClassTable classTable;
	public static RegisterTable registerTable;
	public static boolean hasMain;
	public static int newCnt;

	public static void inintiallize() {
		hasMain = false;
		scopeTable = new ScopeTable();
		symbolTable = new SymbolTable();
		classTable = new ClassTable();
		registerTable = new RegisterTable();
		enterScope(program = Program.getProgram());
		getBuiltinFunctions();
		newCnt = 0;
	}

	public static void enterScope(Scope scope) {
		scopeTable.enterScope(scope);
		symbolTable.enterScope();
	}

	public static void exitScope() {
		scopeTable.exitScope();
		symbolTable.exitScope();
	}

	private static void getBuiltinFunctions() {
		symbolTable.add("print", Function.getFunction("FBH_print", VoidType.getType(), new ArrayList<Symbol>() {
			{
				add(new Symbol("string", StringType.getType()));
			}
		}));
		symbolTable.add("println", Function.getFunction("FBH_println", VoidType.getType(), new ArrayList<Symbol>() {
			{
				add(new Symbol("string", StringType.getType()));
			}
		}));
		symbolTable.add("getString", Function.getFunction("FBH_getString", StringType.getType(), new ArrayList<Symbol>()));
		symbolTable.add("getInt", Function.getFunction("FBH_getInt", IntType.getType(), new ArrayList<Symbol>()));
		symbolTable.add("toString", Function.getFunction("FBH_toString", StringType.getType(), new ArrayList<Symbol>() {
			{
				add(new Symbol("int", IntType.getType()));
			}
		}));
		symbolTable.add("FBH_array_size", Function.getFunction("FBH_array_size", IntType.getType(), new ArrayList<Symbol>() {
			{
				add(new Symbol("array", VoidType.getType()));
			}
		}));
		symbolTable.add("FBH_string_length", Function.getFunction("FBH_string_length", IntType.getType(), new ArrayList<Symbol>() {
			{
				add(new Symbol("string", StringType.getType()));
			}
		}));
		symbolTable.add("FBH_string_substring", Function.getFunction("FBH_string_substring", StringType.getType(), new ArrayList<Symbol>() {
			{
				add(new Symbol("string", StringType.getType()));
				add(new Symbol("left", IntType.getType()));
				add(new Symbol("right", IntType.getType()));
			}
		}));
		symbolTable.add("FBH_string_parseInt", Function.getFunction("FBH_string_parseInt", IntType.getType(), new ArrayList<Symbol>() {
			{
				add(new Symbol("string", StringType.getType()));
			}
		}));
		symbolTable.add("FBH_string_ord", Function.getFunction("FBH_string_ord", IntType.getType(), new ArrayList<Symbol>() {
			{
				add(new Symbol("array", StringType.getType()));
				add(new Symbol("ord", IntType.getType()));
			}
		}));
		symbolTable.add("FBH_string_l", Function.getFunction("FBH_string_l", BoolType.getType(), new ArrayList<Symbol>() {
			{
				add(new Symbol("string1", StringType.getType()));
				add(new Symbol("string2", StringType.getType()));
			}
		}));
		symbolTable.add("FBH_string_le", Function.getFunction("FBH_string_le", BoolType.getType(), new ArrayList<Symbol>() {
			{
				add(new Symbol("string1", StringType.getType()));
				add(new Symbol("string2", StringType.getType()));
			}
		}));
		symbolTable.add("FBH_string_g", Function.getFunction("FBH_string_g", BoolType.getType(), new ArrayList<Symbol>() {
			{
				add(new Symbol("string1", StringType.getType()));
				add(new Symbol("string2", StringType.getType()));
			}
		}));
		symbolTable.add("FBH_string_ge", Function.getFunction("FBH_string_ge", BoolType.getType(), new ArrayList<Symbol>() {
			{
				add(new Symbol("string1", StringType.getType()));
				add(new Symbol("string2", StringType.getType()));
			}
		}));
		symbolTable.add("FBH_string_e", Function.getFunction("FBH_string_e", BoolType.getType(), new ArrayList<Symbol>() {
			{
				add(new Symbol("string1", StringType.getType()));
				add(new Symbol("string2", StringType.getType()));
			}
		}));
		symbolTable.add("FBH_string_ne", Function.getFunction("FBH_string_ne", BoolType.getType(), new ArrayList<Symbol>() {
			{
				add(new Symbol("string1", StringType.getType()));
				add(new Symbol("string2", StringType.getType()));
			}
		}));
		symbolTable.add("FBH_string_connect", Function.getFunction("FBH_string_connect", StringType.getType(), new ArrayList<Symbol>() {
			{
				add(new Symbol("string1", StringType.getType()));
				add(new Symbol("string2", StringType.getType()));
			}
		}));
	}
}
