package model;

public class juego {
    private boolean configurado = false;
    private jugador player;
    private mapa map;

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
    
    public void setMapaAtributos(int s) {
        this.map = new mapa(s);
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
