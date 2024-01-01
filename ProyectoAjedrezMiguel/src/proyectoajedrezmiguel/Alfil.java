package proyectoajedrezmiguel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public class Alfil extends Pieza{
    
    public Alfil(boolean esBlanco, int valor, String nombre) {
        super(esBlanco, valor, nombre);
    }
    public boolean comprobacionMov(int f1, int c1, int f2, int c2){
        boolean bien = true;
        int movimientoDer = 0, movimientoIzq = 0, movimientoArr = 0, movimientoAba = 0;
        bien = AjedUtils.distancia(f1, f2) == AjedUtils.distancia(c1, c2);
        if (bien) {
            if (f2 < f1) {                                                                   //subiendo
                movimientoArr = -1;
            }else{                                                                           //bajando
                movimientoAba = 1;
            }
            if (c2 < c1) {                                                                   //Izquierda
                movimientoIzq = -1;
            }else{                                                                           //Derecha
                movimientoDer = 1;
            }
            for (int i = 1; i < AjedUtils.distancia(f1, f2); i++) {
                if(bien)bien = Tablero.tablero[f1+movimientoArr+movimientoAba][c1+movimientoIzq+movimientoDer].getNombre().equals("       ");
            }
        }
        return bien;
    }
}
