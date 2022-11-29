package model;

public class sala {
    protected Enemigo enemigo;
    protected String nombre;

    public sala(Enemigo enemi, String name) {
        this.enemigo = enemi;
        this.nombre = name;
    }

    
    /** 
     * @return Enemigo
     * @throws Exception
     */
    public Enemigo getEnemigo() throws Exception{
        if(this.enemigo == null) {
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
    public arma rtArma(arma arma) {
        arma a = arma;
        return a;
    }

    
    /** 
     * @param pocion
     * @return pocion
     */
    public pocion rtPocion(pocion pocion) {
        pocion p = pocion;
        return p;
    }
    
}
