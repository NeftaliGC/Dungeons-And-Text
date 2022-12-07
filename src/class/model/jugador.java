package model;
import controller.random;

/**
 * Create jugador.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */

public class jugador {
    private String Nombre;
    private int vida = 10;
    private int poder = 5;
    private int defensa = 5;
    private mochila Mochila;
    private arma puño = new arma("Puño", 0);
    private mano Mano;

    public jugador() {
        this.Mochila = new mochila(3, 2);
        this.Mano = new mano();
        this.Mano.agregarArma(puño);
    }

    
    /** 
     * @return String
     */
    public String getNombre() {
        return this.Nombre;
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
    public int poderArmaEquipada() {
        int p;
        p = this.Mano.pArma();
        return p;
    }

    
    /** 
     * @return int
     */
    public int getVida() {
        return vida;
    }

    
    /** 
     * @param v
     */
    public void setVida(int v) {
        this.vida = v;
    }

    
    /** 
     * @param a
     */
    public void setArma(arma a) {
        this.Mano.agregarArma(a);
    }

    
    /** 
     * @return int
     */
    public int getPoder() {
        return poder;
    }

    
    /** 
     * @param p
     */
    public void setPoder(int p) {
        this.poder = p;
    }

    
    /** 
     * @return int
     */
    public int getDefensa() {
        return this.defensa;
    }

    
    /** 
     * @param d
     */
    public void setDefensa(int d) {
        this.defensa = d;
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
     * @throws Exception
     */
    public void recogerArma(arma arma) throws Exception {
        this.Mochila.addArma(arma);
    }

    
    /** 
     * @param pocion
     * @throws Exception
     */
    public void recogerPocion(pocion pocion) throws Exception {
        this.Mochila.addPocion(pocion);
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

    
    /** 
     * @return arma
     */
    public arma getPuño() {
        return this.puño;
    }

    
    /** 
     * @return mochila
     */
    public mochila getMochila() {
        return this.Mochila;
    }

}
