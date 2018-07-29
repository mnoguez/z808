import java.util.ArrayList;
import java.util.HashMap;

public class Montador {
    private HashMap<String, String> tabelaOp;
    private HashMap<String, String[]> tabelaSimbolos;

    public Montador(){
        //IMPLEMENTA TABELA DE OPERACOES
        this.tabelaOp = new HashMap<String, String>();
        this.tabelaOp.put("ADD", "00000011");
        this.tabelaOp.put("DIV", "11110111");
        this.tabelaOp.put("SUB", "00101011");
        this.tabelaOp.put("MUL", "11110111");
        this.tabelaOp.put("CMP", "00111101");
        this.tabelaOp.put("AND", "00100011");
        this.tabelaOp.put("NOT", "11110111");
        this.tabelaOp.put("OR", "00001011");
        this.tabelaOp.put("XOR", "00110011");
        this.tabelaOp.put("JE", "01110100");
        this.tabelaOp.put("JNZ", "01110101");
        this.tabelaOp.put("JMP", "11101011");
        this.tabelaOp.put("AX", "11000000");
        this.tabelaOp.put("DX", "11000010");
        this.tabelaOp.put("SI", "11110110");
        this.tabelaOp.put("MOV", "10001011");

        //IMPLEMENTA TABELA DE SIMBOLOS
        this.tabelaSimbolos = new HashMap<String, String[]>();
    }

    /**
     *
     * @param codigoFonte
     * @param registradores
     * @return
     */
    public ArrayList<ArrayList<String>> montaCodigoObjeto(ArrayList<ArrayList<String>> codigoFonte, Registradores registradores){
        ArrayList<ArrayList<String>> codigoObjeto = new ArrayList<ArrayList<String>>();

        //PRIMEIRO PASSO
        registradores.setLC(0);

        for(ArrayList<String> linha : codigoFonte){
            for(String simbolo : linha) {
                if (!this.tabelaOp.containsKey(simbolo)) {
                    //ADICIONA SIMBOLO NA TABELA DE SIMBOLOS
                    if (this.tabelaSimbolos.containsKey(simbolo) && this.tabelaSimbolos.get(simbolo)[1].equals("r"))
                        this.tabelaSimbolos.get(simbolo)[0] = Integer.toBinaryString(registradores.getLC());
                    else {
                        this.tabelaSimbolos.put(simbolo, new String[2]);
                        this.tabelaSimbolos.get(simbolo)[0] = Integer.toBinaryString(registradores.getLC());

                        if(linha.indexOf(simbolo) == 0){
                            this.tabelaSimbolos.get(simbolo)[1] = "a";
                            registradores.setLC(registradores.getLC() - 1);
                        }
                        else
                            this.tabelaSimbolos.get(simbolo)[1] = "r";
                    }
                }

                registradores.addLC();
            }
        }

        //SEGUNDO PASSO
        for(ArrayList<String> linha : codigoFonte){
            codigoObjeto.add(new ArrayList<String>());

            for(String simbolo : linha){
                if(this.tabelaOp.containsKey(simbolo))
                    codigoObjeto.get(codigoFonte.indexOf(linha)).add(this.tabelaOp.get(simbolo));
                else
                    codigoObjeto.get(codigoFonte.indexOf(linha)).add(this.tabelaSimbolos.get(simbolo)[0]);
            }
        }

        //RETORNA O CODIGO OBJETO
        return codigoObjeto;
    }

    public HashMap<String, String> getTabelaOp() {
        return tabelaOp;
    }

    public void setTabelaOp(HashMap<String, String> tabelaOp) {
        this.tabelaOp = tabelaOp;
    }

    public HashMap<String, String[]> getTabelaSimbolos() {
        return tabelaSimbolos;
    }

    public void setTabelaSimbolos(HashMap<String, String[]> tabelaSimbolos) {
        this.tabelaSimbolos = tabelaSimbolos;
    }
}
