import java.lang.String;

public class Registradores{
    private String AX;
    private String DX;
    private String SP;
    private String SI;
    private String IP;
    private String SR;

    public Registradores(){

    }

    public String getAX() {
        return AX;
    }

    public String getDX() {
        return DX;
    }

    public String getIP() {
        return IP;
    }

    public String getSI() {
        return SI;
    }

    public String getSP() {
        return SP;
    }

    public String getSR() {
        return SR;
    }

    public void setAX(String AX) {
        this.AX = AX;
    }

    public void setDX(String DX) {
        this.DX = DX;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public void setSI(String SI) {
        this.SI = SI;
    }

    public void setSP(String SP) {
        this.SP = SP;
    }

    public void setSR(String SR) {
        this.SR = SR;
    }

}