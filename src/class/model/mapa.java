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

    
    /** 
     * @param s
     * @param m
     * @param n
     */
    public void setSala(sala s, int m, int n) {
        this.mapa[m][n] = s;
    }

    
    /** 
     * @param n
     * @param m
     * @return sala
     */
    public sala getSala(int n, int m) {
        return this.mapa[n][m];
    }

}


