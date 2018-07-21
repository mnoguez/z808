/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador;

import java.awt.TextArea;
import java.io.StringReader;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import utils.Look;

/**
 *
 * @author yasmin
 */
public class Interface extends javax.swing.JFrame { 
    
    public JTextArea jText;
    
   // metodo executar
    public void executar()throws Exception{ 
     
       int cont = 0;     
       
       jText = textArea1;    //recebe o que foi digitado
       String expr;
       //jText = textArea1;
       expr = (String)jText.getText();   //passa o que foi digitado para uma string e armazena na variável "expr"
       Lexer lexer = new Lexer(new StringReader(expr));   //cria um objeto "lexer", que é da classe "Lexer.java" em passamos 
                                                         //a expressão que foi digitada pelo usuário
                                                         //vai fazer a analise e retorna o tipo de "token" que foi inserido, 
                                                         //que foi especificado na classe "Lexer.java"    
       
       String resultado="";
       
       while(true){
           Token token = lexer.yylex();
           if(token == null){
               
                textArea.setText(resultado);
                //textArea.setForeground(Color.BLACK);
               
                return;
           }
               //cases para mostrarmos a saida dos tokens 
               switch(token){                
                
                case PALAVRA:                    
                    //cont ++;
                    resultado = resultado + "Linha: " + cont +  "<Palavra_Reservada> " + lexer.lexeme + "\n";     
                    break;
                    
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
                    
                case OP_BOOLEANO:
                    //cont++;
                    resultado = resultado + "Linha: " + cont +  "<Operador_Booleano> " + lexer.lexeme + "\n" ;
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
                  
                case IF:
                   //cont ++;
                   resultado = resultado + "Linha: " + cont + "<IF>" + lexer.lexeme + "\n";
                   break;  
                   
                case ELSE:
                   //cont ++;
                   resultado = resultado + "Linha: " + cont + "<ELSE>" + lexer.lexeme + "\n";
                   break; 
                   
                case FIM_IF:
                   //cont ++;
                   resultado = resultado + "Linha: " + cont + "<Fim_if>" + lexer.lexeme + "\n";
                   break;                   
                
                   
                default:
                    //cont ++;
                    resultado = resultado + "Linha: " + cont + "<" + lexer.lexeme +">" + cont++;
                    break;                
           }
       }
    }

    public Interface() {
        initComponents();
        this.setLocationRelativeTo(this);
        Look.definelook(this);
        //setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_analiseLexica = new javax.swing.JLabel();
        lb_entrada = new javax.swing.JLabel();
        btnAnalisar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane3.setViewportView(textArea);

        textArea1.setColumns(20);
        textArea1.setRows(5);
        jScrollPane1.setViewportView(textArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_entrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnalisar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_analiseLexica, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_analiseLexica)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_entrada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAnalisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisarActionPerformed
        //chamada do metod executar
        try{
            executar();
        }catch(Exception e)
                {e.printStackTrace();
                }
    }//GEN-LAST:event_btnAnalisarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // ira apenas apagar o que foi inserido nos resultados
        textArea1.setText("");
        textArea.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalisar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_analiseLexica;
    private javax.swing.JLabel lb_entrada;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
