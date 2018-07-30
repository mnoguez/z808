import java.util.ArrayList;

public class SeparadorDeCodigo {
    private ArrayList<ArrayList<String>> codigoCompleto;
    private ArrayList<ArrayList<String>> codigoMacros;
    private ArrayList<ArrayList<String>> codigoExecutavel;
    private ArrayList<ArrayList<String>> codigoDados;

    public SeparadorDeCodigo(ArrayList<ArrayList<String>> codigoCompleto) {
        this.codigoCompleto = codigoCompleto;
        this.codigoExecutavel = new ArrayList<ArrayList<String>>();
        this.codigoMacros = new ArrayList<ArrayList<String>>();
        this.codigoDados = new ArrayList<>();
    }

    public void separaCodigoDados(){
        boolean flag = false;
        int i = 0;

        for(ArrayList<String> linha : this.codigoCompleto){
            if(linha.get(0).equals("DADOS") &&  linha.get(1).equals("SEGMENT"))
                flag = true;
            else
                if(flag && !linha.get(0).equals("DADOS") &&  !linha.get(1).equals("ENDS")) {
                    this.codigoDados.add(linha);
                }
                else
                    flag = false;
        }
    }

    public void separaCodigoExecutavel(){
        boolean flag = false;
        int i = 0;

        for(ArrayList<String> linha : this.codigoCompleto){
            if(linha.get(0).equals("CODIGO") &&  linha.get(1).equals("SEGMENT"))
                flag = true;
            else
                if(flag && !linha.get(0).equals("CODIGO") &&  !linha.get(1).equals("ENDS")) {
                    this.codigoExecutavel.add(linha);
                }
                else
                    flag = false;
        }
    }

    /**
     * Metodo que separa o codigo em definições de macros e codigo executável para uma melhor execução da máquina
     */
    public void SeparaCodigoMacros(){
        boolean copiaMacro = false;
        for(ArrayList<String> linha : this.codigoCompleto) {
            if(eInicioDaMacro(linha)) {
                copiaMacro = true;
            }else if (eFimDaMacro(linha)) {
                copiaMacro = false;
                this.codigoMacros.add(linha);
            }
            if (copiaMacro) {
                this.codigoMacros.add(linha);
            }else if(!eFimDaMacro(linha)) {
            }
        }
    }

    /**
     * Metodo que verifica se a linha contém uma definição de macro
     * @param linha ArrayList de Strings
     * @return true se for uma linha que define uma macro e false caso contrario
     */
    public boolean eInicioDaMacro(ArrayList<String> linha){
        for (String comando : linha){
            if (comando.equals("MACRO")) return true;
        }
        return false;
    }

    /**
     * Metodo que verifica se a linha contém uma definição de macro
     * @param linha ArrayList de Strings
     * @return true se for uma linha que define uma macro e false caso contrario
     */
    public boolean eFimDaMacro(ArrayList<String> linha){
        for (String comando : linha){
            if (comando.equals("ENDM")) return true;
        }
        return false;
    }

    public ArrayList<ArrayList<String>> getCodigoCompleto() {
        return codigoCompleto;
    }

    public void setCodigoCompleto(ArrayList<ArrayList<String>> codigoCompleto) {
        this.codigoCompleto = codigoCompleto;
    }

    public ArrayList<ArrayList<String>> getCodigoMacros() {
        return codigoMacros;
    }

    public void setCodigoMacros(ArrayList<ArrayList<String>> codigoMacros) {
        this.codigoMacros = codigoMacros;
    }

    public ArrayList<ArrayList<String>> getCodigoExecutavel() {
        return codigoExecutavel;
    }

    public void setCodigoExecutavel(ArrayList<ArrayList<String>> codigoExecutavel) {
        this.codigoExecutavel = codigoExecutavel;
    }

    public ArrayList<ArrayList<String>> getCodigoDados() {
        return codigoDados;
    }

    public void setCodigoDados(ArrayList<ArrayList<String>> codigoDados) {
        this.codigoDados = codigoDados;
    }
}

