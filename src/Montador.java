import java.util.ArrayList;
import java.util.HashMap;

public class Montador {
    private TabelaDeSimbolos tabelaSimbolos;

    public Montador(){
        //IMPLEMENTA TABELA DE SIMBOLOS
        this.tabelaSimbolos = new TabelaDeSimbolos();
    }

    /**
     *
     * @param codigoFonte
     * @param registradores
     * @return
     */
    public ArrayList<ArrayList<String>> montaCodigoObjeto(ArrayList<ArrayList<String>> codigoFonte, Registradores registradores, TabelaDeOperacoes tabelaOp){
        ArrayList<ArrayList<String>> codigoObjeto = new ArrayList<ArrayList<String>>();
        int i = 0;

        //PRIMEIRO PASSO
        registradores.setLC(0);

        for(ArrayList<String> linha : codigoFonte){
            for(String simbolo : linha) {
                if (!tabelaOp.getTabela().containsKey(simbolo)) {
                    //ADICIONA SIMBOLO NA TABELA DE SIMBOLOS
                    if (this.tabelaSimbolos.getTabela().containsKey(simbolo) && this.tabelaSimbolos.getTabela().get(simbolo)[1].equals("r"))
                        this.tabelaSimbolos.getTabela().get(simbolo)[0] = Integer.toBinaryString(registradores.getLC());
                    else {
                        this.tabelaSimbolos.getTabela().put(simbolo, new String[2]);
                        this.tabelaSimbolos.getTabela().get(simbolo)[0] = Integer.toBinaryString(registradores.getLC());

                        if(linha.indexOf(simbolo) == 0){
                            this.tabelaSimbolos.getTabela().get(simbolo)[1] = "a";
                            registradores.setLC(registradores.getLC() - 1);
                        }
                        else
                            this.tabelaSimbolos.getTabela().get(simbolo)[1] = "r";
                    }
                }

                registradores.addLC();
            }
        }

        //SEGUNDO PASSO
        for(ArrayList<String> linha : codigoFonte){
            codigoObjeto.add(new ArrayList<String>());

            for(String simbolo : linha){
                if(tabelaOp.getTabela().containsKey(simbolo))
                    codigoObjeto.get(i).add(tabelaOp.getTabela().get(simbolo));
                else
                    codigoObjeto.get(i).add(this.tabelaSimbolos.getTabela().get(simbolo)[0]);
            }

            i++;
        }

        //RETORNA O CODIGO OBJETO
        return codigoObjeto;
    }

    public TabelaDeSimbolos getTabelaSimbolos() {
        return tabelaSimbolos;
    }

    public void setTabelaSimbolos(TabelaDeSimbolos tabelaSimbolos) {
        this.tabelaSimbolos = tabelaSimbolos;
    }
}
