package proyectoajedrezmiguel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public class Pieza {
    private boolean esBlanco;
    private int valor;
    private String nombre;
    public void movimiento(int f1,int c1,int f2,int c2){
        Tablero.tablero[f2][c2] = Tablero.tablero[f1][c1];
        Tablero.tablero[f1][c1] = new Vacio();
    }
//    public boolean comprobacionMov(int f1, int c1, int f2, int c2){
//        boolean bien = true;
//        
//        return bien;
//    }
//    @Override
    public String toString() {
        return this.getNombre();
    }

    public Pieza(boolean esBlanco, int valor, String nombre) {
        this.esBlanco = esBlanco;
        this.valor = valor;
        this.nombre = nombre;
    }
    
    public boolean isEsBlanco() {
        return esBlanco;
    }

    public void setEsBlanco(boolean esBlanco) {
        this.esBlanco = esBlanco;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
