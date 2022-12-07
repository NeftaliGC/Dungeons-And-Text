package model;

import controller.random;

/**
 * Create Enemigo.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */

 
public class Enemigo
{
    private String nombre;
    private int poder;
    private int defensa;

    public Enemigo(String n, int p, int d) {
        this.nombre = n;
        this.poder = p;
        this.defensa = d;
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

    
    /** 
     * @return int
     */
    public int getDefensa() {
        return this.defensa;
    }

    
    /** 
     * @return int
     */
    public int ataque() {
        int ataque = random.generateRandom(1, poder);
        return ataque;
    }

    
    /** 
     * @return int
     */
    public int defender() {
        int defender = random.generateRandom(1, defensa);
        return defender;
    }
}