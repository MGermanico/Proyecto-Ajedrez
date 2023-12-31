package proyectoajedrezmiguel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public class Caballo extends Pieza{
    
    public Caballo(boolean esBlanco, int valor, String nombre) {
        super(esBlanco, valor, nombre);
    }
    public boolean comprobacionMov(int f1, int c1, int f2, int c2){
        boolean bien = true;
        if (f2 == f1 + 1 || f2 == f1 - 1) {                     //lineas horizontales
            bien = (c2 == c1 + 2) || (c2 == c1 - 2);
        }else if (c2 == c1 + 1 || c2 == c1 - 1) {               //linea vertical
            bien = (f2 == f1 + 2) || (f2 == f1 - 2);
        }else bien = false;
        return bien;
    }
}
