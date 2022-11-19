package model;

import controller.random;

public class arma {
    
    private String nombre;
    private int poder;

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

}
