package model;

public class salaArma extends sala {

    private arma arma;
    
    public salaArma(Enemigo enemi, String name, arma a) {
        super(enemi, name);
        this.arma = a;
    }

    
    /** 
     * @return arma
     */
    public arma getArma( ) {
        return this.arma;
    }

    
    /** 
     * @return String
     * @throws Exception
     */
    @Override
    public String getDatos() throws Exception{
        if (this.arma != null) {
            return "En la sala hay: " + this.arma.getNombre() + " con un poder de: " + this.arma.getPoder();
        } else {
            throw new Exception("No hay arma en la sala");
        }
    }

    
    /** 
     * @param arma
     * @return arma
     */
    @Override
    public arma rtArma(arma arma) {
        arma a = this.arma;
        this.arma = arma;
        return a;
    }

}
