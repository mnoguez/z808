

public class Arquitetura {

    private int tamanho; //TAMANHO DA ARQUITETURA (16 BITS)
    private Registradores registradores; //CONJUNTO DE REGISTRADORES
    private Memoria memoria; //MEMORIA

    public Arquitetura(){
        this.tamanho = 16; //16 BITS
        this.registradores = new Registradores();
        this.memoria = new Memoria();
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public Registradores getRegistradores() {
        return registradores;
    }

    public void setRegistradores(Registradores registradores) {
        this.registradores = registradores;
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }
}
