package proyectoajedrezmiguel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public class Torre extends Pieza{
    
    public Torre(boolean esBlanco, int valor, String nombre) {
        super(esBlanco, valor, nombre);
    }
    public boolean comprobacionMov(int f1, int c1, int f2, int c2){
        boolean bien = true;
        int direccion = 0;
        int movimientoVer = 0;
        int movimientoHor = 0;
        int dis = 0;
        if (c2 == c1) {                                 //movimiento vertical
            dis = AjedUtils.distancia(f1, f2);
            movimientoVer = 1;
            movimientoHor = 0;
        }else if (f2 == f1) {
            dis = AjedUtils.distancia(c1, c2);
            movimientoHor = 1;
            movimientoVer = 0;
        }else bien = false;
        if (c2 < c1 || f2 < f1) { //izquierda
            direccion = -1;
        }else direccion = 1; //derecha
        for (int i = 1; i < dis; i++) {
            if(bien) bien = Tablero.tablero[f1+(i*movimientoVer*direccion)][c1+(i*movimientoHor*direccion)].getNombre().equals("       ");
        }
        return bien;
    }
}
