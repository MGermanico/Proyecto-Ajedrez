package proyectoajedrezmiguel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public class Rey extends Pieza{
    
    public Rey(boolean esBlanco, int valor, String nombre) {    
        super(esBlanco, valor, nombre);
    }
    public boolean comprobacionMov(int f1, int c1, int f2, int c2){
        boolean bien = true;
        bien = AjedUtils.distancia(f1, f2) < 2 && AjedUtils.distancia(c1, c2) < 2;
        return bien;
    }
    
}
