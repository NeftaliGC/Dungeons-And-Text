package model;

public class mano {
    private arma mano[] = new arma[1];

    public void agregarArma(arma arma) {
        mano[0] = arma;
    }

    public void tirarArma() {

    }

    public arma getArma() {
        arma arma = mano[0];

        return arma;
    }
}
