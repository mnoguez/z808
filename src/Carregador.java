import java.util.ArrayList;

public class Carregador {
    private ArrayList<ArrayList<String>> codigoFinal;
    private TabelaDeSimbolos tabelaSimbolosGlobal;

    public Carregador(ArrayList<ArrayList<String>> codigoFinal, TabelaDeSimbolos tabelaSimbolosGlobal) {
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
        if (comparador.equals("11000000|11000010|11110110")) return true;
        else return false;
    }
    
    public ArrayList<ArrayList<String>> getCodigoFinal() { return codigoFinal;  }

    public void setCodigoFinal(ArrayList<ArrayList<String>> codigoFinal) {this.codigoFinal = codigoFinal;}

    public TabelaDeSimbolos getTabelaSimbolos() {return tabelaSimbolosGlobal;}

    public void setTabelaSimbolos(TabelaDeSimbolos tabelaSimbolosGlobal) {this.tabelaSimbolosGlobal = tabelaSimbolosGlobal;}

}
