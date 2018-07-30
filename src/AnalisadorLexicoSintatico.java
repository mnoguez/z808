import java.util.ArrayList;

public class AnalisadorLexicoSintatico {
    private int cont;
    private int flagSegmentoDados;
    private int flagSegmentoCodigo;
    private int flagSegmentoMacro;
    private int flagOperacao;
    private ArrayList<ArrayList<String>> listaTokens;

    public AnalisadorLexicoSintatico(){
        this.cont=0;
        this.flagSegmentoDados=0;
        this.flagSegmentoCodigo=0;
        this.flagSegmentoMacro=0;
        this.flagOperacao=0;
        this.listaTokens = new ArrayList<ArrayList<String>>();
    }

    public void quebraTokens(String Linha){
        String[] tokens = Linha.split("\\s|,\\s|,|:|:\\s");
        addListaTokens(tokens, tokens.length);
    }

    private void addListaTokens(String[] Tokens, int tamanho){
        this.listaTokens.add(new ArrayList<String>());
        for(int i=0;i<tamanho;i++) {
            this.listaTokens.get(this.cont).add(Tokens[i]);
        }
        this.cont++;
    }

    public ArrayList<ArrayList<String>> getListaTokens() {
        if(this.analiseSintatica()){
            System.out.println("OK");
            return this.listaTokens;
        }
        else{
            System.out.println("Tem Erro seu sopa");
            return null;
        }

    }

    public void imprimirListaTokens(){
        for(int i=0;i<this.listaTokens.size();i++){
            for(int c=0;c<this.listaTokens.get(i).size();c++){
                System.out.println(this.listaTokens.get(i).get(c));
            }
        }
    }

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
                    this.flagSegmentoMacro=-1;
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
            if(this.listaTokens.get(i).get(0).compareToIgnoreCase("DADOS")==0&&this.listaTokens.get(i).get(1).compareToIgnoreCase("END")==0) {
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
            if(this.listaTokens.get(i).get(0).compareToIgnoreCase("CODIGO")==0&&this.listaTokens.get(i).get(1).compareToIgnoreCase("END")==0) {
                this.flagOperacao=1;
                if (this.flagSegmentoCodigo == 1) {
                    this.flagSegmentoCodigo=-1;
                }
            }
            if(this.listaTokens.get(i).get(0).compareToIgnoreCase("DIV")==0||this.listaTokens.get(i).get(0).compareToIgnoreCase("MUL")==0){
                this.flagOperacao=1;
                if(this.listaTokens.get(i).size()==2){
                    if(this.listaTokens.get(i).get(1).compareToIgnoreCase("AX")!=0){
                        if(this.listaTokens.get(i).get(1).compareToIgnoreCase("SI")!=0){
                            return false;
                        }
                    }
                }
                else{
                    return false;
                }
            }
            //Considerando LABEL
            if(this.listaTokens.get(i).get(1).compareToIgnoreCase("DIV")==0||this.listaTokens.get(i).get(1).compareToIgnoreCase("MUL")==0){
                this.flagOperacao=1;
                if(this.listaTokens.get(i).size()<=3){
                    if(this.listaTokens.get(i).get(2).compareToIgnoreCase("AX")!=0){
                        if(this.listaTokens.get(i).get(2).compareToIgnoreCase("SI")!=0){
                            return false;
                        }
                    }
                }
                else{
                    return false;
                }
            }
            if (this.listaTokens.get(i).get(0).compareToIgnoreCase("ADD")==0 || this.listaTokens.get(i).get(0).compareToIgnoreCase("SUB")==0 || this.listaTokens.get(i).get(0).compareToIgnoreCase("AND")==0 || this.listaTokens.get(i).get(0).compareToIgnoreCase("OR")==0 || this.listaTokens.get(i).get(0).compareToIgnoreCase("XOR")==0) {
                this.flagOperacao=1;
                //System.out.println("Entrou");
                if (this.listaTokens.get(i).size() == 3) {
                    if (this.listaTokens.get(i).get(1).compareToIgnoreCase("AX")==0) {
                        if (this.listaTokens.get(i).get(2).compareToIgnoreCase("AX")!=0) {
                            if (this.listaTokens.get(i).get(2).compareToIgnoreCase("DX")!=0) {
                                return false;
                            }
                        }
                        else {return false;}
                    }else{
                        return false;
                    }
                }
            }
            //Considerando LABEL
            if (this.listaTokens.get(i).get(1).compareToIgnoreCase("ADD")==0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("SUB")==0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("AND")==0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("OR")==0 || this.listaTokens.get(i).get(1).compareToIgnoreCase("XOR")==0) {
                this.flagOperacao=1;
                if (this.listaTokens.get(i).size() <= 4) {
                    if (this.listaTokens.get(i).get(2).compareToIgnoreCase("AX")==0) {
                        if (this.listaTokens.get(i).get(3).compareToIgnoreCase("AX")!=0) {
                            if (this.listaTokens.get(i).get(3).compareToIgnoreCase("DX")!=0) {
                                return false;
                            }
                        }
                        else {return false;}
                    }else{
                        return false;
                    }
                }
            }
            if(this.listaTokens.get(i).get(0).compareToIgnoreCase("CMP")==0){
                this.flagOperacao=1;
                if(this.listaTokens.get(i).size()==3){
                    if(this.listaTokens.get(i).get(1).compareToIgnoreCase("AX")==0){
                        if(this.listaTokens.get(i).get(2).compareToIgnoreCase("DX")!=0){
                            return false;
                        }
                    }
                }
                else{
                    return false;
                }
            }
            //Considerando LABEL
            if(this.listaTokens.get(i).get(1).compareToIgnoreCase("CMP")==0){
                this.flagOperacao=1;
                if(this.listaTokens.get(i).size()<=4){
                    if(this.listaTokens.get(i).get(2).compareToIgnoreCase("AX")==0){
                        if(this.listaTokens.get(i).get(3).compareToIgnoreCase("DX")!=0){
                            return false;
                        }
                    }
                }
                else{
                    return false;
                }
            }
            if(this.listaTokens.get(i).get(0).compareToIgnoreCase("NOT")==0){
                this.flagOperacao=1;
                if(this.listaTokens.get(i).size()==2){
                    if(this.listaTokens.get(i).get(1).compareToIgnoreCase("AX")!=0){
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            //Considerando LABEL
            if(this.listaTokens.get(i).get(1).compareToIgnoreCase("NOT")==0){
                this.flagOperacao=1;
                if(this.listaTokens.get(i).size()<=3){
                    if(this.listaTokens.get(i).get(2).compareToIgnoreCase("AX")!=0){
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            if(this.listaTokens.get(i).get(0).compareToIgnoreCase("POP")==0||this.listaTokens.get(i).get(0).compareToIgnoreCase("PUSH")==0){
                this.flagOperacao=1;
                if(listaTokens.get(i).size()==2){
                    if(this.listaTokens.get(i).get(1).compareToIgnoreCase("AX")!=0){
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            //Considerando LABEL
            if(this.listaTokens.get(i).get(1).compareToIgnoreCase("POP")==0||this.listaTokens.get(i).get(1).compareToIgnoreCase("PUSH")==0){
                this.flagOperacao=1;
                if(listaTokens.get(i).size()<=3){
                    if(this.listaTokens.get(i).get(2).compareToIgnoreCase("AX")!=0){
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            if(this.listaTokens.get(i).get(0).compareToIgnoreCase("MOV")==0){
                this.flagOperacao=1;
                if(this.listaTokens.get(i).size()==3){
                    if(this.listaTokens.get(i).get(1).compareToIgnoreCase("SP")==0||this.listaTokens.get(i).get(1).compareToIgnoreCase("SS")==0||this.listaTokens.get(i).get(1).compareToIgnoreCase("DS")==0||this.listaTokens.get(i).get(1).compareToIgnoreCase("DX")==0||this.listaTokens.get(i).get(1).compareToIgnoreCase("SI")==0){
                        if(this.listaTokens.get(i).get(2).compareToIgnoreCase("AX")!=0){
                            return false;
                        }
                    }
                    if(this.listaTokens.get(i).get(1).compareToIgnoreCase("AX")==0){
                        if(this.listaTokens.get(i).get(2).compareToIgnoreCase("DS")!=0&&this.listaTokens.get(i).get(2).compareToIgnoreCase("SS")!=0&&this.listaTokens.get(i).get(2).compareToIgnoreCase("SP")!=0&&this.listaTokens.get(i).get(2).compareToIgnoreCase("CS")!=0&&this.listaTokens.get(i).get(2).compareToIgnoreCase("DX")!=0&&this.listaTokens.get(i).get(2).compareToIgnoreCase("SI")!=0){
                            return false;
                        }
                    }
                }
                else{
                    return false;
                }
            }
            //Considerando LABEL
            if(this.listaTokens.get(i).get(1).compareToIgnoreCase("MOV")==0){
                this.flagOperacao=1;
                if(this.listaTokens.get(i).size()<=4){
                    if(this.listaTokens.get(i).get(2).compareToIgnoreCase("SP")==0||this.listaTokens.get(i).get(2).compareToIgnoreCase("SS")==0||this.listaTokens.get(i).get(2).compareToIgnoreCase("DS")==0||this.listaTokens.get(i).get(2).compareToIgnoreCase("DX")==0||this.listaTokens.get(i).get(2).compareToIgnoreCase("SI")==0){
                        if(this.listaTokens.get(i).get(3).compareToIgnoreCase("AX")!=0){
                            return false;
                        }
                    }
                    if(this.listaTokens.get(i).get(2).compareToIgnoreCase("AX")==0){
                        this.flagOperacao=1;
                        if(this.listaTokens.get(i).get(3).compareToIgnoreCase("DS")!=0&&this.listaTokens.get(i).get(3).compareToIgnoreCase("SS")!=0&&this.listaTokens.get(i).get(3).compareToIgnoreCase("SP")!=0&&this.listaTokens.get(i).get(3).compareToIgnoreCase("CS")!=0&&this.listaTokens.get(i).get(3).compareToIgnoreCase("DX")!=0&&this.listaTokens.get(i).get(3).compareToIgnoreCase("SI")!=0){
                            return false;
                        }
                    }
                }
                else{
                    return false;
                }
            }
            if(this.listaTokens.get(i).get(0).compareToIgnoreCase("JZ")==0||this.listaTokens.get(i).get(0).compareToIgnoreCase("JNZ")==0||this.listaTokens.get(i).get(0).compareToIgnoreCase("CALL")==0){
                this.flagOperacao=1;
            }
            //Considerando LABEL
            if(this.listaTokens.get(i).get(1).compareToIgnoreCase("JZ")==0||this.listaTokens.get(i).get(1).compareToIgnoreCase("JNZ")==0||this.listaTokens.get(i).get(1).compareToIgnoreCase("CALL")==0){
                this.flagOperacao=1;
            }
            if(this.flagOperacao==0){
                return false;
            }
        }
        if(this.flagSegmentoDados==-1&&this.flagSegmentoCodigo==-1&&(this.flagSegmentoMacro==-1||this.flagSegmentoMacro==0)) {
            return true;
        }
        else{
            return false;
        }
    }
}
