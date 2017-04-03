//Top level
grammar Muse;
@header{package Parser;}

program
	: (function_definition | declaration)+
	;

declaration
	: (type) init_declarators SEMI
	| class_declaration
	;

Comma
	: ','
	;

Equal
	: '='
	;

Lbracket
	: '('
	;

Rbracket
	: ')'
	;

LBigbracket
	: '{'
	;

RBigbracket
	: '}'
	;

LMidbracket
	: '['
	;

RMidbracket
	: ']'
	;

New
	: 'new'
	;

init_declarators
	:  init_declarator
	//since there is no comma expressions
	;
declarators
	:  declarator
	;

init_declarator
	:  declarator (equal initializer)?
//(no constructor)	| Identifier Lbracket parameters Rbracket
	;

type
	: type_non_array
	| array_decl
	;

array_decl
    : type_non_array (LMidbracket RMidbracket)+;

array_new
	: type_non_array (LMidbracket expression RMidbracket)+ (LMidbracket RMidbracket)*;

type_non_array
	: typenametokens
	| class_declaration
	;
class_declaration
	: (union_class) Identifier? LBigbracket (type declarators SEMI)* RBigbracket
	;

declarator
	: Identifier
	;

initializer
	: assignment_expression
//	| LBigbracket initializer (Comma initializer)* RBigbracket
	;

function_definition
	: type Identifier Lbracket parameters? Rbracket LBigbracket (statement | declaration)* RBigbracket
	| type Identifier Lbracket parameters? Rbracket SEMI
	;

Balabalabala
	: '...'
	;

parameters
	: (parameter (Comma parameter)*) (Comma Balabalabala)?
	;


parameter
	: type (declarator)
	;

//statements

statement
	: compond_statement
	| structured_statement
	| assignment_statement
	| declaration
	;

assignment_statement
	: expression? SEMI
	;

structured_statement
	: loop_statement
	| branch_statement
	;

compond_statement
	: LBigbracket (statement | declaration)* RBigbracket
	;

loop_statement
	: for_loop_statement
	| while_loop_statement
	;

BREAK
	: 'break'
	;

CONTINUE
	: 'continue'
	;

RETURN
	: 'return'
	;

branch_statement
	: if_statement
	| BREAK SEMI
	| CONTINUE SEMI
	| RETURN expression? SEMI
	;

FOR
	: 'for'
	;

WHILE
	: 'while'
	;

DO
	: 'do'
	;

for_loop_statement
	: FOR Lbracket (first_expression? SEMI) (second_expression? SEMI) (third_expression?) Rbracket statement
	;

first_expression
    : expression
    ;

second_expression
    : expression
    ;

third_expression
    : expression
    ;

while_loop_statement
	: WHILE Lbracket expression Rbracket statement
	;

IF
	: 'if'
	;

ELSE
	: 'else'
	;

if_statement
	: IF Lbracket expression Rbracket (statement) (ELSE (statement) )?
	;

COLON
	: ':'
	;

//expressions
expression
	: assignment_expression
	;

assignment_expression
	: (unary_expression assignment_operators)* calculation_expression
	;

equal
	: '='
	;

assignment_operators
	: equal
	;

QUESTION
	: '?'
	;

calculation_expression
	: logical_caclulation_expression /*(QUESTION logical_caclulation_expression COLON logical_caclulation_expression)* */
	;

logical_caclulation_expression
	: logical_or_expression
	;

logical_or_expression
	: logical_and_expression ('||' logical_and_expression)*
	;

logical_and_expression
	: bitwise_or_expression ('&&' bitwise_or_expression)*
	;

bitwise_or_expression
	: bitwise_xor_expression ('|' bitwise_xor_expression)*
	;

bitwise_xor_expression
	: bitwise_and_expression ('^' bitwise_and_expression)*
	;

bitwise_and_expression
	: equality_expression ('&' equality_expression)*
	;

isequal
	: '=='
	;

notequal
	: '!='
	;

equality_expression
	: relation_expression (equ_op relation_expression)*
	;

equ_op
    : (isequal | notequal)
    ;

bigger
	: '>'
	;

smaller
	: '<'
	;

bigger_e
	: '>='
	;

smaller_e
	: '<='
	;

rela_op
    : (smaller_e | bigger_e | bigger | smaller)
    ;

relation_expression
	: shift_expression (rela_op shift_expression)?
	;

lshift
	: '<<'
	;

rshift
	: '>>'
	;

plus
	: '+'
	;

minus
	: '-'
	;

shift_op
    : (lshift | rshift)
    ;

add_op
    : plus | minus
    ;

shift_expression
	: add_expression (shift_op add_expression)*
	;

add_expression
	: mul_expression (add_op mul_expression)*
	;

multiply
	: '*'
	;

division
	: '/'
	;

mod
	: '%'
	;

mul_op
    : (multiply | division | mod)
    ;

mul_expression
	: unary_expression (mul_op unary_expression)*
	;

plusplus
	: '++'
	;

minusminus
	: '--'
	;

unary_expression
	: postfix_expression
	| unary_operation unary_expression
	| number
	| functionCall_expression
	| new_operation
	| pre_defined_constants
	;

pre_defined_constants
    : 'true' | 'false' | 'null'
    ;

class_new
    : Identifier
    ;

new_operation
    : New (array_new | class_new)
    ;

functionCall_expression
	: (Identifier) Lbracket arguements? Rbracket
	;

arguements
	: assignment_expression (Comma assignment_expression)*
	;

value
	: constant
	| expression
	| Lbracket value Rbracket
	;

not_sign
	: '!'
	;

unary_operation
	: not_sign
	| minus
	| plusplus
	| minusminus
	| Lbracket type_name Rbracket
	| bitwise_not
	;

bitwise_not
    : '~'
    ;

postfix_expression
	: primary_expression postfix*
	;

getMember
	: '.'
	;

postfix
	: LMidbracket expression RMidbracket
	| getMember (Identifier | functionCall_expression)
	| plusplus
	| minusminus
	;

primary_expression
	: Identifier
	| constant
	| Lbracket expression Rbracket
	| functionCall_expression
	;

type_name
	: typenametokens
	| Identifier
	;
constant
	: numeric_constant
	| string_constant
	;

numeric_constant
	: integer_constant
	;

integer_constant
	: number
	;

string_constant
	: StringLiteral
	;

typenametokens
	: builtin_types = ('int' | 'bool' | 'void')
	| Identifier //user-defined type
	;

number
	: Sign? DecimalConstant
	;

union_class
	: 'class'
	;

Dot
	: '.'
	;

Identifier
	:	IdentifierNondigit
		(	IdentifierNondigit
		|	Digit
		)*
	;

fragment
IdentifierNondigit
	:	Nondigit
	;

fragment
Nondigit
	:	[a-zA-Z_$]
	;

SEMI
	: ';'
	;

fragment
Digit
	:	[0-9]
	;

fragment
HexQuad
	:	HexadecimalDigit HexadecimalDigit HexadecimalDigit HexadecimalDigit
	;

DecimalConstant
	: NonzeroDigit Digit* Numbertail?
	| '0' Numbertail?
	;

Numbertail
	: ('u' | 'U' | 'll' | 'LL' | 'lL' | 'Ll' | 'f')
	;

OctalConstant
	:	'0' OctalDigit*
	;

HexadecimalConstant
	:	HexadecimalPrefix HexadecimalDigit+
	;

fragment
HexadecimalPrefix
	:	'0' [xX]
	;

fragment
NonzeroDigit
	:	[1-9]
	;

fragment
OctalDigit
	:	[0-7]
	;

fragment
HexadecimalDigit
	:	[0-9a-fA-F]
	;

Sign
	:	'+' | '-'
	;

fragment
DigitSequence
	:	Digit+
	;

CharacterConstant
	:	'\'' CCharSequence '\''
	;

fragment
CharSequence
	:	Char+
	;

fragment
Char
	:	~['\\\r\n]
	|	EscapeSequence
	;

fragment
EscapeSequence
	:	SimpleEscapeSequence
	|	OctalEscapeSequence
	|	HexadecimalEscapeSequence
	;

fragment
SimpleEscapeSequence
	:	'\\' ['"?abfnrtv\\]
	;

fragment
OctalEscapeSequence
	:	'\\' OctalDigit
	|	'\\' OctalDigit OctalDigit
	|	'\\' OctalDigit OctalDigit OctalDigit
	;

fragment
HexadecimalEscapeSequence
	:	'\\x' HexadecimalDigit+
	;

StringLiteral
	:	'"' SCharSequence? '"'
	;

fragment
SCharSequence
	:	SChar+
	;

fragment
SChar
	:   ~["\\\r\n]
	|   EscapeSequence
	;

fragment
CCharSequence
	:	CChar+
	;

fragment
CChar
	:	~['\\\r\n]
	|	EscapeSequence
	;

Preprocessing
	:	'#' ~[\r\n]* ('\r' | '\n' | ('\r''\n'))
		-> channel(HIDDEN)
	;

Whitespace
	:	[ \t]+
		-> skip
	;

Newline
	:	(	'\r' '\n'?
		|	'\n'
		)
		-> channel(HIDDEN)
	;

BlockComment
	:	'/*' .*? '*/'
		-> channel(HIDDEN)
	;

LineComment
	:	'//' ~[\r\n]*
		-> channel(HIDDEN)
	;