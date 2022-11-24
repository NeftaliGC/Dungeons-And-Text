package model;
public class mapa {

    private int ns; //Numero de salas//
    private int [][] mapa; //arreglo de mapa dependiente a la variable ns//

    public void setSalas(int salas){
        this.ns = salas;
    }

    public void setMapa(int salas) {
        this.mapa = new int[ns][ns];
    }

    public int getSalas() {
        return ns;
    }

}


