package model;

/**
 * Create father object Sala.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */

public class sala {
    protected Enemigo enemigo;
    protected String nombre;
    protected boolean salaT;

    public sala(Enemigo enemi, String name, boolean tesoro) {
        this.enemigo = enemi;
        this.nombre = name;
        this.salaT = tesoro;
    }
    
    
    /** 
     * @return boolean
     */
    public boolean getTesoro() {
        return salaT;
    }

    /**
     * @return Enemigo
     * @throws Exception
     */
    public Enemigo getEnemigo() throws Exception {
        if (this.enemigo == null) {
            throw new Exception("No hay enemigo");
        } else {
            return this.enemigo;
        }
    }

    /**
     * @param e
     */
    public void setEnemigo(Enemigo e) {
        this.enemigo = e;
    }

    /**
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return String
     * @throws Exception
     */
    public String getDatos() throws Exception {
        return "En la sala hay: ";
    }

    /**
     * @param arma
     * @return arma
     */
    public arma getArma(arma arma) {
        arma a = arma;
        return a;
    }

    /**
     * @param p
     */
    public void setArma(arma a) {
        //this.pocion = p;
    }

    /**
     * @param pocion
     * @return pocion
     */
    public pocion getPocion(pocion pocion) {
        pocion p = pocion;
        return p;
    }

    /**
     * @param p
     */
    public void setPocion(pocion p) {
        //this.pocion = p;
    }

}
