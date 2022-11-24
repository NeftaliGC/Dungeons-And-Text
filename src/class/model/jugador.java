package model;
import controller.random;



public class jugador {
    private String Nombre;
    private int vida = 10;
    private int poder = 5;
    private int defensa = 5;
    private mochila Mochila = new mochila();
    private mano Mano = new mano();

    public void setNombre(String name) {
        this.Nombre = name;
    }

    public int getVida() {
        return vida;
    }

    public void setVida() {
        
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder() {
        
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa() {
        
    }

    public int ataca() {
        int ataque = random.generateRandom(1, poder);
        return ataque;
    }

    public int defender() {
        int proteccion = random.generateRandom(1, defensa);
        return proteccion;
    }

    public void recogerArma(arma arma) {

    }

    public void recogerPocion(pocion pocion) {

    }

    public void recogerTesoro(tesoro tesoro) {

    }

    public void cambiarArma(arma arma) {

    }

}
