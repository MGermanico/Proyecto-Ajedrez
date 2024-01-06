package proyectoajedrezmiguel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public abstract class AjedUtils {
    public static String comprobaciones(int f1, int c1, int f2, int c2, boolean blancas){
        boolean bien;
        String str = "";                                                        //este String guardará el mensaje de error o estará vacío en caso de ser exitoso
        bien = AjedUtils.compEnTablero(f1, c1, f2, c2);
        if(bien){ bien = AjedUtils.compTuColor(f1, c1, blancas); 
            if(bien){ bien = AjedUtils.compComiendo(f2, c2, blancas);
                if(bien){ bien = Tablero.tablero[f1][c1].comprobacionMov(f1, c1, f2, c2);
                    if(bien){str = "";
                    }else str = AjedUtils.error("esa pieza no puede hacer ese movimiento.");
                }else str = AjedUtils.error("no puedes comerte esa pieza");
            }else str = AjedUtils.error("esa pieza no es de tu color");
        }else str = AjedUtils.error("fuera del tablero");
        return str;
    }
    public static boolean compSintactica(String str){
        boolean bien = true;
        if(bien)bien = str.length() == 5;
        if(bien)bien = Character.isLetter(str.charAt(0));
        if(bien)bien = Character.isDigit(str.charAt(1));
        if(bien)bien = ' ' == str.charAt(2);
        if(bien)bien = Character.isLetter(str.charAt(3));
        if(bien)bien = Character.isDigit(str.charAt(4));
        return bien;
    }
    public static boolean compEnTablero(int f1, int c1, int f2, int c2){
        boolean bien = true;
        if(bien)bien = (f1 < 9 && 0 < f1) && (c1 < 9 && 0 < c1) && (f2 < 9 && 0 < f2) && (c2 < 9 && 0 < c2);
        return bien;
    }
    public static boolean compTuColor(int f1, int c1, boolean blancas){
        boolean bien = true;
        bien = blancas == Tablero.tablero[f1][c1].isEsBlanco();
        return bien;
    }
    public static boolean compComiendo(int f2, int c2, boolean blancas){        //
        boolean bien = true;
        if (!Tablero.tablero[f2][c2].getNombre().equals("       ")) {
            bien = Tablero.tablero[f2][c2].isEsBlanco() != blancas;
        }
        return bien;
    }
    public static boolean JaqueA(boolean blancas){
        boolean jaque= false;
        int fr = 0, cr = 0;
        for (int fila = 0; fila < Tablero.tablero.length; fila++) {
            for (int columna = 0; columna < Tablero.tablero[fila].length; columna++) {
                if (Tablero.tablero[fila][columna].getNombre().contains("Rey") && Tablero.tablero[fila][columna].isEsBlanco() == blancas) {
                    fr = fila;
                    cr = columna;
                }
            }
        }
        int lado = 0,  arr = 0,  ab = 0,  der = 0,  izq = 0, i = 0;
        if(!jaque){                                                         //comprobacion de lados (torre)
            while(lado < 4){
                arr = 0;
                ab = 0;
                der = 0;
                izq = 0;
                if (lado == 0) {
                    arr = 1;
                    i = AjedUtils.distancia(fr, 1);
                }else if (lado == 1) {
                    ab = 1;
                    i = AjedUtils.distancia(fr, 8);
                }else if (lado == 2) {
                    der = 1;
                    i = AjedUtils.distancia(cr, 8);
                }else if (lado == 3) {
                    izq = 1;
                    i = AjedUtils.distancia(cr, 1);
                }
                for (int j = 1; j <= i; j++) {
                    Pieza pieza = Tablero.tablero[fr+j*ab-j*arr][cr+der*j-izq*j];
//                    System.out.print(pieza.getNombre() + " ");
                    if(!jaque && !pieza.getNombre().equals("       ")){
                        if (!jaque && (pieza.getNombre().contains("Torr") || pieza.getNombre().contains("Dama")) && pieza.isEsBlanco() != blancas) {
                            jaque = true;
                        }else{
                            jaque = false;
                        }
                        j = i+1;
                    }
                }
//                System.out.println(lado + ";" + jaque);
                lado ++;
            }
        }
//        System.out.println("----------------------------------");
        if (!jaque) {                                                       //comprobación de diagonales (Alfil)
            lado = 0;
            while(lado < 4){
                arr = 0;
                ab = 0;
                der = 0;
                izq = 0;
                if (lado == 0) {                            // arr-der
                    arr = 1;
                    der = 1;
                    i = (int)Math.min(AjedUtils.distancia(fr, 1), AjedUtils.distancia(cr, 8));         // ab-izq
                }else if (lado == 1) {
                    ab = 1;
                    izq = 1;
                    i = (int)Math.min(AjedUtils.distancia(fr, 8), AjedUtils.distancia(cr, 1));
                }else if (lado == 2) {                      // ab-der
                    der = 1;
                    ab = 1;
                    i = (int)Math.min(AjedUtils.distancia(cr, 8), AjedUtils.distancia(fr, 8));
                }else if (lado == 3) {                      // arr-izq
                    izq = 1;
                    arr = 1;
                    i = (int)Math.min(AjedUtils.distancia(cr, 1), AjedUtils.distancia(fr, 1));
                }
                for (int j = 1; j <= i; j++) {
                    Pieza pieza = Tablero.tablero[fr+j*ab-j*arr][cr+der*j-izq*j];
//                    System.out.print(pieza.getNombre() + " ");
                    if(!jaque && !pieza.getNombre().equals("       ")){
                        if (!jaque && (pieza.getNombre().contains("Alfi") || pieza.getNombre().contains("Dama")) && pieza.isEsBlanco() != blancas) {
                            jaque = true;
                        }else{
                            jaque = false;
                        }
                        j = i+1;
                    }
                }
//                System.out.println(lado + ";" + jaque);
                lado ++;
            }
        }
        if(!jaque && fr+2 < 9 && 0 < fr+2 && cr+1 < 9 && 0 < cr+1)jaque = Tablero.tablero[fr+2][cr+1].getNombre().contains("Caba") && Tablero.tablero[fr+2][cr+1].isEsBlanco() != blancas;  //comprobaciones del caballo
        if(!jaque && fr+2 < 9 && 0 < fr+2 && cr-1 < 9 && 0 < cr-1)jaque = Tablero.tablero[fr+2][cr-1].getNombre().contains("Caba") && Tablero.tablero[fr+2][cr-1].isEsBlanco() != blancas;
        if(!jaque && fr-2 < 9 && 0 < fr-2 && cr+1 < 9 && 0 < cr+1)jaque = Tablero.tablero[fr-2][cr+1].getNombre().contains("Caba") && Tablero.tablero[fr-2][cr+1].isEsBlanco() != blancas;
        if(!jaque && fr-2 < 9 && 0 < fr-2 && cr-1 < 9 && 0 < cr-1)jaque = Tablero.tablero[fr-2][cr-1].getNombre().contains("Caba") && Tablero.tablero[fr-2][cr-1].isEsBlanco() != blancas;
        if(!jaque && fr+1 < 9 && 0 < fr+1 && cr+2 < 9 && 0 < cr+2)jaque = Tablero.tablero[fr+1][cr+2].getNombre().contains("Caba") && Tablero.tablero[fr+1][cr+2].isEsBlanco() != blancas;
        if(!jaque && fr+1 < 9 && 0 < fr+1 && cr-2 < 9 && 0 < cr-2)jaque = Tablero.tablero[fr+1][cr-2].getNombre().contains("Caba") && Tablero.tablero[fr+1][cr-2].isEsBlanco() != blancas;
        if(!jaque && fr-1 < 9 && 0 < fr-1 && cr+2 < 9 && 0 < cr+2)jaque = Tablero.tablero[fr-1][cr+2].getNombre().contains("Caba") && Tablero.tablero[fr-1][cr+2].isEsBlanco() != blancas;
        if(!jaque && fr-1 < 9 && 0 < fr-1 && cr-2 < 9 && 0 < cr-2)jaque = Tablero.tablero[fr-1][cr-2].getNombre().contains("Caba") && Tablero.tablero[fr-1][cr-2].isEsBlanco() != blancas;
        
        if(!jaque){
            if (blancas) {
                lado = +1;
            }else lado = -1;
            if(!jaque && fr+lado < 9 && 0 < fr+lado && cr+lado < 9 && 0 < cr+lado)jaque = Tablero.tablero[fr+lado][cr+1].getNombre().contains("Peon") && Tablero.tablero[fr+lado][cr+1].isEsBlanco() != blancas;
            if(!jaque && fr+lado < 9 && 0 < fr+lado && cr+lado < 9 && 0 < cr+lado)jaque = Tablero.tablero[fr+lado][cr-1].getNombre().contains("Peon") && Tablero.tablero[fr+lado][cr-1].isEsBlanco() != blancas;
        }
        return jaque;
    }
    public static char numerosALetras(int n){
        char l = ' ';
        if (n == 0) {
            l = '*';
        }else if (n == 1) {
            l = 'A';
        }else if (n == 2) {
            l = 'B';
        }else if (n == 3) {
            l = 'C';
        }else if (n == 4) {
            l = 'D';
        }else if (n == 5) {
            l = 'E';
        }else if (n == 6) {
            l = 'F';
        }else if (n == 7) {
            l = 'G';
        }else if (n == 8) {
            l = 'H';
        }else{
            l = '#';
        }
        return l;
    }
    public static int letrasANumeros(String str){
        int n = 6969;
        if (str.equalsIgnoreCase("*")) {
            n = 0;
        }else if (str.equalsIgnoreCase("A")) {
            n = 1;
        }else if (str.equalsIgnoreCase("B")) {
            n = 2;
        }else if (str.equalsIgnoreCase("C")) {
            n = 3;
        }else if (str.equalsIgnoreCase("D")) {
            n = 4;
        }else if (str.equalsIgnoreCase("E")) {
            n = 5;
        }else if (str.equalsIgnoreCase("F")) {
            n = 6;
        }else if (str.equalsIgnoreCase("G")) {
            n = 7;
        }else if (str.equalsIgnoreCase("H")) {
            n = 8;
        }else{
            n = 666;
        }
        return n;
    }
    public static String error(String str){
        String ret = "\n\t\tERROR: " + str + "\n\n";
        return ret;
    }
    public static int distancia(int a, int b){return (int)Math.abs(a - b);}
}
