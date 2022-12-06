package controller;

import model.pocion;

public class controlJugador {
    public static int indetificarTipoPocion(pocion p) {
        int tipo;
        tipo = p.getTipo();
        return tipo;
    }

    public static int subirEstadistica(int estadisticaActual, int estadisticaAdd) {
        int estadistica;
        estadistica = estadisticaActual + estadisticaAdd;
        return estadistica;
    }
}
