package analisador;

import static analisador.Token.*;
import java_cup.runtime.Symbol;
import analisador.sym;

%%

//%public
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
%eofval{
    return new Symbol (sym.EOF, new String("Fim do arquivo"));
%eofval}


L = [a-zA-Z_]
D = [0-9]
WHITE=[ \t\r\n]
%{
public String lexeme;
%}
%%
{WHITE} {/*Ignore*/}




/* Pular linha */
( "\n" )    {lexeme = yytext(); return LINHA;}

/* Operadores Aritméticos */
( "ADD" | "SUB" | "MULT" | "DIV" | "MOD" )    {return new Symbol(sym.OP_ARITMETICO, yychar, yyline, yytext());}

/* Registradores */
("AX" | "DX" | "CF" | "PF" | "IF" | "ZF" | "SF" | "OF")    {return new Symbol(sym.REGISTRADOR, yychar, yyline, yytext());}

/* Operadores Lógicos */
("NOT" | "AND" | "OR" | "XOR" )    {return new Symbol(sym.OP_LOGICO, yychar, yyline, yytext());}

/*Operadores Relacionais */
("EQ" | "NE" | "LT" | "LE" | "GT" | "GE" )   {return new Symbol(sym.OP_RELACIONAL, yychar, yyline, yytext());}

/* Operadores Atribuição */
(":")      {return new Symbol(sym.OP_ATRIBUICAO, yychar, yyline, yytext());}

/*Operadores diretivas*/
("CS" | "DS" | "SS")      {return new Symbol(sym.DIRETIVAS, yychar, yyline, yytext());}

/*Separadores */
("(" | ")" | "[" | "]" | ";" | "." )      {return new Symbol(sym.SEPARADOR, yychar, yyline, yytext());}

/* VIRGULA */
(",")      {return new Symbol(sym.VIRGULA, yychar, yyline, yytext());}

/*vamo Pula*/
("JMP")      {return new Symbol(sym.PULA, yychar, yyline, yytext());}

/*Mover*/
("MOV")      {return new Symbol(sym.MOVER, yychar, yyline, yytext());}

/*Push*/
("PUSH")      {return new Symbol(sym.PUSH, yychar, yyline, yytext());}

/*Pop*/
("POP")      {return new Symbol(sym.POP, yychar, yyline, yytext());}

/*ASSUME*/
("ASSUME")      {return new Symbol(sym.ASSUME, yychar, yyline, yytext());}

/*INTERROGRAÇÃO*/
("?")     {return new Symbol(sym.PONTO_INT, yychar, yyline, yytext());}

/* PROPRIEDADE ASSUME */
( "CODIGO" | "DADOS" | "PILHA" )  {return new Symbol(sym.PROP_ASSUME, yychar, yyline, yytext());}

/* Comentarios */
(";;"(.)*)     {;}

/* Marcador de inicio da subrotina */
( "PROC")  {return new Symbol(sym.INICIO_SUB, yychar, yyline, yytext());}

/* Marcador de fim da subrotina */
( "ENDP")  {return new Symbol(sym.FIM_SUB, yychar, yyline, yytext());}


/* Marcador de inicio do codigo */
( "CODIGO SEGMENT")  {return new Symbol(sym.INICIO_CODIGO, yychar, yyline, yytext());}

/* Marcador de fim do codigo */
( "CODIGO ENDS")  {return new Symbol(sym.FIM_CODIGO, yychar, yyline, yytext());}


/* Marcador de inicio dos dados */
( "DADOS SEGMENT")  {return new Symbol(sym.INICIO_DADOS, yychar, yyline, yytext());}

/* Marcador de fim dos dados */
( "DADOS ENDS")  {return new Symbol(sym.FIM_DADOS, yychar, yyline, yytext());}


/* Marcador de inicio do algoritmo */
( "INICIO")  {return new Symbol(sym.PONTO_ENTRADA, yychar, yyline, yytext());}

/* Marcador de fim do algoritmo */
( "ENDS")  {return new Symbol(sym.PONTO_SAIDA, yychar, yyline, yytext());}


/* Marcador de inicio macro */
( "MACRO")  {return new Symbol(sym.INICIO_MACRO, yychar, yyline, yytext());}

/* Marcador de fim do algoritmo */
( "ENDM")  {return new Symbol(sym.FIM_MACRO, yychar, yyline, yytext());}

/* Marcador de cancelar macro */
( "EXITM")  {return new Symbol(sym.EXITM, yychar, yyline, yytext());}


/* Marcador de alocacao variavel */
( "DW")  {return new Symbol(sym.DW, yychar, yyline, yytext());}


{L}({L}|{D})* {return new Symbol (sym.ID, yychar, yyline, yytext());}


("(-"{D}+")")|{D}+ {return new Symbol (sym.NUMERO, yychar, yyline, yytext());}


 . {return new Symbol (sym.ERROR, yychar, yyline, yytext());} 