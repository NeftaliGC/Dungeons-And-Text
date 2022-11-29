package model;

import controller.config;

public class juego {
    private boolean configurado = false;
    private jugador player;
    private mapa map;

    private config  conf = new config();

    public juego() {
        player = new jugador();
    }

    
    /** 
     * @param config
     */
    public void setCofig(boolean config) {
        this.configurado = config;
    }

    
    /** 
     * @param name
     */
    public void setJugadorAtributos(String name) {
        this.player.setNombre(name);
    }
    
    
    /** 
     * @param s
     * @throws Exception
     */
    public void setMapaAtributos(int s) throws Exception {
        this.map = new mapa(s);
        
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                sala sala = conf.createSala();
                map.setSala(sala, i, j);
            }
        }
    }
    
    /** 
     * @return boolean
     */
    public boolean getCofig() {
        return this.configurado;
    }

    
    /** 
     * @return jugador
     */
    public jugador getJugador() {
        return this.player;
    }

    
    /** 
     * @return mapa
     */
    public mapa getMapa() {
        return this.map;
    }
}
