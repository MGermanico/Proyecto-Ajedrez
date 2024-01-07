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
    
    private boolean seMovio = false;
    
    public Rey(boolean esBlanco, int valor, String nombre) {    
        super(esBlanco, valor, nombre);
    }
    @Override
    public boolean soyRey(){
        return true;
    }
    public boolean comprobacionMov(int f1, int c1, int f2, int c2){
        boolean bien = true;
        if (bien && !this.isSeMovio()) {                                                //se puede enrroque
            if(AjedUtils.distancia(f1, f2) < 2 && AjedUtils.distancia(c1, c2) < 2){         //movimiento normal
                bien = true;
            }else if(f1 == f2 && (c2 == 2 || c2 == 6)){                                     //movimiento de enrroque
                boolean blancas = f1 == 1;
                if (c2 == 2) {                                                                  //enrroque corto
                    Torre temp = (Torre)Tablero.tablero[f1][1];
                    bien = !temp.isSeMovio() && Tablero.tablero[f1][2].getNombre().equals("       ") && Tablero.tablero[f1][3].getNombre().equals("       ");
                    if(bien)bien = !AjedUtils.JaqueA(blancas);
                    if(bien){                                                                   //comprobación jaque
                        Pieza temp2 = Tablero.tablero[f1][3];
                        Tablero.tablero[f1][3] = Tablero.tablero[f1][4];
                        Tablero.tablero[f1][4] = temp;
                        bien = !AjedUtils.JaqueA(blancas);
                    }
                    if(bien){                                                                   //comprobación jaque
                        Pieza temp2 = Tablero.tablero[f1][2];
                        Tablero.tablero[f1][2] = Tablero.tablero[f1][4];
                        Tablero.tablero[f1][4] = temp;
                        bien = !AjedUtils.JaqueA(blancas);
                    }
                }else if (c2 == 6) {                                                            //enroque largo
                    Torre temp = (Torre)Tablero.tablero[f1][8];
                    bien = !temp.isSeMovio() && Tablero.tablero[f1][5].getNombre().equals("       ") && Tablero.tablero[f1][6].getNombre().equals("       ") && Tablero.tablero[f1][7].getNombre().equals("       ");
                    if(bien)bien = !AjedUtils.JaqueA(blancas);
                    if(bien){                                                                   //comprobación jaque
                        Pieza temp2 = Tablero.tablero[f1][5];
                        Tablero.tablero[f1][5] = Tablero.tablero[f1][4];
                        Tablero.tablero[f1][4] = temp;
                        bien = !AjedUtils.JaqueA(blancas);
                    }
                    if(bien){                                                                   //comprobación jaque
                        Pieza temp2 = Tablero.tablero[f1][6];
                        Tablero.tablero[f1][6] = Tablero.tablero[f1][4];
                        Tablero.tablero[f1][4] = temp;
                        bien = !AjedUtils.JaqueA(blancas);
                    }
                    if(bien){                                                                   //comprobación jaque
                        Pieza temp2 = Tablero.tablero[f1][7];
                        Tablero.tablero[f1][7] = Tablero.tablero[f1][4];
                        Tablero.tablero[f1][4] = temp;
                        bien = !AjedUtils.JaqueA(blancas);
                    }
                }
            }else bien = false;
        }else{                                                                          //no se puede enrroque
            bien = AjedUtils.distancia(f1, f2) < 2 && AjedUtils.distancia(c1, c2) < 2;
        }
        if(bien)this.setSeMovio(true);
        return bien;
    }

    public boolean isSeMovio() {
        return seMovio;
    }

    public void setSeMovio(boolean seMovio) {
        this.seMovio = seMovio;
    }
    
}
