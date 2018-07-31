import java.util.ArrayList;
import java.util.HashMap;

public class Carregador {
    private ArrayList<ArrayList<String>> codigo;
    private TabelaDeSimbolos tabelaSimbolosGlobal;
    private TabelaDeOperacoes tabelaOp;
    private HashMap<String, Integer> tabelaFNPV;

    public Carregador(ArrayList<ArrayList<String>> codigo, TabelaDeSimbolos tabelaSimbolosGlobal, TabelaDeOperacoes tabelaOp) {
        this.codigo = codigo;
        this.tabelaSimbolosGlobal = tabelaSimbolosGlobal;
        this.tabelaOp = tabelaOp;
    }

    public ArrayList<ArrayList<String>> CarregaDados(Registradores registradores, int inicioDoCarregamento, Memoria memoria, ArrayList<ArrayList<String>> dados) {
        registradores.setLC(inicioDoCarregamento);
        int i = 0;

        //RECALCULA POSICOES EM RELAÇAO AO PONTO DE CARREGAMENTO
        for (ArrayList<String> linha : this.codigo) {
            for (String simbolo : linha) {
                //System.out.println(simbolo);
                if (!this.tabelaOp.getTabela().containsKey(simbolo)) {
                    //ATUALIZA OU ADICIONA SIMBOLO NA TABELA DE SIMBOLOS GLOBAIS
                    if (this.tabelaSimbolosGlobal.getTabela().containsKey(simbolo))
                        this.tabelaSimbolosGlobal.getTabela().get(simbolo)[0] = Integer.toBinaryString(registradores.getLC());
                    else {
                        this.tabelaSimbolosGlobal.getTabela().put(simbolo, new String[2]);
                        this.tabelaSimbolosGlobal.getTabela().get(simbolo)[0] = Integer.toBinaryString(registradores.getLC());
                        this.tabelaSimbolosGlobal.getTabela().get(simbolo)[1] = "a";

                        if (linha.indexOf(simbolo) == 0) {
                            registradores.setLC(registradores.getLC() - 1);
                        }
                    }
                }

                registradores.addLC();
            }
        }

        //CRIA CODIGO OBJETO
        ArrayList<ArrayList<String>> codigoObjeto = new ArrayList<>();

        for(ArrayList<String> linha : this.codigo){
            codigoObjeto.add(new ArrayList<String>());

            for(String simbolo : linha){
                if(this.tabelaOp.getTabela().containsKey(simbolo))
                    codigoObjeto.get(i).add(this.tabelaOp.getTabela().get(simbolo));
                else
                    codigoObjeto.get(i).add(this.tabelaSimbolosGlobal.getTabela().get(simbolo)[0]);
            }

            i++;
        }

        //ESCREVE NA MEMORIA O CODIGO OBJETO
        for(ArrayList<String> linha : codigoObjeto){
            for(String simbolo : linha){
                memoria.escreveMemoria(simbolo, "c");
            }
        }

        this.tabelaFNPV = new HashMap<>();

        //ESCREVE PARTE DE DADOS
        for(ArrayList<String> linha : dados){
            this.tabelaFNPV.put(linha.get(0), memoria.escreveMemoria(linha.get(1), "d"));
        }

        return codigoObjeto;
    }

    public boolean eRegistrador(String comparador){
        if (comparador.equals("11000000|11000010|11110110"))
            return true;
        else
            return false;
    }

    public ArrayList<ArrayList<String>> getCodigo() {
        return codigo;
    }

    public void setCodigo(ArrayList<ArrayList<String>> codigo) {
        this.codigo = codigo;
    }

    public TabelaDeSimbolos getTabelaSimbolosGlobal() {
        return tabelaSimbolosGlobal;
    }

    public void setTabelaSimbolosGlobal(TabelaDeSimbolos tabelaSimbolosGlobal) {
        this.tabelaSimbolosGlobal = tabelaSimbolosGlobal;
    }

    public TabelaDeOperacoes getTabelaOp() {
        return tabelaOp;
    }

    public void setTabelaOp(TabelaDeOperacoes tabelaOp) {
        this.tabelaOp = tabelaOp;
    }

    public HashMap<String, Integer> getTabelaFNPV() {
        return tabelaFNPV;
    }

    public void setTabelaFNPV(HashMap<String, Integer> tabelaFNPV) {
        this.tabelaFNPV = tabelaFNPV;
    }
}
