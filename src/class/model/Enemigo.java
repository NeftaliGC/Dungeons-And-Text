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

    public void setNombre(String name) {
        this.nombre = name;
    }

    public void setPoder(int power) {
        this.poder = power;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPoder() {
        return this.poder;
    }

    public int ataque() {
        int ataque = random.generateRandom(1, poder);
        return ataque;
    }

    public int defender() {
        int defender = random.generateRandom(1, defensa);
        return defender;
    }
}