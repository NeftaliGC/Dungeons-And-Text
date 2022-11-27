package model;
import controller.random;



public class jugador {
    private String Nombre;
    private int vida = 10;
    private int poder = 5;
    private int defensa = 5;
    private mochila Mochila;
    private mano Mano;

    public jugador() {
        this.Mochila = new mochila(3, 2);
        this.Mano = new mano();
    }

    
    /** 
     * @param name
     */
    public void setNombre(String name) {
        this.Nombre = name;
    }

    
    /** 
     * @return int
     */
    public int getVida() {
        return vida;
    }

    public void setVida() {
        
    }

    
    /** 
     * @return int
     */
    public int getPoder() {
        return poder;
    }

    public void setPoder() {
        
    }

    
    /** 
     * @return int
     */
    public int getDefensa() {
        return defensa;
    }

    public void setDefensa() {
        
    }

    
    /** 
     * @return int
     */
    public int ataca() {
        int ataque = random.generateRandom(1, poder);
        return ataque;
    }

    
    /** 
     * @return int
     */
    public int defender() {
        int proteccion = random.generateRandom(1, defensa);
        return proteccion;
    }

    
    /** 
     * @param arma
     */
    public void recogerArma(arma arma) {
        
    }

    
    /** 
     * @param pocion
     */
    public void recogerPocion(pocion pocion) {

    }

    
    /** 
     * @param tesoro
     */
    public void recogerTesoro(tesoro tesoro) {

    }

    
    /** 
     * @param arma
     */
    public void cambiarArma(arma arma) {

    }

}
