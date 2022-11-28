package model;

public class salaArma extends sala {

    private arma arma;
    
    public salaArma(Enemigo enemi, String name, arma a) {
        super(enemi, name);
        //TODO Auto-generated constructor stub
        this.arma = a;
    }

    public arma getArma( ) {
        return this.arma;
    }


}
