package model;

/**
 * Create item tesoro to win the game.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */

public class tesoro {
    private String nombre;

    public tesoro(String nombre) {
        this.nombre = nombre;
    }
    
    /** 
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }
}
