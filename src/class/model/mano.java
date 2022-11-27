package model;

public class mano {
    private arma[] Mano;

    public mano() {
        Mano = new arma[1];
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
