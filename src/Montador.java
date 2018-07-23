import java.util.ArrayList;
import java.util.HashMap;

public class Montador {
    private ArrayList<String> codigoFonte;
    private HashMap<String, String[]> tabelaOp;
    private HashMap<String, String[]> tabelaSimbolos;

    public Montador(ArrayList<String> codigoFonte){
        for(String linha:codigoFonte){
            this.codigoFonte.add(linha);
        }

        //IMPLEMENTA TABELA DE OPERACOES
        this.tabelaOp = new HashMap<String, String[]>();

        //IMPLEMENTA TABELA DE SIMBOLOS
        this.tabelaSimbolos = new HashMap<String, String[]>();
    }

    /**
     *
     * @return
     */
    public ArrayList<String> montaCodigoObjeto(){
        ArrayList<String> codigoObjeto = new ArrayList<String>();
        String[] aux;

        for(String linha : this.codigoFonte){
            for(String simbolo : linha.split("[ ,]"){
                if(this.tabelaOp.containsKey(palavra)){
                    //ADICIONA CODIGO DE OPERACAO
                }
                else{
                    //ADICIONA SIMBOLO NA TABELA DE SIMBOLOS
                }
            }
        }

        return codigoObjeto;
    }

    public ArrayList<String> getCodigoFonte() {
        return codigoFonte;
    }

    public void setCodigoFonte(ArrayList<String> codigoFonte) {
        this.codigoFonte = codigoFonte;
    }

    public HashMap<String, String[]> getTabelaOp() {
        return tabelaOp;
    }

    public void setTabelaOp(HashMap<String, String[]> tabelaOp) {
        this.tabelaOp = tabelaOp;
    }

    public HashMap<String, String[]> getTabelaSimbolos() {
        return tabelaSimbolos;
    }

    public void setTabelaSimbolos(HashMap<String, String[]> tabelaSimbolos) {
        this.tabelaSimbolos = tabelaSimbolos;
    }
}
