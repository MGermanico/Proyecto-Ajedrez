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
        int movimientoDer = 0;
        int movimientoIzq = 0;
        int movimientoArr = 0;
        int movimientoAba = 0;
        bien = AjedUtils.distancia(f1, f2) == AjedUtils.distancia(c1, c2);
        if (bien) {
            if (f2 < f1) {                                                                   //subiendo
                
            }else{                                                                           //bajando

            }
            if (c2 < c1) {                                                                   //Izquierda
                
            }else{                                                                           //Derecha

            }
        }
        return bien;
    }
}
