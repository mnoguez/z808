import java.util.ArrayList;

public class AnalisadorLexicoSintatico {
    /**
     * Atributos
     */
    private int cont;
    private int flagSegmentoDados;
    private int flagSegmentoCodigo;
    private int flagSegmentoMacro;
    private int flagOperacao;
    private ArrayList<ArrayList<String>> listaTokens;

    /**
     * Construtor
     */
    public AnalisadorLexicoSintatico(){
        this.cont=0;
        this.flagSegmentoDados=0;
        this.flagSegmentoCodigo=0;
        this.flagSegmentoMacro=0;
        this.flagOperacao=0;
        this.listaTokens = new ArrayList<ArrayList<String>>();
    }

    /**
     * Esse método recebe uma linha do código, na forma de string e quebra tudo em tokens
     * após os tokens serem quebrados eles são add em uma lista de tokens
     * @param Linha
     */
    public void quebraTokens(String Linha){
        String[] tokens = Linha.split("\\s|,\\s|,|:|:\\s|\n");
        addListaTokens(tokens, tokens.length);
    }

    /**
     * Esse método cria uma lista de tokens de acordo com o conjunto de tokens passados como argumento
     * @param Tokens
     * @param Tamanho
     */
    private void addListaTokens(String[] Tokens, int Tamanho){
        this.listaTokens.add(new ArrayList<String>());
        for(int i=0;i<tamanho;i++) {
            this.listaTokens.get(this.cont).add(Tokens[i]);
        }
        this.cont++;
    }

    /**
     * Retorna a Lista de tokens do código informado, para retornar a lista é realizada a análise sintática
     * @return
     */
    public ArrayList<ArrayList<String>> getListaTokens() {
        if(this.analiseSintatica()){
            System.out.println("OK");
            return this.listaTokens;
        }
        else{
            System.out.println("ERROR");
            return null;
        }

    }

    /**
     * Método de teste, verifica se o código informado é quebrado em tokens corretamente
     */
    public void imprimirListaTokens(){
        for(int i=0;i<this.listaTokens.size();i++){
            for(int c=0;c<this.listaTokens.get(i).size();c++){
                System.out.println(this.listaTokens.get(i).get(c));
            }
        }
    }

    /**
     * Analisa se a linha de código a ser verificada contém um label ou somente instrução
     * @param Linha
     * @return
     */
    private int verificadordeInstrucao(ArrayList<String> Linha){
        if(Linha.size()>2) {
            //1º Caso é instrução
            if (Linha.get(0).compareToIgnoreCase("DIV") == 0 || Linha.get(0).compareToIgnoreCase("MUL") == 0 || Linha.get(0).compareToIgnoreCase("ADD") == 0 || Linha.get(0).compareToIgnoreCase("SUB") == 0 || Linha.get(0).compareToIgnoreCase("AND") == 0 || Linha.get(0).compareToIgnoreCase("OR") == 0 || Linha.get(0).compareToIgnoreCase("XOR") == 0 || Linha.get(0).compareToIgnoreCase("CMP") == 0 || Linha.get(0).compareToIgnoreCase("NOT") == 0 || Linha.get(0).compareToIgnoreCase("POP") == 0 || Linha.get(0).compareToIgnoreCase("PUSH") == 0 || Linha.get(0).compareToIgnoreCase("MOV") == 0) {
                return 0;
            }
            //2º Caso é Label
            else if (Linha.get(1).compareToIgnoreCase("DIV") == 0 || Linha.get(1).compareToIgnoreCase("MUL") == 0 || Linha.get(1).compareToIgnoreCase("ADD") == 0 || Linha.get(1).compareToIgnoreCase("SUB") == 0 || Linha.get(1).compareToIgnoreCase("AND") == 0 || Linha.get(1).compareToIgnoreCase("OR") == 0 || Linha.get(1).compareToIgnoreCase("XOR") == 0 || Linha.get(1).compareToIgnoreCase("CMP") == 0 || Linha.get(1).compareToIgnoreCase("NOT") == 0 || Linha.get(1).compareToIgnoreCase("POP") == 0 || Linha.get(1).compareToIgnoreCase("PUSH") == 0 || Linha.get(1).compareToIgnoreCase("MOV") == 0) {
                return 1;
            }
            //3º Caso é chamada de Macro ou qualquer outro identificador que não seja uma instrução
            else {
                return 2;
            }
        }
        return -1;
    }

    /**
     * Analisa sintaticamente a lista de tokens
     * @return
     */
    private boolean analiseSintatica(){
        for(int i=0;i<this.listaTokens.size();i++){
            this.flagOperacao=0;
            if(this.listaTokens.get(i).size()>=2) {
                if (this.listaTokens.get(i).get(1).compareToIgnoreCase("MACRO") == 0) {
                    this.flagOperacao=1;
                    if (this.flagSegmentoMacro == 0) {
                        this.flagSegmentoMacro = 1;
                    } else {
                        return false;
                    }
                }
            }
            if(this.listaTokens.get(i).get(0).compareToIgnoreCase("ENDM")==0){
                this.flagOperacao=1;
                if(this.flagSegmentoMacro==1){
                    this.flagSegmentoMacro=0;
                }
                else{
                    return false;
                }
            }
            if(this.listaTokens.get(i).get(0).compareToIgnoreCase("DADOS")==0&&this.listaTokens.get(i).get(1).compareToIgnoreCase("SEGMENT")==0){
                this.flagOperacao=1;
                if(this.flagSegmentoDados==0&&this.flagSegmentoCodigo==0) {
                    this.flagSegmentoDados = 1;
                }
                else{
                    return false;
                }
            }
            if(this.listaTokens.get(i).get(0).compareToIgnoreCase("DADOS")==0&&this.listaTokens.get(i).get(1).compareToIgnoreCase("ENDS")==0) {
                this.flagOperacao=1;
                if (this.flagSegmentoDados == 1) {
                    this.flagSegmentoDados=-1;
                }
            }
            if(this.listaTokens.get(i).get(0).compareToIgnoreCase("CODIGO")==0&&this.listaTokens.get(i).get(1).compareToIgnoreCase("SEGMENT")==0){
                this.flagOperacao=1;
                if(this.flagSegmentoDados==-1&&this.flagSegmentoCodigo==0) {
                    this.flagSegmentoCodigo = 1;
                }
                else{
                    return false;
                }
            }
            if(this.listaTokens.get(i).get(0).compareToIgnoreCase("CODIGO")==0&&this.listaTokens.get(i).get(1).compareToIgnoreCase("ENDS")==0) {
                this.flagOperacao=1;
                if (this.flagSegmentoCodigo == 1) {
                    this.flagSegmentoCodigo=-1;
                }
            }
            if((this.flagSegmentoCodigo==1||this.flagSegmentoMacro==1)&&(this.verificadordeInstrucao(this.listaTokens.get(i))==0)) {//Desconsidera intruções se estiver analisando dados
                if (this.listaTokens.get(i).get(0).compareToIgnoreCase("DIV") == 0 || this.listaTokens.get(i).get(0).compareToIgnoreCase("MUL") == 0) {
                    this.flagOperacao = 1;
                    if (this.listaTokens.get(i).size() == 2) {
                        if (this.listaTokens.get(i).get(1).compareToIgnoreCase("AX") != 0) {
                            if (this.listaTokens.get(i).get(1).compareToIgnoreCase("SI") != 0) {
                                return false;
                            }
                        }
                    } else {
                        return false;
                    }
                }
                if (this.listaTokens.get(i).get(0).compareToIgnoreCase("ADD") == 0 || this.listaTokens.get(i).get(0).compareToIgnoreCase("SUB") == 0 || this.listaTokens.get(i).get(0).compareToIgnoreCase("AND") == 0 || this.listaTokens.get(i).get(0).compareToIgnoreCase("OR") == 0 || this.listaTokens.get(i).get(0).compareToIgnoreCase("XOR") == 0) {
                    this.flagOperacao = 1;
                    if (this.listaTokens.get(i).size() == 3) {
                        if (this.listaTokens.get(i).get(1).compareToIgnoreCase("AX") == 0) {
                            if (this.listaTokens.get(i).get(2).compareToIgnoreCase("AX") != 0) {
                                if (this.listaTokens.get(i).get(2).compareToIgnoreCase("DX") != 0) {
                                    return false;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                }
                if (this.listaTokens.get(i).get(0).compareToIgnoreCase("CMP") == 0) {
                    this.flagOperacao = 1;
                    if (this.listaTokens.get(i).size() == 3) {
                        if (this.listaTokens.get(i).get(1).compareToIgnoreCase("AX") == 0) {
                            if (this.listaTokens.get(i).get(2).compareToIgnoreCase("DX") != 0) {
                                return false;
                            }
                        }else{
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                if (this.listaTokens.get(i).get(0).compareToIgnoreCase("NOT") == 0) {
                    this.flagOperacao = 1;
                    if (this.listaTokens.get(i).size() == 2) {
                        if (this.listaTokens.get(i).get(1).compareToIgnoreCase("AX") != 0) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                if (this.listaTokens.get(i).get(0).compareToIgnoreCase("POP") == 0 || this.listaTokens.get(i).get(0).compareToIgnoreCase("PUSH") == 0) {
                    this.flagOperacao = 1;
                    if (listaTokens.get(i).size() == 2) {
                        if (this.listaTokens.get(i).get(1).compareToIgnoreCase("AX") != 0) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                if (this.listaTokens.get(i).get(0).compareToIgnoreCase("MOV") == 0) {
                    this.flagOperacao = 1;
                    if (this.listaTokens.get(i).size() == 3) {
                        if (this.listaTokens.get(i).get(1).compareToIgnoreCase("SP") == 0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("SS") == 0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("DS") == 0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("DX") == 0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("SI") == 0) {
                            if (this.listaTokens.get(i).get(2).compareToIgnoreCase("AX") != 0) {
                                return false;
                            }
                        }
                        if (this.listaTokens.get(i).get(1).compareToIgnoreCase("AX") == 0) {
                            if (this.listaTokens.get(i).get(2).compareToIgnoreCase("DS") != 0 && this.listaTokens.get(i).get(2).compareToIgnoreCase("SS") != 0 && this.listaTokens.get(i).get(2).compareToIgnoreCase("SP") != 0 && this.listaTokens.get(i).get(2).compareToIgnoreCase("CS") != 0 && this.listaTokens.get(i).get(2).compareToIgnoreCase("DX") != 0 && this.listaTokens.get(i).get(2).compareToIgnoreCase("SI") != 0) {
                                return false;
                            }
                        }
                    } else {
                        return false;
                    }
                }
                if (this.listaTokens.get(i).get(0).compareToIgnoreCase("JZ") == 0 || this.listaTokens.get(i).get(0).compareToIgnoreCase("JMP") == 0 || this.listaTokens.get(i).get(0).compareToIgnoreCase("CALL") == 0) {
                    this.flagOperacao = 1;
                }
            }
            if(this.verificadordeInstrucao(this.listaTokens.get(i))==1){//É Label
                if (this.listaTokens.get(i).get(1).compareToIgnoreCase("DIV") == 0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("MUL") == 0) {
                    this.flagOperacao = 1;
                    if (this.listaTokens.get(i).get(2).compareToIgnoreCase("AX") != 0) {
                        if (this.listaTokens.get(i).get(2).compareToIgnoreCase("SI") != 0) {
                            return false;
                        }
                    }
                }
                if (this.listaTokens.get(i).get(1).compareToIgnoreCase("ADD") == 0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("SUB") == 0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("AND") == 0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("OR") == 0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("XOR") == 0) {
                    this.flagOperacao = 1;
                    if (this.listaTokens.get(i).get(2).compareToIgnoreCase("AX") == 0) {
                        if (this.listaTokens.get(i).get(3).compareToIgnoreCase("AX") != 0) {
                            if (this.listaTokens.get(i).get(3).compareToIgnoreCase("DX") != 0) {
                                return false;
                            }
                        }
                    } else {
                        return false;
                    }
                }
                if (this.listaTokens.get(i).get(1).compareToIgnoreCase("CMP") == 0) {
                    this.flagOperacao = 1;
                    if (this.listaTokens.get(i).get(2).compareToIgnoreCase("AX") == 0) {
                        if (this.listaTokens.get(i).get(3).compareToIgnoreCase("DX") != 0) {
                            return false;
                        }
                    }
                }
                if (this.listaTokens.get(i).get(1).compareToIgnoreCase("NOT") == 0) {
                    this.flagOperacao = 1;
                    if (this.listaTokens.get(i).get(2).compareToIgnoreCase("AX") != 0) {
                        return false;
                    }
                }
                if (this.listaTokens.get(i).get(1).compareToIgnoreCase("POP") == 0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("PUSH") == 0) {
                    this.flagOperacao = 1;
                    if (this.listaTokens.get(i).get(2).compareToIgnoreCase("AX") != 0) {
                        return false;
                    }
                }
                if (this.listaTokens.get(i).get(1).compareToIgnoreCase("MOV") == 0) {
                    this.flagOperacao = 1;
                    if (this.listaTokens.get(i).get(2).compareToIgnoreCase("SP") == 0 || this.listaTokens.get(i).get(2).compareToIgnoreCase("SS") == 0 || this.listaTokens.get(i).get(2).compareToIgnoreCase("DS") == 0 || this.listaTokens.get(i).get(2).compareToIgnoreCase("DX") == 0 || this.listaTokens.get(i).get(2).compareToIgnoreCase("SI") == 0) {
                        if (this.listaTokens.get(i).get(3).compareToIgnoreCase("AX") != 0) {
                            return false;
                        }
                    }
                    if (this.listaTokens.get(i).get(2).compareToIgnoreCase("AX") == 0) {
                        if (this.listaTokens.get(i).get(3).compareToIgnoreCase("DS") != 0 && this.listaTokens.get(i).get(3).compareToIgnoreCase("SS") != 0 && this.listaTokens.get(i).get(3).compareToIgnoreCase("SP") != 0 && this.listaTokens.get(i).get(3).compareToIgnoreCase("CS") != 0 && this.listaTokens.get(i).get(3).compareToIgnoreCase("DX") != 0 && this.listaTokens.get(i).get(3).compareToIgnoreCase("SI") != 0) {
                            return false;
                        }
                    }
                }
                if (this.listaTokens.get(i).get(1).compareToIgnoreCase("JZ") == 0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("JMP") == 0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("CALL") == 0) {
                    this.flagOperacao = 1;
                }
            }
            /*if (this.flagOperacao == 0) {
                return false;
            }*/
        }
        if((this.flagSegmentoDados==-1||this.flagSegmentoDados==0)&&(this.flagSegmentoCodigo==-1||this.flagSegmentoCodigo==0)&&this.flagSegmentoMacro==0) {
            return true;
        }
        else{
            return false;
        }
    }
}
