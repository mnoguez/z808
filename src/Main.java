import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String args[]){
//
//        modulo1.add(new ArrayList<String>());
//        modulo1.get(0).add("ADD");
//        modulo1.get(0).add("TESTE");
//        modulo1.get(0).add("DX");
//        modulo1.add(new ArrayList<String>());
//        modulo1.get(1).add("ADD");
//        modulo1.get(1).add("TESTE");
//        modulo1.get(1).add("SI");
//        modulo1.add(new ArrayList<String>());
//        modulo1.get(2).add("ADD");
//        modulo1.get(2).add("AX");
//        modulo1.get(2).add("DX");
//
//        Montador montador = new Montador();
//
//        System.out.println("MODULO 1: ");
//        for(ArrayList<String> linha : modulo1){
//            System.out.println(linha);
//        }
//
////        modulo1 = montador.montaCodigoObjeto(modulo1, registradores);
////
////        System.out.println("MODULO 1: ");
////        for(ArrayList<String> linha : modulo1){
////            System.out.println(linha);
////        }
//
//        ArrayList<ArrayList<String>> modulo2 = new ArrayList<ArrayList<String>>();
//
//        modulo2.add(new ArrayList<String>());
//        modulo2.get(0).add("ADD");
//        modulo2.get(0).add("OI");
//        modulo2.get(0).add("DX");
//        modulo2.add(new ArrayList<String>());
//        modulo2.get(1).add("MUL");
//        modulo2.get(1).add("TESTE");
//        modulo2.get(1).add("DX");
//
//        System.out.println("MODULO 2: ");
//        for(ArrayList<String> linha : modulo2){
//            System.out.println(linha);
//        }
//
////        modulo2 = montador.montaCodigoObjeto(modulo2, registradores);
////
////        System.out.println("MODULO 2: ");
////        for(ArrayList<String> linha : modulo2){
////            System.out.println(linha);
////        }
//
//        Ligador ligador = new Ligador();
//
//        ArrayList<ArrayList<String>> codigoObjeto = new ArrayList<ArrayList<String>>();
//        ArrayList<ArrayList<ArrayList<String>>> modulos = new ArrayList<ArrayList<ArrayList<String>>>();
//
//        modulos.add(modulo1);
//        modulos.add(modulo2);
//
//        codigoObjeto = ligador.liga(modulos, tabelaOp, registradores);
//
//        System.out.println("MODULOS:");
//        for(ArrayList<ArrayList<String>> modulo : modulos)
//            for(ArrayList<String> linha : modulo){
//                System.out.println(linha);
//            }
//        System.out.println("CODIGO OBJETO:");
//        for(ArrayList<String> linha : codigoObjeto){
//            System.out.println(linha);
//        }

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
        macros.get(9).add("ADD");
        macros.get(9).add("TESTE");
        macros.get(9).add("DX");
        macros.add(new ArrayList<String>());
        macros.get(10).add("ADD");
        macros.get(10).add("TESTE");
        macros.get(10).add("SI");
        macros.add(new ArrayList<String>());
        macros.get(11).add("ADD");
        macros.get(11).add("AX");
        macros.get(11).add("DX");
        macros.add(new ArrayList<String>());
        macros.get(12).add("SOMA");
        macros.get(12).add("ABC");
        macros.get(12).add("DEF");
        macros.get(12).add("GHE");
        macros.add(new ArrayList<String>());
        macros.get(13).add("LOUCURA");
        macros.get(13).add("QUATRO");
        macros.get(13).add("CINCO");
        macros.get(13).add("SEIS");
        macros.add(new ArrayList<String>());
        macros.get(14).add("ADD");
        macros.get(14).add("AX");
        macros.get(14).add("DX");
        macros.add(new ArrayList<String>());
        macros.get(15).add("ADD");
        macros.get(15).add("AX");
        macros.get(15).add("DX");
        macros.add(new ArrayList<String>());
        macros.get(16).add("ADD");
        macros.get(16).add("AX");
        macros.get(16).add("DX");
        macros.add(new ArrayList<String>());
        macros.get(17).add("ADD");
        macros.get(17).add("AX");
        macros.get(17).add("DX");

        ArrayList<ArrayList<String>> modulo2 = new ArrayList<ArrayList<String>>();
        modulo2.add(new ArrayList<String>());
        modulo2.get(0).add("SUB");
        modulo2.get(0).add("AX");
        modulo2.get(0).add("SI");
        modulo2.add(new ArrayList<String>());
        modulo2.get(1).add("ADD");
        modulo2.get(1).add("VAR");
        modulo2.get(1).add("SI");
        modulo2.add(new ArrayList<String>());
        modulo2.get(2).add("SUB");
        modulo2.get(2).add("AX");
        modulo2.get(2).add("SI");
        modulo2.add(new ArrayList<String>());
        modulo2.get(3).add("ADD");
        modulo2.get(3).add("VAR");
        modulo2.get(3).add("SI");
        modulo2.add(new ArrayList<String>());
        modulo2.get(4).add("ADD");
        modulo2.get(4).add("VAR");
        modulo2.get(4).add("SI");

        ArrayList<ArrayList<String>> modulo3 = new ArrayList<ArrayList<String>>();
        modulo3.add(new ArrayList<String>());
        modulo3.get(0).add("SUB");
        modulo3.get(0).add("AX");
        modulo3.get(0).add("SI");
        modulo3.add(new ArrayList<String>());
        modulo3.get(1).add("ADD");
        modulo3.get(1).add("VAR");
        modulo3.get(1).add("SI");
        modulo3.add(new ArrayList<String>());
        modulo3.get(2).add("SUB");
        modulo3.get(2).add("AX");
        modulo3.get(2).add("SI");
        modulo3.add(new ArrayList<String>());
        modulo3.get(3).add("ADD");
        modulo3.get(3).add("VAR");
        modulo3.get(3).add("SI");
        modulo3.add(new ArrayList<String>());
        modulo3.get(4).add("ADD");
        modulo3.get(4).add("VAR");
        modulo3.get(4).add("SI");

        SeparadorDeCodigo s = new SeparadorDeCodigo(macros);
        s.SaparaCodigoMacros();
        ProcessadorDeMacros pdMacros = new ProcessadorDeMacros(s.getCodigoMacros(), s.getCodigoExecutavel());
        codigoFinal = pdMacros.ProcessaMacros();

        TabelaDeOperacoes tabelaOp = new TabelaDeOperacoes();

        TabelaDeSimbolos tsg;

        ArrayList<ArrayList<String>> codigoObjetoParcial = new ArrayList<ArrayList<String>>();
        Registradores registradores = new Registradores();

        Montador montador = new Montador();
        codigoObjetoParcial = montador.montaCodigoObjeto(codigoFinal, registradores, tabelaOp);

        //System.out.println(s.getCodigoMacros());

        for(ArrayList<String> linha : codigoFinal){
            System.out.println(linha);
        }

        System.out.println();

        for(ArrayList<String> linha : codigoObjetoParcial){
            System.out.println(linha);
        }

        ArrayList<ArrayList<ArrayList<String>>> codigo = new ArrayList<>();
        codigo.add(codigoFinal);
        codigo.add(modulo2);
        codigo.add(modulo3);

        tsg = montador.getTabelaSimbolos();

        Ligador ligador = new Ligador();
        codigoObjetoParcial = ligador.liga(codigo, registradores, tabelaOp, tsg);

        System.out.println();

        for(ArrayList<String> linha : codigoObjetoParcial){
            System.out.println(linha);
        }
    }
}
