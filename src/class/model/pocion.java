package model;

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
