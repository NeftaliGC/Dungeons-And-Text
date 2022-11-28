package model;

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
