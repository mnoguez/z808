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
        this.inicioDados = 2 * (((int) Math.pow(2, nbits)) / 3);
    }

    public String[] getMemoria() {
        return memoria;
    }

    public void setMemoria(String[] memoria) {
        this.memoria = memoria;
    }
}
