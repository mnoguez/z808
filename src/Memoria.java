import java.util.ArrayList;

public class Memoria {
    private String[] memoria;
    private int inicioCodigo;
    private int inicioDados;
    private int inicioPilha;

    public Memoria(Integer nbits) {
        this.memoria = new String[(int) Math.pow(2, nbits)];

        for(String posicao : memoria){
            posicao = "0000000000000000";
        }

        this.inicioCodigo = 0;
        this.inicioDados = ((int) Math.pow(2, nbits)) / 3;
        this.inicioPilha = 2 * (((int) Math.pow(2, nbits)) / 3);
    }

    public int pegaIndiceLivre(String local){
        int indice = 0;

        if(local.equals("c"))
            for(indice = 0; indice < this.inicioDados; indice++){
                if(this.memoria[indice].equals("0000000000000000"))
                    return indice;
            }
        else if(local.equals("d"))
            for(indice = this.inicioDados; indice < this.inicioPilha; indice++){
                if(this.memoria[indice].equals("0000000000000000"))
                    return indice;
            }
        else if(local.equals("p"))
            for(indice = this.inicioPilha; indice < this.memoria.length; indice++){
                if(this.memoria[indice].equals("0000000000000000"))
                    return indice;
            }

        return -1;
    }

    public int escreveMemoria(String metadado, String local){
        int indice = pegaIndiceLivre(local);

        if(indice > 0) {
            this.memoria[indice] = metadado;

            return indice;
        }
        else
            return -1;
    }

    public String[] getMemoria() {
        return memoria;
    }

    public void setMemoria(String[] memoria) {
        this.memoria = memoria;
    }
}
