package model;

/**
 * Create salaArma.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */

public class salaArma extends sala {

    private arma arma;
    private pocion poc = null;
    
    public salaArma(Enemigo enemi, String name, arma a, boolean tesoro) {
        super(enemi, name, tesoro);
        this.arma = a;
    }

    
    /** 
     * @param p
     */
    @Override
    public void setPocion(pocion p) {
        this.poc = p;
    }

    
    /** 
     * @param pocion
     * @return pocion
     */
    @Override
    public pocion getPocion(pocion pocion) {
        return this.poc;
    }
    
    /** 
     * @return arma
     */
    @Override
    public arma getArma(arma a) {
        return this.arma;
    }

    
    /** 
     * @param a
     */
    @Override
    public void setArma(arma a) {
        this.arma = a;
    }

    
    /** 
     * @return String
     * @throws Exception
     */
    @Override
    public String getDatos() throws Exception{
        String s = "";
        if (this.poc == null && arma == null) {
            throw new Exception("La sala esta vacia");
        } else {
            if (poc != null) {
                s = " En la sala tambien hay: " + this.poc.getNombre() + " de nivel: " + this.poc.getNivel();
            }
            return "En la sala hay: " + this.arma.getNombre() + " con un poder de: " + this.arma.getPoder() + s;
        }
    }


}
