package controller;

/**
 * Controll from combate.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */

public class combate {
    
    static int ataqueJugador;
    static int ataqueEnemigo;
    static boolean jugadorGana = false;
    static boolean empate = false;

    
    /** 
     * @param atBase
     * @param pArma
     * @return int
     */
    public static int ataqueJugador(int atBase, int pArma) {
        ataqueJugador = atBase + pArma;
        return ataqueJugador;
    }

    
    /** 
     * @param atBase
     * @return int
     */
    public static int  ataqueEnemigo(int atBase) {
        ataqueEnemigo = atBase;
        return ataqueEnemigo;
    }

    
    /** 
     * @param defensaJugador
     * @param defensaEnemigo
     * @return boolean[]
     */
    public static boolean[] jGanador(int defensaJugador, int defensaEnemigo) {
        jugadorGana = false;
        empate = false;
        if (ataqueEnemigo > defensaJugador) {
            jugadorGana = false;
        } else if (ataqueJugador > defensaEnemigo) {
            jugadorGana = true;
        } else {
            empate = true;
        }
        boolean[] resultado = {jugadorGana, empate};

        return resultado;

    }

}
