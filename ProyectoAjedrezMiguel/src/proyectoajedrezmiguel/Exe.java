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
            for (int columna = 0; columna < Tablero.tablero[fila].length; columna++) {
                System.out.print(Tablero.tablero[fila][columna].toString());
            }
            System.out.println("");
        }
    }
    public static void menu(Scanner sc){
        boolean seguir = true;
        boolean turnoBlancas = true;
        while(seguir){
            muestraTablero();
            jugada(turnoBlancas, sc);
            turnoBlancas = !turnoBlancas;
        }
    }
    public static boolean jugada(boolean blancas, Scanner sc){
        boolean bien = true;
        
        return bien;
    }
}
