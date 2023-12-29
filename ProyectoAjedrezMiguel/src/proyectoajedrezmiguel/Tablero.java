package proyectoajedrezmiguel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public abstract class Tablero {
    public static Pieza[][] tablero = new Pieza[9][9];
    
    public static void colocaTablero(){
        for (int fila = 0; fila < Tablero.tablero.length; fila++) {
            for (int columna = 0; columna < Tablero.tablero[fila].length; columna++) {
                if (fila == 0) {
                    Tablero.tablero[fila][columna] = Columna();
                }
            }
        }
    }
}
