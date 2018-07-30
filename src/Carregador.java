import java.util.ArrayList;

public class Carregador {
    private ArrayList<ArrayList<String>> codigoFinal;
    private Tabela tabelaSimbolosGlobal;

    public Carregador(ArrayList<ArrayList<String>> codigoFinal, Tabela tabelaSimbolosGlobal) {
        this.codigoFinal = codigoFinal;
        this.tabelaSimbolosGlobal = tabelaSimbolosGlobal;
    }

    public void CarregaDados(Registradores registradores, int inicioDoCarregamento){
        registradores.setLC(inicioDoCarregamento);

        for(ArrayList<String> linha : this.codigoFinal){
            for(String comando : linha){
                if(!eRegistrador(comando)){
                    if(!this.tabelaSimbolosGlobal.getTabela().get(comando).equals("a")){
                        String[] aux = new String[2];
                        aux[0] = Integer.toBinaryString(registradores.getLC());
                        aux[1] = "a";
                        tabelaSimbolosGlobal.getTabela().put(comando, aux);
                    }
                }
                registradores.addLC();
            }
        }
    }

    public boolean eRegistrador(String comparador){
        if (comparador.equals("AX|DX|SP|SI|IP|SR|CS|DS|SS|PC|RI|REM|RBM")) return true;
        else return false;
    }
    
    public ArrayList<ArrayList<String>> getCodigoFinal() { return codigoFinal;  }

    public void setCodigoFinal(ArrayList<ArrayList<String>> codigoFinal) {this.codigoFinal = codigoFinal;}

    public Tabela getTabelaSimbolos() {return tabelaSimbolosGlobal;}

    public void setTabelaSimbolos(Tabela tabelaSimbolosGlobal) {this.tabelaSimbolosGlobal = tabelaSimbolosGlobal;}

}
