package proyectoajedrezmiguel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public class Dama extends Pieza{
    
    public Dama(boolean esBlanco, int valor, String nombre) {
        super(esBlanco, valor, nombre);
    }
    public boolean comprobacionMov(int f1, int c1, int f2, int c2){
        boolean bien;
        int dis = 0;
        int movimientoDer = 0, movimientoIzq = 0, movimientoArr = 0, movimientoAba = 0;
        bien = (AjedUtils.distancia(f1, f2) == AjedUtils.distancia(c1, c2)) || c1 == c2 || f1 == f2;
        if (bien) {
            if (f2 < f1) {                                                                               //subiendo
                movimientoArr = -1;
                dis = AjedUtils.distancia(f1, f2);
            }else if(f1 < f2){                                                                           //bajando
                movimientoAba = 1;
                dis = AjedUtils.distancia(f1, f2);
            }
            if (c2 < c1) {                                                                               //Izquierda
                movimientoIzq = -1;
                dis = AjedUtils.distancia(c1, c2);
            }else if(c1 < c2){                                                                           //Derecha
                movimientoDer = 1;
                dis = AjedUtils.distancia(c1, c2);
            }
            for (int i = 1; i < dis; i++) {
                if(bien)bien = Tablero.tablero[f1+movimientoArr+movimientoAba][c1+movimientoIzq+movimientoDer].getNombre().equals("       ");
            }
        }
        return bien;
    }
}
