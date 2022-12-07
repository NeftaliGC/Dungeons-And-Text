package model;

/**
 * Create mano.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */

public class mano {
    private arma[] Mano;

    public mano() {
        Mano = new arma[1];
    }

    
    /** 
     * @return int
     */
    public int pArma() {
        int p;
        p = this.Mano[0].getPoder();

        return p;
    }

    
    /** 
     * @param a
     */
    public void agregarArma(arma a) {
        Mano[0] = a;
    }

    public void tirarArma() {

    }
    
    /** 
     * @return arma
     */
    public arma sacarArma() {
        arma arma = Mano[0];

        return arma;
    }
}
