import java.util.ArrayList;
import java.util.HashMap;

public abstract class Run {
    public void executa(Registradores registradores, Memoria memoria, ArrayList<ArrayList<String>> codigoObjeto, ArrayList<String[]> tabelaFNPV, TabelaDeSimbolos tsg){
        String str;
        int resultado;

        while(!memoria.getMemoria()[Integer.parseInt(registradores.getPC())].equals("00000000")){
            switch (memoria.getMemoria()[Integer.parseInt(registradores.getPC())]) {
                //CASO ADD
                case "00000011":
                    //CASO AX
                    if(memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 2].equals("11000000")) {
                        str = Integer.toString(Integer.parseInt(registradores.getAX()) + Integer.parseInt(registradores.getAX()));
                        registradores.setAX(str);
                    }
                    else {
                        str = Integer.toString(Integer.parseInt(registradores.getAX()) + Integer.parseInt(registradores.getDX()));
                        registradores.setAX(str);
                    }

                    registradores.setPC(Integer.toString(Integer.parseInt(registradores.getPC()) + 3));
                    break;

                //CASO SUB
                case "00101011":
                    //CASO AX
                    if(memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 2].equals("11000000")) {
                        str = Integer.toString(Integer.parseInt(registradores.getAX()) - Integer.parseInt(registradores.getAX()));
                        registradores.setAX(str);
                    }
                    else {
                        str = Integer.toString(Integer.parseInt(registradores.getAX()) - Integer.parseInt(registradores.getDX()));
                        registradores.setAX(str);
                    }

                    registradores.setPC(Integer.toString(Integer.parseInt(registradores.getPC()) + 3));
                    break;

                //CASO MUL
                //ALTO EM DX
                //BAIXO EM AX
                case "11111111":
                    //CASO AX
                    if(memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 1].equals("11000000")){
                        resultado = Integer.parseInt(registradores.getAX()) * Integer.parseInt(registradores.getAX());
                        str = Integer.toBinaryString(resultado);
                        registradores.setAX(str.substring(0, 15));
                        registradores.setDX(str.substring(16));
                    }
                    else{
                        resultado = Integer.parseInt(registradores.getAX()) * Integer.parseInt(registradores.getSI());
                        str = Integer.toBinaryString(resultado);
                        registradores.setAX(str.substring(0, 15));
                        registradores.setDX(str.substring(16));
                    }

                    registradores.setPC(Integer.toString(Integer.parseInt(registradores.getPC()) + 2));
                    break;

                //CASO DIV
                //COMBINAR DX E AX (DIVIDENDO)
                //DIVISOR AX OU SI
                case "11110111":
                    //CASO AX
                    if(memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 1].equals("11000000")){
                        //(DX + AX) / AX
                        resultado = Integer.parseInt(registradores.getDX() + registradores.getAX()) / Integer.parseInt(registradores.getAX());
                        str = Integer.toBinaryString(resultado);
                        registradores.setAX(str);
                        //(DX + AX) % AX
                        resultado = Integer.parseInt(registradores.getDX() + registradores.getAX()) % Integer.parseInt(registradores.getAX());
                        str = Integer.toBinaryString(resultado);
                        registradores.setDX(str);
                    }
                    else{
                        resultado = Integer.parseInt(registradores.getDX() + registradores.getAX()) / Integer.parseInt(registradores.getSI());
                        str = Integer.toBinaryString(resultado);
                        registradores.setAX(str);
                        resultado = Integer.parseInt(registradores.getDX() + registradores.getAX()) % Integer.parseInt(registradores.getSI());
                        str = Integer.toBinaryString(resultado);
                        registradores.setDX(str);
                    }

                    registradores.setPC(Integer.toString(Integer.parseInt(registradores.getPC()) + 2));
                    break;

                //CASO MOV
                case "10001011":
                    switch (memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 1]){
                        //AX
                        case "11000000":
                            //DX
                            //SI
                            //VAR
                            if(memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 2].equals("11000010"))
                                registradores.setAX(registradores.getDX());
                            else if(memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 2].equals("11110110"))
                                registradores.setAX(registradores.getSI());
                            else{
                                for(String[] simbolo : tabelaFNPV){
                                    //POSICAO 1 = ENDEREÇO DO SIMBOLO
                                    if(memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 2].equals(simbolo[1])){
                                        registradores.setAX(memoria.buscaMemoria(Integer.parseInt(simbolo[2], 10)));
                                    }
                                }
                            }

                            break;

                        //DX
                        case "11000010":
                            //AX
                            //SI
                            //VAR
                            if(memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 2].equals("11000000"))
                                registradores.setAX(registradores.getDX());
                            else if(memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 2].equals("11110110"))
                                registradores.setAX(registradores.getSI());
                            else{
                                for(String[] simbolo : tabelaFNPV){
                                    //POSICAO 1 = ENDEREÇO DO SIMBOLO
                                    if(memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 2].equals(simbolo[1])){
                                        registradores.setDX(memoria.buscaMemoria(Integer.parseInt(simbolo[2], 10)));
                                    }
                                }
                            }
                            break;

                        //SI
                        case "11110110":
                            //AX
                            //DX
                            //VAR
                            if(memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 2].equals("11000000"))
                                registradores.setAX(registradores.getDX());
                            else if(memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 2].equals("11000010"))
                                registradores.setAX(registradores.getSI());
                            else{
                                for(String[] simbolo : tabelaFNPV){
                                    //POSICAO 1 = ENDEREÇO DO SIMBOLO
                                    if(memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 2].equals(simbolo[1])){
                                        registradores.setSI(memoria.buscaMemoria(Integer.parseInt(simbolo[2], 10)));
                                    }
                                }
                            }
                            break;
                    }

                    registradores.setPC(Integer.toString(Integer.parseInt(registradores.getPC()) + 3));
                    break;

                //CASO AND
                case "00100011":
                    break;

                //CASO JUMP
                case "11101011":
                    registradores.setPC(memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 1]);
                    break;

                //CASO JUMP IGUAL A ZERO
                case "01110100":
                    if(Integer.parseInt(registradores.getAX(), 2) == 0)
                        registradores.setPC(memoria.getMemoria()[Integer.parseInt(registradores.getPC()) + 1]);
                    else
                        registradores.setPC(Integer.toString(Integer.parseInt(registradores.getPC()) + 1));
            }
        }
    }
}
