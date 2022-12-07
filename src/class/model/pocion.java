package model;

/**
 * Create item pocion.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */

public class pocion {

    private String nombre;
    private int nivel;
    private int tipo;

    public pocion(int n, int t, String name) {
        this.nivel = n;
        this.tipo = t;
        this.nombre = name;
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
    public int getNivel() {
        return this.nivel;
    }

    
    /** 
     * @return int
     */
    public int getTipo() {
        return this.tipo;
    }

}
