import java.lang.String;

public class Registradores{
    private String AX;
    private String DX;
    private String SP;
    private String SI;
    private String IP;
    private String SR;
    private String CS;
    private String DS;
    private String SS;

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

    public String getCS() {
        return CS;
    }

    public String getDS() {
        return DS;
    }

    public String getSS() {
        return SS;
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

    public void setCS(String CS) {
        this.CS = CS;
    }

    public void setDS(String DS) {
        this.DS = DS;
    }

    public void setSS(String SS) {
        this.SS = SS;
    }
}