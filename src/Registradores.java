public class Registradores{
    private int AX;
    private int DX;
    private int SP;
    private int SI;
    private int IP;
    private int SR;

    public Registradores(){
        this.SR=0;
    }

    public int getAX() {
        return AX;
    }

    public int getDX() {
        return DX;
    }

    public int getIP() {
        return IP;
    }

    public int getSI() {
        return SI;
    }

    public int getSP() {
        return SP;
    }

    public int getSR() {
        return SR;
    }

    public void setAX(int AX) {
        this.AX = AX;
    }

    public void setDX(int DX) {
        this.DX = DX;
    }

    public void setIP(int IP) {
        this.IP = IP;
    }

    public void setSI(int SI) {
        this.SI = SI;
    }

    public void setSP(int SP) {
        this.SP = SP;
    }

    public void setSR(int SR) {
        this.SR = SR;
    }

}