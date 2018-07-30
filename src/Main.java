import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String args[]){

        ArrayList<ArrayList<String>> macros = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> codigoFinal = new ArrayList<ArrayList<String>>();

        macros.add(new ArrayList<String>());
        macros.get(0).add("SOMA");
        macros.get(0).add("MACRO");
        macros.get(0).add("AAUX");
        macros.get(0).add("BAUX");
        macros.get(0).add("CAUX");
        macros.add(new ArrayList<String>());
        macros.get(1).add("ADD");
        macros.get(1).add("AAUX");
        macros.get(1).add("BAUX");
        macros.add(new ArrayList<String>());
        macros.get(2).add("SUB");
        macros.get(2).add("CAUX");
        macros.get(2).add("AAUX");
        macros.add(new ArrayList<String>());
        macros.get(3).add("ENDM");
        macros.add(new ArrayList<String>());
        macros.get(4).add("LOUCURA");
        macros.get(4).add("MACRO");
        macros.get(4).add("UM");
        macros.get(4).add("DOIS");
        macros.get(4).add("TRES");
        macros.add(new ArrayList<String>());
        macros.get(5).add("ADD");
        macros.get(5).add("UM");
        macros.get(5).add("DOIS");
        macros.add(new ArrayList<String>());
        macros.get(6).add("SUB");
        macros.get(6).add("DOIS");
        macros.get(6).add("TRES");
        macros.add(new ArrayList<String>());
        macros.get(7).add("MUL");
        macros.get(7).add("DOIS");
        macros.get(7).add("UM");
        macros.add(new ArrayList<String>());
        macros.get(8).add("DIV");
        macros.get(8).add("DOIS");
        macros.get(8).add("TRES");
        macros.get(8).add("ENDM");

        macros.add(new ArrayList<String>());
        macros.get(9).add("DADOS");
        macros.get(9).add("SEGMENT");
        macros.add(new ArrayList<String>());
        macros.get(10).add("VAR1");
        macros.get(10).add("CMP");
        macros.get(10).add("8");
        macros.add(new ArrayList<String>());
        macros.get(11).add("VAR2");
        macros.get(11).add("CMP");
        macros.get(11).add("15");
        macros.add(new ArrayList<String>());
        macros.get(12).add("VAR3");
        macros.get(12).add("CMP");
        macros.get(12).add("18");
        macros.add(new ArrayList<String>());
        macros.get(13).add("DADOS");
        macros.get(13).add("ENDS");

        macros.add(new ArrayList<String>());
        macros.get(14).add("CODIGO");
        macros.get(14).add("SEGMENT");
        macros.add(new ArrayList<String>());
        macros.get(15).add("ADD");
        macros.get(15).add("TESTE");
        macros.get(15).add("DX");
        macros.add(new ArrayList<String>());
        macros.get(16).add("ADD");
        macros.get(16).add("TESTE");
        macros.get(16).add("SI");
        macros.add(new ArrayList<String>());
        macros.get(17).add("ADD");
        macros.get(17).add("AX");
        macros.get(17).add("DX");
        macros.add(new ArrayList<String>());
        macros.get(18).add("SOMA");
        macros.get(18).add("ABC");
        macros.get(18).add("DEF");
        macros.get(18).add("GHE");
        macros.add(new ArrayList<String>());
        macros.get(19).add("LOUCURA");
        macros.get(19).add("QUATRO");
        macros.get(19).add("CINCO");
        macros.get(19).add("SEIS");
        macros.add(new ArrayList<String>());
        macros.get(20).add("ADD");
        macros.get(20).add("AX");
        macros.get(20).add("DX");
        macros.add(new ArrayList<String>());
        macros.get(21).add("ADD");
        macros.get(21).add("AX");
        macros.get(21).add("DX");
        macros.add(new ArrayList<String>());
        macros.get(22).add("ADD");
        macros.get(22).add("AX");
        macros.get(22).add("DX");
        macros.add(new ArrayList<String>());
        macros.get(23).add("ADD");
        macros.get(23).add("AX");
        macros.get(23).add("DX");
        macros.add(new ArrayList<String>());
        macros.get(24).add("CODIGO");
        macros.get(24).add("ENDS");

        ArrayList<ArrayList<String>> modulo2 = new ArrayList<ArrayList<String>>();
        modulo2.add(new ArrayList<String>());
        modulo2.get(0).add("CALC");
        modulo2.get(0).add("MACRO");
        modulo2.get(0).add("VAR1");
        modulo2.get(0).add("VAR2");
        modulo2.get(0).add("VAR3");
        modulo2.add(new ArrayList<String>());
        modulo2.get(1).add("ADD");
        modulo2.get(1).add("VAR1");
        modulo2.get(1).add("VAR2");
        modulo2.add(new ArrayList<String>());
        modulo2.get(2).add("SUB");
        modulo2.get(2).add("VAR2");
        modulo2.get(2).add("VAR3");
        modulo2.add(new ArrayList<String>());
        modulo2.get(3).add("ENDM");
        modulo2.add(new ArrayList<String>());
        modulo2.get(4).add("FIBO");
        modulo2.get(4).add("MACRO");
        modulo2.get(4).add("VAR1");
        modulo2.get(4).add("VAR2");
        modulo2.get(4).add("VAR3");
        modulo2.add(new ArrayList<String>());
        modulo2.get(5).add("ADD");
        modulo2.get(5).add("VAR1");
        modulo2.get(5).add("VAR2");
        modulo2.add(new ArrayList<String>());
        modulo2.get(6).add("SUB");
        modulo2.get(6).add("VAR2");
        modulo2.get(6).add("VAR3");
        modulo2.add(new ArrayList<String>());
        modulo2.get(7).add("MUL");
        modulo2.get(7).add("VAR2");
        modulo2.get(7).add("VAR1");
        modulo2.add(new ArrayList<String>());
        modulo2.get(8).add("DIV");
        modulo2.get(8).add("VAR3");
        modulo2.get(8).add("VAR1");
        modulo2.add(new ArrayList<String>());
        modulo2.get(9).add("ENDM");

        modulo2.add(new ArrayList<String>());
        modulo2.get(10).add("DADOS");
        modulo2.get(10).add("SEGMENT");
        modulo2.add(new ArrayList<String>());
        modulo2.get(11).add("VAR1");
        modulo2.get(11).add("CMP");
        modulo2.get(11).add("15");
        modulo2.add(new ArrayList<String>());
        modulo2.get(12).add("VAR2");
        modulo2.get(12).add("CMP");
        modulo2.get(12).add("16");
        modulo2.add(new ArrayList<String>());
        modulo2.get(13).add("VAR3");
        modulo2.get(13).add("CMP");
        modulo2.get(13).add("21");
        modulo2.add(new ArrayList<String>());
        modulo2.get(14).add("DADOS");
        modulo2.get(14).add("ENDS");

        modulo2.add(new ArrayList<String>());
        modulo2.get(15).add("CODIGO");
        modulo2.get(15).add("SEGMENT");
        modulo2.add(new ArrayList<String>());
        modulo2.get(16).add("SUB");
        modulo2.get(16).add("AX");
        modulo2.get(16).add("SI");
        modulo2.add(new ArrayList<String>());
        modulo2.get(17).add("ADD");
        modulo2.get(17).add("VAR");
        modulo2.get(17).add("SI");
        modulo2.add(new ArrayList<String>());
        modulo2.get(18).add("SUB");
        modulo2.get(18).add("AX");
        modulo2.get(18).add("SI");
        modulo2.add(new ArrayList<String>());
        modulo2.get(19).add("CALC");
        modulo2.get(19).add("VAR1");
        modulo2.get(19).add("VAR2");
        modulo2.get(19).add("VAR2");
        modulo2.add(new ArrayList<String>());
        modulo2.get(20).add("FIBO");
        modulo2.get(20).add("VAR4");
        modulo2.get(20).add("VAR5");
        modulo2.get(20).add("VAR6");
        modulo2.add(new ArrayList<String>());
        modulo2.get(21).add("ADD");
        modulo2.get(21).add("VAR");
        modulo2.get(21).add("SI");
        modulo2.add(new ArrayList<String>());
        modulo2.get(22).add("ADD");
        modulo2.get(22).add("VAR");
        modulo2.get(22).add("SI");
        modulo2.add(new ArrayList<String>());
        modulo2.get(23).add("CODIGO");
        modulo2.get(23).add("ENDS");


        ArrayList<ArrayList<String>> modulo3 = new ArrayList<ArrayList<String>>();
        modulo3.add(new ArrayList<String>());
        modulo3.get(0).add("CODIGO");
        modulo3.get(0).add("SEGMENT");
        modulo3.add(new ArrayList<String>());
        modulo3.get(1).add("SUB");
        modulo3.get(1).add("AX");
        modulo3.get(1).add("SI");
        modulo3.add(new ArrayList<String>());
        modulo3.get(2).add("ADD");
        modulo3.get(2).add("VAR");
        modulo3.get(2).add("SI");
        modulo3.add(new ArrayList<String>());
        modulo3.get(3).add("SUB");
        modulo3.get(3).add("AX");
        modulo3.get(3).add("SI");
        modulo3.add(new ArrayList<String>());
        modulo3.get(4).add("ADD");
        modulo3.get(4).add("VAR");
        modulo3.get(4).add("SI");
        modulo3.add(new ArrayList<String>());
        modulo3.get(5).add("ADD");
        modulo3.get(5).add("VAR");
        modulo3.get(5).add("SI");
        modulo3.add(new ArrayList<String>());
        modulo3.get(6).add("CODIGO");
        modulo3.get(6).add("ENDS");

        ArrayList<ArrayList<ArrayList<String>>> codigo = new ArrayList<>();
        ArrayList<ArrayList<ArrayList<String>>> entradaLigador = new ArrayList<>();

        TabelaDeOperacoes tabelaOp = new TabelaDeOperacoes();
        ArrayList<ArrayList<String>> codigoObjetoParcial = new ArrayList<ArrayList<String>>();
        Registradores registradores = new Registradores();

        TabelaDeSimbolos tsg = new TabelaDeSimbolos();

        codigo.add(macros);
        codigo.add(modulo2);
        codigo.add(modulo3);

        for(ArrayList<ArrayList<String>> modulo : codigo){
            SeparadorDeCodigo s = new SeparadorDeCodigo(modulo);
            s.separaCodigoDados();
            s.separaCodigoExecutavel();
            s.SeparaCodigoMacros();

            ProcessadorDeMacros pdMacros = new ProcessadorDeMacros(s.getCodigoMacros(), s.getCodigoExecutavel());
            codigoFinal = pdMacros.ProcessaMacros();

            Montador montador = new Montador();
            codigoObjetoParcial = montador.montaCodigoObjeto(codigoFinal, registradores, tabelaOp);

            for(ArrayList<String> linha : codigoFinal){
                System.out.println(linha);
            }
            System.out.println();
            for(ArrayList<String> linha : codigoObjetoParcial){
                System.out.println(linha);
            }
            System.out.println();


            entradaLigador.add(codigoFinal);


        }


        Ligador ligador = new Ligador();
        codigoObjetoParcial = ligador.liga(entradaLigador, registradores, tabelaOp, tsg);

        System.out.println();

        for(ArrayList<String> linha : codigoObjetoParcial){
            System.out.println(linha);
        }

    }
}
