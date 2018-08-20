/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador;

/**
 *
 * @author yasmi
 */
public enum Token {
    PALAVRA,OP_ARITMETICO, OP_LOGICO,OP_ATRIBUICAO, OP_RELACIONAL,SEPARADOR, PULA, MOVER, PUSH, POP,  
    COMENTARIO, ID, NUMERO, INICIO_SUB, FIM_SUB, INICIO_CODIGO, FIM_CODIGO, INICIO_DADOS, FIM_DADOS, PONTO_ENTRADA, PONTO_SAIDA,
    INICIO_MACRO, FIM_MACRO, EXITM, DW, LINHA, ERROR, REGISTRADOR, DIRETIVAS,VIRGULA, PROP_ASSUME, ASSUME, PONTO_INT,
    
    
    START, INI, EXPR, EXPI, IDI, DOIS_PONTOS, FDW,OPERADORA,OPERADORL,OPIGUAIS,
}

