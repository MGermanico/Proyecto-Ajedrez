/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoajedrezmiguel;

/**
 *
 * @author migue
 */
public class Columna extends Pieza{
    
    public Columna(int num) {
        super(true, 0, "   " + Character.toString(AjedUtils.numerosALetras(num)) + "   ");
    }
    
}
