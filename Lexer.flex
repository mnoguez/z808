package analisador;

import static analisador.Token.*;
%%
%class Lexer
%type Token

L = [a-zA-Z_]
D = [0-9]



%{
public String lexeme;
%}
%%

/* Pular linha */
( "\n" )    {lexeme = yytext(); return LINHA;}

/* Operadores Aritméticos */
( "ADD" | "SUB" | "MULT" | "DIV" | "MOD" )    {lexeme = yytext(); return OP_ARITMETICO;}

/* Operadores Lógicos */
("NOT" | "AND" | "OR" | "XOR" )    {lexeme = yytext(); return OP_LOGICO;}

/*Operadores Relacionais */
("EQ" | "NE" | "LT" | "LE" | "GT" | "GE" )   {lexeme = yytext(); return OP_RELACIONAL;}

/* Operadores Atribuição */
("=" | ":")      {lexeme = yytext(); return OP_ATRIBUICAO;}

/*Operadores Booleanos*/
(true | false)      {lexeme=yytext(); return OP_BOOLEANO;}

/*Separadores */
("(" | ")" | "[" | "]" | ";" | "," |  "." )      {lexeme = yytext(); return SEPARADOR;}

/*Operadores Booleanos*/
("JMP")      {lexeme=yytext(); return PULA;}

/*Operadores Booleanos*/
("MOV")      {lexeme=yytext(); return MOVER;}

/*Operadores Booleanos*/
("PUSH")      {lexeme=yytext(); return PUSH;}

/*Operadores Booleanos*/
("POP")      {lexeme=yytext(); return POP;}


/* Comentarios */
(";;"(.)*)     {lexeme = yytext(); return COMENTARIO;}

/* Marcador de inicio da subrotina */
( "PROC")  {lexeme = yytext(); return INICIO_SUB;}

/* Marcador de fim da subrotina */
( "ENDP")  {lexeme = yytext(); return FIM_SUB;}


/* Marcador de inicio do codigo */
( "CODIGO SEGMENT")  {lexeme = yytext(); return INICIO_CODIGO;}

/* Marcador de fim do codigo */
( "CODIGO ENDS")  {lexeme = yytext(); return FIM_CODIGO;}


/* Marcador de inicio dos dados */
( "DADOS SEGMENT")  {lexeme = yytext(); return INICIO_DADOS;}

/* Marcador de fim dos dados */
( "DADOS ENDS")  {lexeme = yytext(); return FIM_DADOS;}


/* Marcador de inicio do algoritmo */
( "INICIO")  {lexeme = yytext(); return PONTO_ENTRADA;}

/* Marcador de fim do algoritmo */
( "ENDS")  {lexeme = yytext(); return PONTO_SAIDA;}


/* Marcador de inicio macro */
( "MACRO")  {lexeme = yytext(); return INICIO_MACRO;}

/* Marcador de fim do algoritmo */
( "ENDM")  {lexeme = yytext(); return FIM_MACRO;}

/* Marcador de cancelar macro */
( "EXITM")  {lexeme = yytext(); return EXITM;}


/* Marcador de inicio if */
( "IF")  {lexeme = yytext(); return IF;}

/* Marcador de else*/
( "ELSE")  {lexeme = yytext(); return ELSE;}

/* Marcador de fim if */
( "ENDIF")  {lexeme = yytext(); return FIM_IF;}

/* Marcador de alocacao variavel */
( "DW")  {lexeme = yytext(); return DW;}


{L}({L}|{D})* {lexeme=yytext(); return ID;}



("(-"{D}+")")|{D}+ {lexeme=yytext(); return NUMERO;}

. {return ERROR;}
