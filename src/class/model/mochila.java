package model;
import view.backpack;

public class mochila {
    private arma[] arsenal;
    private pocion[] Pociones;

    public mochila(int tamañoArsenal, int tamañoPociones) {
        this.arsenal = new arma[tamañoArsenal];
        this.Pociones = new pocion[tamañoPociones];
    }

    public void addArma(arma a) {
        for (int i = 0; i < arsenal.length; i++) {
            if (arsenal[i] == null) {
                arsenal[i] = a;
            } else {
                backpack.lleno();
            }
        }
    }

    public void addPocion(pocion p) {
        for (int i = 0; i < Pociones.length; i++) {
            if (Pociones[i] == null) {
                Pociones[i] = p;
            } else {
                backpack.lleno();
            }
        }
    }
    
}
 