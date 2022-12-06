package model;

/**
 * salaTesoro
 */
public class salaTesoro extends sala{

    private tesoro tesoro;

    public salaTesoro(Enemigo enemi, String name, tesoro t, boolean tesoro) {
        super(enemi, name, tesoro);
        this.tesoro = t;
    }

    
    /** 
     * @return String
     */
    @Override
    public String getDatos() {
        return "En la sala hay: " + this.tesoro.getNombre();
    }

}