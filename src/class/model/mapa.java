package model;
public class mapa {

    private int ns; //Numero de salas//
    private sala [][] mapa; //arreglo de mapa dependiente a la variable ns//

    /** 
     * @param salas
     */
    public mapa(int salas) {
        this.mapa = new sala[salas][salas];
        this.ns = salas;
    }
    
    /** 
     * @return int
     */
    public int getSalas() {
        return ns;
    }

}


