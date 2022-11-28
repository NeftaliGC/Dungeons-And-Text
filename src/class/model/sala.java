package model;

public class sala {
    protected Enemigo enemigo;
    protected String nombre;

    public sala(Enemigo enemi, String name) {
        this.enemigo = enemi;
        this.nombre = name;
    }

    public Enemigo getEnemigo() {
        return this.enemigo;
    }

    public String getNombre() {
        return this.nombre;
    }
    
}
