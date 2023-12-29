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
                if (fila == 0) {                                                                                        //columnas
                    Tablero.tablero[fila][columna] = new Columna(columna);
                }else if (columna == 0) {                                                                               //filas
                    Tablero.tablero[fila][columna] = new Fila(fila);
                }else if (fila == 1 || fila == 2) {                                                                     //blancas
                    if (fila == 2){                                                                                     //Peones[B]
                        Tablero.tablero[fila][columna] = Tablero.creaPeones(true);
                    }else{                                                                                              //Resto de piezas blancas
                        if(columna == 1 || columna == 8){Tablero.tablero[fila][columna] = Tablero.creaTorres(true);             //Torres
                        }else if(columna == 2 || columna == 7){Tablero.tablero[fila][columna] = Tablero.creaCaballos(true);     //Caballos
                        }else if(columna == 3 || columna == 6){Tablero.tablero[fila][columna] = Tablero.creaAlfiles(true);      //Alfiles
                        }else if(columna == 4){Tablero.tablero[fila][columna] = Tablero.creaReyes(true);                        //Reyes
                        }else if(columna == 5)Tablero.tablero[fila][columna] = Tablero.creaDamas(true);                         //Damas
                    }
                }else if (fila == 7 || fila == 8) {                                                                     //negras
                    if (fila == 7){                                                                                     //Peones[N]
                        Tablero.tablero[fila][columna] = Tablero.creaPeones(false);
                    }else{                                                                                              //Resto de piezas negras
                        if(columna == 1 || columna == 8){Tablero.tablero[fila][columna] = Tablero.creaTorres(false);             //Torres
                        }else if(columna == 2 || columna == 7){Tablero.tablero[fila][columna] = Tablero.creaCaballos(false);     //Caballos
                        }else if(columna == 3 || columna == 6){Tablero.tablero[fila][columna] = Tablero.creaAlfiles(false);      //Alfiles
                        }else if(columna == 4){Tablero.tablero[fila][columna] = Tablero.creaReyes(false);        //Reyes
                        }else if(columna == 5)Tablero.tablero[fila][columna] = Tablero.creaDamas(false);         //Damas
                    }
                }else{
                    Tablero.tablero[fila][columna] = new Vacio();
                }
            }
        }
    }
    public static Dama creaDamas(boolean esBlanco){
        String nombre;
        if (esBlanco) {
            nombre = "Dama[B]";
        }else nombre = "Dama[N]";
        Dama d = new Dama(esBlanco, 5, nombre);
        return d;
    }
    public static Rey creaReyes(boolean esBlanco){
        String nombre;
        if (esBlanco) {
            nombre = "!Rey[B]";
        }else nombre = "!Rey[N]";
        Rey r = new Rey(esBlanco, 5, nombre);
        return r;
    }
    public static Alfil creaAlfiles(boolean esBlanco){
        String nombre;
        if (esBlanco) {
            nombre = "Alfi[B]";
        }else nombre = "Alfi[N]";
        Alfil a = new Alfil(esBlanco, 5, nombre);
        return a;
    }
    public static Caballo creaCaballos(boolean esBlanco){
        String nombre;
        if (esBlanco) {
            nombre = "Caba[B]";
        }else nombre = "Caba[N]";
        Caballo c = new Caballo(esBlanco, 3, nombre);
        return c;
    }
    public static Torre creaTorres(boolean esBlanco){
        String nombre;
        if (esBlanco) {
            nombre = "Torr[B]";
        }else nombre = "Torr[N]";
        Torre t = new Torre(esBlanco, 5, nombre);
        return t;
    }
    public static Peon creaPeones(boolean esBlanco){
        String nombre;
        if (esBlanco) {
            nombre = "Peon[B]";
        }else nombre = "Peon[N]";
        Peon p = new Peon(esBlanco, 1, nombre);
        return p;
    }
}
