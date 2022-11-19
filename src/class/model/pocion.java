package model;

public class pocion {

    private String nombre;
    private int poder;
    private int vida;
    private int defensa;

    public void setNombre(String name) {
        this.nombre = name;
    }

    public void setUsos(int poder, int vida, int defensa) {
        this.poder = poder;
        this.vida = vida;
        this.defensa = defensa;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPoder() {
        if (this.poder > 0) {
            return poder;
        } else if (this.vida > 0) {
            return vida;
        } else if (this.defensa > 0) {
            return defensa;
        }
        return 0;
    }

}
