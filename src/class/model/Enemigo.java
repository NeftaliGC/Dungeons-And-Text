package model;

import controller.random;

/**
 * Write a description of class Enemigos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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