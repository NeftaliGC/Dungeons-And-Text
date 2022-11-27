package model;

import controller.random;

public class arma {
    
    private String nombre;
    private int poder;

    

    
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

}
