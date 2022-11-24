package model;
import view.backpack;

public class mochila {
    private arma[] arsenal = new arma[3];
    private pocion[] Pociones = new pocion[2];

    public void agregarArma(arma arma) {
        for (int i = 0; i < arsenal.length; i++) {
            if (arsenal[i] == null) {
                arsenal[i] = arma;
            } else {
                backpack.lleno();
            }
        }
    }

    public void agregarPocion(pocion pocion) {
        for (int i = 0; i < Pociones.length; i++) {
            if (Pociones[i] == null) {
                Pociones[i] = pocion;
            } else {
                backpack.lleno();
            }
        }
    }
    
}
