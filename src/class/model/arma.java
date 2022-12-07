package model;

/**
 * Create arma.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */

public class arma {
    
    private String nombre;
    private int poder;
    
    public arma(String n, int p) {
        this.nombre = n;
        this.poder = p;
    }
    
    /** 
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    
    /** 
     * @return int
     */
    public int getPoder() {
        return this.poder;
    }

}
