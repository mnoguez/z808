/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador;

/**
 *
 * @author yasmin
 */
public enum Token {
    PALAVRA,OP_ARITMETICO, OP_LOGICO,OP_ATRIBUICAO, OP_RELACIONAL, OP_BOOLEANO, SEPARADOR, PULA, MOVER, PUSH, POP,  
    COMENTARIO, ID, NUMERO, INICIO_SUB, FIM_SUB, INICIO_CODIGO, FIM_CODIGO, INICIO_DADOS, FIM_DADOS, PONTO_ENTRADA, PONTO_SAIDA,
    INICIO_MACRO, FIM_MACRO, EXITM, IF, ELSE, FIM_IF, DW, LINHA, ERROR,
}

