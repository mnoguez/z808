import java.util.ArrayList;

public class ProcessadorDeMacros {

    private ArrayList<String> macros;
    private ArrayList<String> comandos;


    public ProcessadorDeMacros(ArrayList macros, ArrayList comandos) {
        this.macros = macros;
        this.comandos = comandos;
    }

    /**
     * Metodo principal que processa as macros no programa e as expande para criar um programa so
     * @param macros Lista de macros
     * @param comandos Lista de comandos no programa
     * @param nomeDasMacros Lista com o nome de todas as macros definidas
     * @return Programa finalizado com todas as macros expandidos
     */
    public ArrayList<String> ProcessaMacros(ArrayList<String> macros, ArrayList<String> comandos, ArrayList<String> nomeDasMacros){

        ArrayList<String> programaFinalizado = new ArrayList<String>();

        for(String comando : comandos){
            if(IsMacro(nomeDasMacros,comando)){
                
            }
        }

        return programaFinalizado;
    }

    /**
     * Metodo que busca na lista de macros se o comando a ser comparado é uma macro definida
     * @param nomeDasMacros nome de todas as macros definidas
     * @param comando comando a ser comparado se é uma macro na lista de macros
     * @return verdadeiro se  o comando é uma macro dentro da lista de macros
     */
    public Boolean IsMacro(ArrayList<String> nomeDasMacros, String comando){
        for (String nome : nomeDasMacros){
            if(comando.equals(nome)) return true;
        }
        return false;
    }

    /**
     * Metodo que verifica se é o inicio de uma macro
     * @param macros Lista com todas as macros
     * @param index Index para a verificação
     * @return true ou false
     */
    public Boolean MacroBegin(ArrayList<String> macros, int index){
        if(macros.get(index).equals("MACRO")) {
            return true;
        }else return false;
    }

    /**
     * Metodo que verifica se é o fim de uma macro
     * @param macros Lista com todas as macros
     * @param index Index para a verificação
     * @return true ou false
     */
    public Boolean MacroEnd(ArrayList<String> macros, int index){
        if(macros.get(index).equals("ENDM")) {
            return true;
        }else return false;

    }

    public ArrayList getMacros() {
        return macros;
    }

    public void setMacros(ArrayList macros) {
        this.macros = macros;
    }

    public ArrayList getComandos() {
        return comandos;
    }

    public void setComandos(ArrayList comandos) {
        this.comandos = comandos;
    }



}
