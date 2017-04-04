grammar Momo;

program
		:   (classDefinition | varDefinition | functionDefinition)+
		;

classDefinition
		:   'class' IDEN '{'
				(functionDefinition | varDefinition)+
			'}'
		;

functionDefinition
		:   type IDEN '(' (type IDEN (',' type IDEN)* )? ')'
				blockStatement
		;

varDefinition
		:   type IDEN ('=' expression)? ';'
		;

statement
		:   blockStatement
		|   expressionStatement
		|   conditionStatement
		|   loopStatement
		|   controlStatement
		|   varDefinition
		|   ';'
		;

blockStatement
		:   '{' statement* '}'
		;

expressionStatement
		:   expression? ';'
		;

conditionStatement
		:   'if' '(' expression ')'
				statement
			('else' statement)?
		;

loopStatement
		:   'while' '(' expression ')' statement                                        #whileStatement
		|   'for' '(' expression? ';' expression? ';' expression? ')' statement         #forStatement
		;

controlStatement
		:   'continue' ';'                                                              #continueStatement
		|   'break' ';'                                                                 #breakStatement
		|   'return' expression? ';'                                                    #returnStatement
		;

expression
		:   constant                                                                    #constantExpression
		|   IDEN                                                                        #idenExpression
		|   'this'                                                                      #thisExpression
		|   '(' expression ')'                                                          #subExpression
		|   expression operator=('++' | '--')                                           #postfixExpression
		|   expression '(' (expression (',' expression)*)? ')'                          #functionExpression
		|   expression '[' expression ']'                                               #indexExpression
		|   expression '.' IDEN                                                         #fieldExpression
		|   operator=('+' | '-' | '!' | '~' | '++' | '--') expression                   #unaryExpression
		|   'new' type ('[' expression? ']')*                                           #newExpression
		|   expression operator=('*' | '/' | '%') expression                            #multiExpression
		|   expression operator=('+' | '-') expression                                  #addExpression
		|   expression operator=('<<' | '>>') expression                                #shiftExpression
		|   expression operator=('<' | '>' | '<=' | '>=') expression                    #cmpExpression
		|   expression operator=('==' | '!=') expression                                #equalExpression
		|   expression operator=('&' | '|' | '^' ) expression                           #bitExpression
		|   expression operator=('&&' | '||') expression                                #logicExpression
		|   <assoc = right> expression '=' expression                                   #assignExpression
		;

type
		:   'void'                                                                      #voidType
		|   'int'                                                                       #intType
		|   'bool'                                                                      #boolType
		|   'string'                                                                    #stringType
		|   IDEN                                                                        #classType
		|   type '[' ']'                                                                #arrayType
		;

constant
		:   'true'                                                                      #trueConstant
		|   'false'                                                                     #falseConstant
		|   INTEGER                                                                     #intConstant
		|   STRING                                                                      #stringConstant
		|   'null'                                                                      #nullConstant
		;

IDEN
		:   [a-zA-Z_][a-zA-Z_0-9]*
		;

INTEGER
		:   [0-9]+
		;

STRING
		:   '\"' CHAR* '\"'
		;

LINECOMMENT
		:   '//' ~[\r\n]*   ->  skip
		;

BLOCKCOMMENT
		:   '/*' .*? '*/'   ->  skip
		;

WHITESPACE
		:   [ \t\n\r]+      ->  skip
		;

fragment
CHAR
		:   ~["\n\r\\]
		|   '\\' [\\'"?nt]
		;
