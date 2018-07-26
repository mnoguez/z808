package analisador;

import static analisador.Token.*;
%%
%class Lexer
%type Token

L = [a-zA-Z_]
D = [0-9]
WHITE=[ \t\r]


%{
public String lexeme;
%}
%%
{WHITE} {/*Ignore*/}
/* Pular linha */
( "\n" )    {lexeme = yytext(); return LINHA;}

/* Operadores Aritméticos */
( "ADD" | "SUB" | "MULT" | "DIV" | "MOD" )    {lexeme = yytext(); return OP_ARITMETICO;}

/* Registradores */
("AX" | "DX" | "CF" | "PF" | "IF" | "ZF" | "SF" | "OF")    {lexeme = yytext(); return REGISTRADOR;}

/* Operadores Lógicos */
("NOT" | "AND" | "OR" | "XOR" )    {lexeme = yytext(); return OP_LOGICO;}

/*Operadores Relacionais */
("EQ" | "NE" | "LT" | "LE" | "GT" | "GE" )   {lexeme = yytext(); return OP_RELACIONAL;}

/* Operadores Atribuição */
(":")      {lexeme = yytext(); return OP_ATRIBUICAO;}

/*Operadores diretivas*/
("CS" | "DS" | "SS")      {lexeme=yytext(); return DIRETIVAS;}

/*Separadores */
("(" | ")" | "[" | "]" | ";" | "." )      {lexeme = yytext(); return SEPARADOR;}

/* VIRGULA */
(",")      {lexeme = yytext(); return VIRGULA;}

/*Vamo pular*/
("JZ")      {lexeme=yytext(); return PULA;}

/*MOVER*/
("MOV")      {lexeme=yytext(); return MOVER;}

/*PUSH*/
("PUSH")      {lexeme=yytext(); return PUSH;}

/*POP*/
("POP")      {lexeme=yytext(); return POP;}

/*ASSUME*/
("ASSUME")      {lexeme=yytext(); return ASSUME;}

/*INTERROGRAÇÃO*/
("?")      {lexeme=yytext(); return PONTO_INT;}

/* Comentarios */
(";;"(.)*)     {lexeme = yytext(); return COMENTARIO;}

/* PROPRIEDADES ASSUME */
( "CODIGO" | "DADOS" | "PILHA" )  {lexeme = yytext(); return PROP_ASSUME;}

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

/* Marcador de alocacao variavel */
( "DW")  {lexeme = yytext(); return DW;}


{L}({L}|{D})* {lexeme=yytext(); return ID;}

("(-"{D}+")")|{D}+ {lexeme=yytext(); return NUMERO;}

. {return ERROR;}
