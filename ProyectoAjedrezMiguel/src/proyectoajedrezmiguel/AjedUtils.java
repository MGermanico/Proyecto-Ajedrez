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
    public static boolean comprobaciones(int f1, int c1, int f2, int c2){
        boolean bien = true;
        
        return bien;
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
//    public boolean compEnTablero(int f1, int c1, int f2, int c2){
//        boolean bien = true;
//        
//        return bien;
//    }
//    public boolean compTuColor(int f1, int c1, int f2, int c2){
//        boolean bien = true;
//        
//        return bien;
//    }
//    public boolean compParticular(int f1, int c1, int f2, int c2){
//        boolean bien = true;
//        
//        return bien;
//    }
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
}
