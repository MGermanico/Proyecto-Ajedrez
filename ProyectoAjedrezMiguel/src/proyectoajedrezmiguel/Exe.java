package proyectoajedrezmiguel;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public class Exe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean repetir = true;
        while(repetir){
            Tablero.colocaTablero();
            menu(sc);
        }
    }
    public static void muestraTablero(){
        for (int fila = 0; fila < Tablero.tablero.length; fila++) {
            System.out.println("-----------------------------------------------------------------------------------------"
                    +        "\n        |         |         |         |         |         |         |         |         |");
            for (int columna = 0; columna < Tablero.tablero[fila].length; columna++) {
                System.out.print(Tablero.tablero[fila][columna].toString() + " | ");
            }
            System.out.println("\n        |         |         |         |         |         |         |         |         |");
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }
    public static void menu(Scanner sc){
        boolean seguir = true;
        boolean turnoBlancas = true;
        boolean bien = true;
        while(seguir){
            do{
                muestraTablero();
                bien = jugada(turnoBlancas, sc);
                if (AjedUtils.Jaque(turnoBlancas)) {
                    System.out.println("Jaque");
                }else System.out.println("NO");
            }while(!bien);
            turnoBlancas = !turnoBlancas;
        }
    }
    public static boolean jugada(boolean blancas, Scanner sc){
        boolean bien;
        if (blancas) {System.out.print("Mueven blancas(d2 d4):\t");
        }else System.out.print("Mueven negras(d7 d5):\t");
        String res = sc.nextLine();
        bien = AjedUtils.compSintactica(res);
        if (bien) {
            int f1 = Character.getNumericValue(res.charAt(1));
            int c1 = AjedUtils.letrasANumeros(Character.toString(res.charAt(0)));
            int f2 = Character.getNumericValue(res.charAt(4));
            int c2 = AjedUtils.letrasANumeros(Character.toString(res.charAt(3)));
            String str = AjedUtils.comprobaciones (f1, c1, f2, c2, blancas);
            if (str.equals("")) {
                bien = true;
            }else{
                bien = false;
                System.out.print(str);
            }
            if(bien)Tablero.tablero[f1][c1].movimiento(f1, c1, f2, c2);
        }else System.out.print(AjedUtils.error("mala sintaxis, los movimientos son del tipo (ax by)"));
        return bien;
    }
}
