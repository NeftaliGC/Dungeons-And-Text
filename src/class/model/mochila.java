package model;

import view.backpack;

public class mochila {
    private arma[] mochilaArmas = new arma[3];
    private pocion[] mochilaPociones = new pocion[2];
    private arma mano;

    public void agregarArma(arma arma) {
        for (int i = 0; i < mochilaArmas.length; i++) {
            if (mochilaArmas[i] == null) {
                mochilaArmas[i] = arma;
            } else {
                backpack.lleno();
            }
        }
    }

    public void agregarPocion(pocion pocion) {
        for (int i = 0; i < mochilaPociones.length; i++) {
            if (mochilaPociones[i] == null) {
                mochilaPociones[i] = pocion;
            } else {
                backpack.lleno();
            }
        }
    }
    
}
