package model;

/**
 * salaPocion
 */
public class salaPocion extends sala{

    private pocion pocion;

    public salaPocion(Enemigo enemi, String name, pocion p) {
        super(enemi, name);
        this.pocion = p;
    }

    
    /** 
     * @return pocion
     */
    public pocion getPocion() {
        return this.pocion;
    }

    
    /** 
     * @param p
     */
    public void setPocion(pocion p) {
        this.pocion = p;
    }

    
    /** 
     * @return String
     * @throws Exception
     */
    @Override
    public String getDatos() throws Exception {
        if (this.pocion == null) {
            throw new Exception("No hay pocion en la sala");
        } else {
            return "En la sala hay: " + this.pocion.getNombre() + " de nivel: " + this.pocion.getNivel();
        }
    }

    
    /** 
     * @param pocion
     * @return pocion
     */
    @Override
    public pocion rtPocion(pocion pocion) {
        pocion p = this.pocion;
        this.pocion = pocion;
        return p;
    }
    
    
}