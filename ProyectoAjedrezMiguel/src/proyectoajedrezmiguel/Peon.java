package proyectoajedrezmiguel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public class Peon extends Pieza{
    
    public Peon(boolean esBlanco, int valor, String nombre) {
        super(esBlanco, valor, nombre);
    }
    public boolean comprobacionMov(int f1, int c1, int f2, int c2){
        boolean bien = true;
        int n;
        if (Tablero.tablero[f1][c1].isEsBlanco()) {
            n = 1;
        }else n = -1;
        if (c1 == c2) {                                                                                                          //movimiento hacia alante
            if ((Tablero.tablero[f1][c1].isEsBlanco() && f1 == 2) || (!Tablero.tablero[f1][c1].isEsBlanco() && f1 == 7)) {       //movimiento doble
                bien = (f2 == f1 + n) || (f2 == f1 + 2*n);
            }else bien = f2 == f1 + n;
        }else if (c2 == c1+1 || c2 == c1-1) {                                                                                    //movimiento diagonal
            bien = f2 == f1 + n && !Tablero.tablero[f2][c2].getNombre().equals("       ");
        }else bien = false;
        return bien;
    }
}
