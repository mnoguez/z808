/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador;

import java.io.File;

/**
 *
 * @author yasmin
 */
public class Main {
    //metodo para criar a nova classe para fazer a análise léxica do codigo
public static void geraLexer(String path){
    File arquivo = new File(path);  //abre o arquivo "Lexer.flex"
    jflex.Main.generate(arquivo);   //gera a classe "Lexer.java"
}
    
    public static void main(String[] args){
        //localiza o arquivo ""
        String path = "C:/Users/yasmi/OneDrive/Documents/UFPEL/PS/Analisador/src/analisador/Lexer.flex";
        
        //chamda do metodo "geraLexer"
        geraLexer(path);
    }
    
}
