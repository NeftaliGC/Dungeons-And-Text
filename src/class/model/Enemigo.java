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

    
    /** 
     * @param name
     */
    public void setNombre(String name) {
        this.nombre = name;
    }

    
    /** 
     * @param power
     */
    public void setPoder(int power) {
        this.poder = power;
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