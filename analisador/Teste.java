/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.FileInputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.text.Annotation;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java_cup.runtime.Symbol;

/**
 *
 * @author yasmi
 */
public class Teste extends javax.swing.JInternalFrame {

    public JTextArea jText;

    // metodo executar
    public void executar() throws Exception {

        int cont = 0;

        jText = textArea1;    //recebe o que foi digitado
        String expr;
        //jText = textArea1;
        expr = (String) jText.getText();   //passa o que foi digitado para uma string e armazena na variável "expr"
        Lexer lexer = new Lexer(new StringReader(expr));   //cria um objeto "lexer", que é da classe "Lexer.java" em passamos 
        //a expressão que foi digitada pelo usuário
        //vai fazer a analise e retorna o tipo de "token" que foi inserido, 
        //que foi especificado na classe "Lexer.java"    

        String resultado = "";

        while (true) {
            Token token = lexer.yylex();
            if (token == null) {

                textArea.setText(resultado);
                //textArea.setForeground(Color.BLACK);

                return;
            }
            //cases para mostrarmos a saida dos tokens 
            switch (token) {

                 /*   case PALAVRA:                    
                    //cont ++;
                    resultado = resultado + "Linha: " + cont +  "<Palavra_Reservada> " + lexer.lexeme + "\n";     
                    break; */
                    
                case OP_ARITMETICO:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<Operador_Aritmético> "  + lexer.lexeme + "\n"; 
                    break;
                    
                case OP_LOGICO:
                    //cont ++;
                    resultado = resultado + "Linha: " + cont + "<Operador_Lógico> "  + lexer.lexeme + "\n";
                    break;
                    
                case OP_ATRIBUICAO:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<Operador_Atribuição> " + lexer.lexeme + "\n";
                    break;
                    
                case OP_RELACIONAL:
                    //cont++;
                    resultado = resultado + "Linha: " + cont +  "<Operador_Relacional> " + lexer.lexeme + "\n";
                    break;
                    
                case SEPARADOR:
                    //cont++;
                    resultado = resultado + "Linha: " + cont +  "<Separador> " + lexer.lexeme + "\n";
                    break;
                    
                    
                case COMENTARIO:
                    //cont++;
                    resultado = resultado + "Linha: " + cont +  "<Comentario> " + lexer.lexeme + "\n";
                    break;
                
                case DW:
                    //cont++;
                    resultado = resultado + "Linha: " + cont +  "<DW> " + lexer.lexeme + "\n";
                    break;
                    
                 
                case PUSH:
                    //cont++;
                    resultado = resultado + "Linha: " + cont +  "<PUSH> " + lexer.lexeme + "\n";
                    break;                   
                       
                                    
                case POP:
                    //cont++;
                    resultado = resultado + "Linha: " + cont +  "<POP> " + lexer.lexeme + "\n";
                    break;
                    
                                    
                case PULA:
                    //cont++;
                    resultado = resultado + "Linha: " + cont +  "<PULA> " + lexer.lexeme + "\n";
                    break;
                    
                                    
                case MOVER:
                    //cont++;
                    resultado = resultado + "Linha: " + cont +  "<MOVER> " + lexer.lexeme + "\n";
                    break;
                    
                case LINHA:
                     cont++;
                     break;
                                                     
                case ID:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<ID> " + lexer.lexeme +"\n";
                    break;
                    
                case NUMERO:
                    //cont++;
                    resultado = resultado + "Linha: " + cont +  "<Numero> " + lexer.lexeme + "\n" ;
                    break;        
                    
                case INICIO_SUB:
                    //cont++;
                    resultado = resultado + "Linha: " + cont + "<INICIO_SUB>" + lexer.lexeme + "\n";
                    break;       
                    
                case FIM_SUB:
                    //cont ++;
                    resultado = resultado + "Linha: " + cont + "<FIM_SUB>" + lexer.lexeme + "\n";
                    break;      
                    
                case INICIO_CODIGO:
                    //cont ++;
                    resultado = resultado + "Linha: " + cont + "<Inicio_codigo>" + lexer.lexeme + "\n";
                    break;
                    
               case FIM_CODIGO:
                   //cont ++;
                   resultado = resultado + "Linha: " + cont + "<Fim_codigo>" + lexer.lexeme + "\n";
                   break;         
                   
               case INICIO_DADOS:
                   //cont ++;
                   resultado = resultado + "Linha: " + cont + "<Inicio_dados>" + lexer.lexeme + "\n";
                   break;    
                   
               case FIM_DADOS:
                   //cont ++;
                   resultado = resultado + "Linha: " + cont + "<Fim_dados>" + lexer.lexeme + "\n";
                   break;  
                   
               case PONTO_ENTRADA:
                   //cont ++;
                   resultado = resultado + "Linha: " + cont + "<Ponto_entrada>" + lexer.lexeme + "\n";
                   break; 
                   
                case PONTO_SAIDA:
                   //cont ++;
                   resultado = resultado + "Linha: " + cont + "<Ponto_saida>" + lexer.lexeme + "\n";
                   break; 
                   
                case INICIO_MACRO:
                   //cont ++;
                   resultado = resultado + "Linha: " + cont + "<Inicio_macro>" + lexer.lexeme + "\n";
                   break; 
                 
                case FIM_MACRO:
                   //cont ++;
                   resultado = resultado + "Linha: " + cont + "<Fim_Macro>" + lexer.lexeme + "\n";
                   break; 
                   
                case EXITM:
                  //cont ++;
                  resultado = resultado + "Linha: " + cont + "<EXITM>" + lexer.lexeme + "\n";
                  break;   
                             
                
                case ERROR:                    
                //cont ++;                    
                resultado = resultado + "Erro na linha " + cont + ": Símbolo não reconhecido \n" ;                  
                break;
                   
                default:
                    //cont ++;
                    resultado = resultado + "Linha: " + cont + "<" + lexer.lexeme +">" + cont++ + "\n";
                    break;          
            }
        }
    }

    /**
     * Creates new form NewJInternalFrame
     */
    public Teste() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAnalisarSintatico = new javax.swing.JButton();
        btnLimpar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaSintatico = new javax.swing.JTextArea();
        lb_analiseLexica = new javax.swing.JLabel();
        lb_entrada = new javax.swing.JLabel();
        btnAnalisar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnBuscarArquivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        btn_analiseSintatica = new javax.swing.JLabel();
        btnAnalisarSintatico1 = new javax.swing.JButton();
        btnLimpar2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaSintatico1 = new javax.swing.JTextArea();
        btnLimpar3 = new javax.swing.JButton();

        btnAnalisarSintatico.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAnalisarSintatico.setForeground(new java.awt.Color(153, 0, 51));
        btnAnalisarSintatico.setText("Analisar");
        btnAnalisarSintatico.setBorder(new javax.swing.border.MatteBorder(null));
        btnAnalisarSintatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisarSintaticoActionPerformed(evt);
            }
        });

        btnLimpar1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnLimpar1.setForeground(new java.awt.Color(153, 0, 51));
        btnLimpar1.setText("Limpar");
        btnLimpar1.setBorder(new javax.swing.border.MatteBorder(null));
        btnLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar1ActionPerformed(evt);
            }
        });

        textAreaSintatico.setColumns(20);
        textAreaSintatico.setRows(5);
        jScrollPane2.setViewportView(textAreaSintatico);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Compilador");
        setToolTipText("");

        lb_analiseLexica.setBackground(new java.awt.Color(102, 102, 0));
        lb_analiseLexica.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lb_analiseLexica.setForeground(new java.awt.Color(153, 51, 0));
        lb_analiseLexica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_analiseLexica.setText("Análise Léxica");
        lb_analiseLexica.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 171, 134)));

        lb_entrada.setBackground(new java.awt.Color(51, 153, 0));
        lb_entrada.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lb_entrada.setForeground(new java.awt.Color(153, 0, 51));
        lb_entrada.setText("Entrada");
        lb_entrada.setBorder(new javax.swing.border.MatteBorder(null));

        btnAnalisar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAnalisar.setForeground(new java.awt.Color(153, 0, 51));
        btnAnalisar.setText("Analisar");
        btnAnalisar.setBorder(new javax.swing.border.MatteBorder(null));
        btnAnalisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(153, 0, 51));
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(new javax.swing.border.MatteBorder(null));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnBuscarArquivo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnBuscarArquivo.setForeground(new java.awt.Color(153, 0, 51));
        btnBuscarArquivo.setText("Arquivo");
        btnBuscarArquivo.setBorder(new javax.swing.border.MatteBorder(null));
        btnBuscarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArquivoActionPerformed(evt);
            }
        });

        textArea1.setColumns(20);
        textArea1.setRows(5);
        jScrollPane1.setViewportView(textArea1);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane3.setViewportView(textArea);

        btn_analiseSintatica.setBackground(new java.awt.Color(102, 102, 0));
        btn_analiseSintatica.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_analiseSintatica.setForeground(new java.awt.Color(153, 51, 0));
        btn_analiseSintatica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_analiseSintatica.setText("Análise Sintática");
        btn_analiseSintatica.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 171, 134)));

        btnAnalisarSintatico1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAnalisarSintatico1.setForeground(new java.awt.Color(153, 0, 51));
        btnAnalisarSintatico1.setText("Analisar");
        btnAnalisarSintatico1.setBorder(new javax.swing.border.MatteBorder(null));
        btnAnalisarSintatico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisarSintatico1ActionPerformed(evt);
            }
        });

        btnLimpar2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnLimpar2.setForeground(new java.awt.Color(153, 0, 51));
        btnLimpar2.setText("Limpar");
        btnLimpar2.setBorder(new javax.swing.border.MatteBorder(null));
        btnLimpar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar2ActionPerformed(evt);
            }
        });

        textAreaSintatico1.setColumns(20);
        textAreaSintatico1.setRows(5);
        jScrollPane4.setViewportView(textAreaSintatico1);

        btnLimpar3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnLimpar3.setForeground(new java.awt.Color(153, 0, 51));
        btnLimpar3.setText("Gerar Switch");
        btnLimpar3.setBorder(new javax.swing.border.MatteBorder(null));
        btnLimpar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(lb_analiseLexica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_analiseSintatica, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAnalisar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAnalisarSintatico1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLimpar2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpar3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lb_analiseLexica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAnalisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btn_analiseSintatica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnalisarSintatico1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(0, 0, 755, 586);
    }// </editor-fold>//GEN-END:initComponents

//    public void setPosicao() {
//    Dimension d = this.getDesktopPane().getSize();
//    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
//}

    private void btnAnalisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisarActionPerformed
        //chamada do metod executar
        try {
            executar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAnalisarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // ira apenas apagar o que foi inserido nos resultados
        textArea1.setText("");
        textArea.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnBuscarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArquivoActionPerformed
        try {
            // TODO add your handling code here:
            JFileChooser abrir = new JFileChooser();
            abrir.showOpenDialog(this);

            textArea1.setText(abrir.getSelectedFile().getAbsolutePath());

            File Arquivo = new File(textArea1.getText());
            String ST = new String(Files.readAllBytes(Arquivo.toPath()));
            textArea1.setText(ST);

        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarArquivoActionPerformed

    private void btnAnalisarSintaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisarSintaticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnalisarSintaticoActionPerformed

    private void btnLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar1ActionPerformed
        // ira apenas apagar o que foi inserido nos resultados
        textAreaSintatico.setText("");
        textAreaSintatico.setText("");
    }//GEN-LAST:event_btnLimpar1ActionPerformed

    private void btnAnalisarSintatico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisarSintatico1ActionPerformed

        //File arquivo = new File(textArea1.getText());
        String ST = new String(textArea1.getText());
        System.out.println("\n");
        //parser p = new parser(new analisador.Yylex(new java.io.InputStreamReader(ST)));
        parser p = new parser(new analisador.Yylex(new StringReader(ST)));

            //p = new parser(new analisador.Yylex(new java.io.FileReader(textAreaSintatico1.getText())));
        //p = new parser(new analisador.Yylex(new java.io.FileInputStream(arquivo)));
        
        try {
             p.parse();
             textAreaSintatico1.setText("Analise realizada corretamente");
             textAreaSintatico1.setForeground(Color.GREEN);
        } catch (Exception e) {
            Symbol s = p.getS();
             textAreaSintatico1.setText("Erro de Sintaxe. Linha: " + (s.right + 1) + " Coluna: " + s.left + ". Texto: \"" + s.value + "\"");
             textAreaSintatico1.setForeground(Color.red);
        }
        
        
       

        //parser parse = new parser();

       
           
      


    }//GEN-LAST:event_btnAnalisarSintatico1ActionPerformed

    private void btnLimpar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar2ActionPerformed
        // ira apenas apagar o que foi inserido nos resultados
        textAreaSintatico1.setText("");
        textAreaSintatico1.setText("");
    }//GEN-LAST:event_btnLimpar2ActionPerformed

    private void btnLimpar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar3ActionPerformed
       
    //LinguagemCisco  cisco = new LinguagemCisco();
        //centralizaForm(obj);  //chama o centralizar
        //des.add(obj);
        //cisco.setVisible(true);
    }//GEN-LAST:event_btnLimpar3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalisar;
    private javax.swing.JButton btnAnalisarSintatico;
    private javax.swing.JButton btnAnalisarSintatico1;
    private javax.swing.JButton btnBuscarArquivo;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLimpar1;
    private javax.swing.JButton btnLimpar2;
    private javax.swing.JButton btnLimpar3;
    private javax.swing.JLabel btn_analiseSintatica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lb_analiseLexica;
    private javax.swing.JLabel lb_entrada;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextArea textArea1;
    private javax.swing.JTextArea textAreaSintatico;
    private javax.swing.JTextArea textAreaSintatico1;
    // End of variables declaration//GEN-END:variables
}
