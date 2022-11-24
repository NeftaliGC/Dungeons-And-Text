package controller;

import model.jugador;
import model.mapa;
import view.configuracion;

public class config {

    public void cfg(){

        jugador player = new jugador();
        player.setNombre(configuracion.player());

        

    }

}
