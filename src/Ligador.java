import java.util.ArrayList;
import java.util.HashMap;

public class Ligador {

    public Ligador(){
    }

    public ArrayList<ArrayList<String>> liga(ArrayList<ArrayList<ArrayList<String>>> nmodulos, HashMap<String, String> tabelaOp, Registradores registradores){
        ArrayList<ArrayList<String>> modulos, codigoObjeto;
        HashMap<String, String[]> tsg;
        int deslocamento = 0;

        modulos = new ArrayList<>();
        codigoObjeto = new ArrayList<>();
        tsg = new HashMap<>();

        //PRIMEIRO PASSO
        registradores.setLC(0);

        //JUNTA TODOS OS MODULOS EM UM UNICO MODULO ORDENADO
        for (ArrayList<ArrayList<String>> modulo : nmodulos) {
            for (ArrayList<String> linha : modulo) {
                modulos.add(linha);
            }
        }

        //System.out.println("SIMBOLOS:");

        //RECALCULA POSICOES REFERENTES A SIMBOLOS
        for (ArrayList<String> linha : modulos) {
            for (String simbolo : linha) {
                //System.out.println(simbolo);
                if (!tabelaOp.containsKey(simbolo)) {
                    //ATUALIZA OU ADICIONA SIMBOLO NA TABELA DE SIMBOLOS GLOBAIS
                    if (tsg.containsKey(simbolo) && tsg.get(simbolo)[1].equals("r"))
                        tsg.get(simbolo)[0] = Integer.toBinaryString(registradores.getLC());
                    else {
                        tsg.put(simbolo, new String[2]);
                        tsg.get(simbolo)[0] = Integer.toBinaryString(registradores.getLC());

                        if(linha.indexOf(simbolo) == 0){
                            tsg.get(simbolo)[1] = "a";
                            registradores.setLC(registradores.getLC() - 1);
                        }
                        else
                            tsg.get(simbolo)[1] = "r";
                    }
                }

                registradores.addLC();
            }
        }

        //SEGUNDO PASSO
        for(ArrayList<String> linha : modulos){
            codigoObjeto.add(new ArrayList<String>());

            for(String simbolo : linha){
                if(tabelaOp.containsKey(simbolo))
                    codigoObjeto.get(modulos.indexOf(linha)).add(tabelaOp.get(simbolo));
                else
                    codigoObjeto.get(modulos.indexOf(linha)).add(tsg.get(simbolo)[0]);
            }
        }

        return codigoObjeto;
    }


}
