package model;

/**
 * salaPocion
 */
public class salaPocion extends sala{

    private pocion pocion;

    public salaPocion(Enemigo enemi, String name, pocion p) {
        super(enemi, name);
        //TODO Auto-generated constructor stub
        this.pocion = p;
    }

    public pocion getPocion() {
        return this.pocion;
    }
    
    
}