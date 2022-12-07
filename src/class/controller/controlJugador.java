package controller;

import model.pocion;

/**
 * Control Stats from player.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */

public class controlJugador {
    
    /** 
     * @param p
     * @return int
     */
    public static int indetificarTipoPocion(pocion p) {
        int tipo;
        tipo = p.getTipo();
        return tipo;
    }

    
    /** 
     * @param estadisticaActual
     * @param estadisticaAdd
     * @return int
     */
    public static int subirEstadistica(int estadisticaActual, int estadisticaAdd) {
        int estadistica;
        estadistica = estadisticaActual + estadisticaAdd;
        return estadistica;
    }
}
