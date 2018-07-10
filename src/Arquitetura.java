

public class Arquitetura {

    private int tamanho;
    private Registradores registradores;
    private Memoria memoria;

    public Arquitetura(int tamanho, Registradores registradores){
        this.tamanho = tamanho;
        this.registradores = registradores;
    }

    public Registradores getRegistradores() {
        return registradores;
    }

    public void setRegistradores(Registradores registradores) {
        this.registradores = registradores;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }
}
