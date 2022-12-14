package model;

/**
 * Create salaPocion.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */

/**
 * salaPocion
 */
public class salaPocion extends sala{

    private pocion pocion;
    private arma arm = null;

    public salaPocion(Enemigo enemi, String name, pocion p, boolean tesoro) {
        super(enemi, name, tesoro);
        this.pocion = p;
    }

    
    
    /** 
     * @param a
     */
    @Override
    public void setArma(arma a) {
        this.arm = a;
    }
    
    
    /** 
     * @param arma
     * @return arma
     */
    @Override
    public arma getArma(arma arma) {
        return this.arm;
    }

    /** 
     * @param p
     */
    @Override
    public void setPocion(pocion p) {
        this.pocion = p;
    }
    
    
    /** 
     * @return String
     * @throws Exception
     */
    @Override
    public String getDatos() throws Exception {
        String s = "";
        if (this.pocion == null && arm == null) {
            throw new Exception("La sala esta vacia");
        } else {
            if (arm != null) {
                s = " En la sala tambien hay: " + this.arm.getNombre() + " con un poder de: " + this.arm.getPoder();
            }
            return "En la sala hay: " + this.pocion.getNombre() + " de nivel: " + this.pocion.getNivel() + s;
        }
    }
    
    
    /** 
     * @return pocion
     */
    @Override
    public pocion getPocion(pocion p) {
        return this.pocion;
    }
    
}