import java.util.ArrayList;
import java.util.HashMap;

public class ProcessadorDeMacros {

    private ArrayList<ArrayList<String>> macros;
    private ArrayList<ArrayList<String>> comandos;


    public ProcessadorDeMacros(ArrayList<ArrayList<String>> macros, ArrayList<ArrayList<String>> comandos) {
        this.macros = macros;
        this.comandos = comandos;
    }

    /**
     * Metodo principal que processa as macros no programa e as expande para criar um programa so
     *
     * @param macros        Lista de macros
     * @param comandos      Lista de comandos no programa
     * @return Programa finalizado com todas as macros expandidos
     */
    public ArrayList<ArrayList<String>> ProcessaMacros(ArrayList<ArrayList<String>> macros, ArrayList<ArrayList<String>> comandos) {

        ArrayList<ArrayList<String>> programaFinalizado = new ArrayList<>();
        ArrayList<ArrayList<String>> corpoDaMacro;
        ArrayList<String> variaveis = new ArrayList<>();
        ArrayList<String> nomeDasMacros;

        nomeDasMacros = SeparaNomeDasMacros(macros);
/*
        for(String nome : nomeDasMacros){
            System.out.println(nome);
        }
*/
        boolean buscaMacro = false;
        String aux = new String();

        for (ArrayList<String> linhas : comandos) {
            for (String comando : linhas) {
                if (buscaMacro) {
                    variaveis.add(comando);
                }
                if (IsMacro(nomeDasMacros, comando)) {
                    buscaMacro = true;
                    aux = comando;
                }
            }
            if(buscaMacro){
                corpoDaMacro = BuscaCorpoDaMacro(macros, aux, variaveis);
                for(ArrayList<String> linha: corpoDaMacro){
                    programaFinalizado.add(linha);
                }
                variaveis.clear();
                buscaMacro = false;
            }else {
                programaFinalizado.add(linhas);
            }
        }

        return programaFinalizado;
    }


    /**
     * Metodo que busca o corpo do programa de uma macro
     * @param macros Arraylist de todas as macros
     * @param nomeMacro String com o nome da macro a ser buscada
     * @param variaveis Arraylist das variaveis a serem substituidas na macro
     * @return retorna uma Arraylis com todas as linhas do corpo macro da macro
     */
    public ArrayList<ArrayList<String>> BuscaCorpoDaMacro(ArrayList<ArrayList<String>> macros, String nomeMacro, ArrayList<String> variaveis){
        ArrayList<ArrayList<String>> corpoDaMacro = new ArrayList<>();
        HashMap<String, String> variaveisParaTroca = new HashMap<>();
        boolean começaCopia = false;
        boolean arrumaVariavies;
        boolean finaliza = false;
        int indexVariavel = 0;

        for(ArrayList<String> linhas : macros) {
            arrumaVariavies = false;
            if (começaCopia) {
                corpoDaMacro.add(linhas);
            }
            for (String comando : linhas) {
                if (arrumaVariavies && !(comando.equals("MACRO"))){
                    variaveisParaTroca.put(comando,variaveis.get(indexVariavel));
                    indexVariavel++;
                }
                if ( comando.equals(nomeMacro) && !finaliza){
                    começaCopia = true;
                    arrumaVariavies = true;
                }
                if ( começaCopia && MacroEnd(comando) ) {
                    começaCopia = false;
                    finaliza = true;
                    corpoDaMacro.remove(linhas);
                }
            }
        }
        return AtualizaVariaveis(corpoDaMacro, variaveisParaTroca);
    }


    /**
     * Metodo que altera as variaveis no corpo da macro para o mesmo nome da chamada da macro
     * @param corpoDaMacro ArrayList com o codigo do corpo da macro
     * @param variaveis HashMap com a combinacao da troca do nome das variaveis
     * @return corpo da macro modificado
     */
    public ArrayList<ArrayList<String>> AtualizaVariaveis(ArrayList<ArrayList<String>> corpoDaMacro, HashMap<String,String> variaveis){
        for(ArrayList<String> linha: corpoDaMacro){
            for(String variavel: linha){
                if(variaveis.containsKey(variavel)){
                    corpoDaMacro.get(corpoDaMacro.indexOf(linha)).set(linha.indexOf(variavel), variaveis.get(variavel));
                }
            }
        }
        return corpoDaMacro;
    }

    /**
     * Metodos para armazenar todos os nomes das macros definidas no programa
     *
     * @param macros Lista do programa com as Definicoes das macros
     * @return lista de nomes das macros
     */
    public ArrayList<String> SeparaNomeDasMacros(ArrayList<ArrayList<String>> macros) {
        ArrayList<String> nomeDasMacros = new ArrayList<>();

        for (ArrayList<String> macro : macros) {
            for (String comando : macro) {
                if (MacroBegin(comando)) {
                    nomeDasMacros.add(macro.get(macro.indexOf(comando) - 1));
                }
            }
        }
        return nomeDasMacros;
    }

    /**
     * Metodo que busca na lista de macros se o comando a ser comparado é uma macro definida
     *
     * @param nomeDasMacros nome de todas as macros definidas
     * @param comando       comando a ser comparado se é uma macro na lista de macros
     * @return verdadeiro se  o comando é uma macro dentro da lista de macros
     */
    public Boolean IsMacro(ArrayList<String> nomeDasMacros, String comando) {
        for (String nome : nomeDasMacros) {
            if (comando.equals(nome)) return true;
        }
        return false;
    }

    /**
     * Metodo que verifica se é o inicio de uma macro
     *
     * @param macros Lista com todas as macros
     * @return true ou false
     */
    public Boolean MacroBegin(String macros) {
        if (macros.equals("MACRO")) {
            return true;
        } else return false;
    }

    /**
     * Metodo que verifica se é o fim de uma macro
     *
     * @param macros Lista com todas as macros
     * @return true ou false
     */
    public Boolean MacroEnd(String macros) {
        if (macros.equals("ENDM")) {
            return true;
        } else return false;

    }

    public ArrayList<ArrayList<String>> getMacros() {
        return macros;
    }

    public void setMacros(ArrayList<ArrayList<String>> macros) {
        this.macros = macros;
    }

    public ArrayList<ArrayList<String>> getComandos() {
        return comandos;
    }

    public void setComandos(ArrayList<ArrayList<String>> comandos) {
        this.comandos = comandos;
    }

}