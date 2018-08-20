/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador;

import static analisador.Main.geraLexer;
import java.io.File;

/**
 *
 * @author yasmi
 */
public class MainSint {

    public static void geraLexer(String path1){
    File arquivo1 = new File(path1);  //abre o arquivo "Lexer.flex"
    jflex.Main.generate(arquivo1);   //gera a classe "Lexer.java"
}
    
    public static void main(String[] args){
        //localiza o arquivo ""
        String path1 = "C:/Users/yasmi/OneDrive/Documents/UFPEL/PS/Analisador/src/analisador/Lexer_1.flex";
        
        //chamda do metodo "geraLexer"
        geraLexer(path1);
    }
    }
    
