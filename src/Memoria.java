import java.util.ArrayList;

public class Memoria {
    private String[] memoria;
    private int inicioDados;
    private int inicioPilha;

    public Memoria(Integer nbits) {
        this.memoria = new String[(int)Math.pow(2, nbits)];

        for(String posicao : memoria){
            posicao = "0000000000000000";
        }
    }

    public String[] getMemoria() {
        return memoria;
    }

    public void setMemoria(String[] memoria) {
        this.memoria = memoria;
    }
}
