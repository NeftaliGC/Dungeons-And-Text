package model;
import controller.random;



public class jugador {
    private int vida = 10;
    private int poder = 5;
    private int defensa = 5;

    public int getVida() {
        return vida;
    }

    public int getPoder() {
        return poder;
    }

    public int getDefensa() {
        return defensa;
    }

    public int ataque() {
        int ataque = random.generateRandom(1, poder);
        //ataque = ataque + mochila.mano.poder;
        return ataque;
    }

    public int proteccion() {
        int proteccion = random.generateRandom(1, defensa);
        return proteccion;
    }
}
