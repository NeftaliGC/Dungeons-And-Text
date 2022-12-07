package model;

/**
 * Create salaTesoro.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */


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