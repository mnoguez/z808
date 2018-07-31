import java.util.ArrayList;

public class Carregador {
    private ArrayList<ArrayList<String>> codigo;
    private TabelaDeSimbolos tabelaSimbolosGlobal;
    private TabelaDeOperacoes tabelaOp;
    private ArrayList<String[]> tabelaFNPV;

    public Carregador(ArrayList<ArrayList<String>> codigo, TabelaDeSimbolos tabelaSimbolosGlobal, TabelaDeOperacoes tabelaOp) {
        this.codigo = codigo;
        this.tabelaSimbolosGlobal = tabelaSimbolosGlobal;
        this.tabelaOp = tabelaOp;
    }

    public void CarregaDados(Registradores registradores, int inicioDoCarregamento, Memoria memoria, ArrayList<ArrayList<String>> dados) {
        registradores.setLC(inicioDoCarregamento);
        registradores.setPC(Integer.toString(inicioDoCarregamento));

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
                else {
                    codigoObjeto.get(i).add(this.tabelaSimbolosGlobal.getTabela().get(simbolo)[0]);
                }
            }

            i++;
        }

        //PREENCHE TABELA FNPV
        this.tabelaFNPV = new ArrayList<>();

        //ESCREVE NA MEMORIA O CODIGO OBJETO
        for(ArrayList<String> linha : codigoObjeto){
            for(String simbolo : linha){
                System.out.println(simbolo);
                memoria.escreveMemoria(simbolo, "c");
            }
        }

        i = 0;

        //ESCREVE PARTE DE DADOS
        for(ArrayList<String> linha : dados){
            for(String simbolo : linha){
                if(this.tabelaSimbolosGlobal.getTabela().containsKey(simbolo)){
                    this.tabelaFNPV.add(new String[3]);
                    this.tabelaFNPV.get(i)[0] = simbolo;
                    this.tabelaFNPV.get(i)[1] = this.tabelaSimbolosGlobal.getTabela().get(simbolo)[0];
                    this.tabelaFNPV.get(i)[2] = Integer.toString(memoria.escreveMemoria(linha.get(2), "d"));
                }
            }
        }
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

    public ArrayList<String[]> getTabelaFNPV() {
        return tabelaFNPV;
    }

    public void setTabelaFNPV(ArrayList<String[]> tabelaFNPV) {
        this.tabelaFNPV = tabelaFNPV;
    }
}
