package model;

public class mochila {
    private arma[] arsenal;
    private pocion[] Pociones;

    public mochila(int tamañoArsenal, int tamañoPociones) {
        this.arsenal = new arma[tamañoArsenal];
        this.Pociones = new pocion[tamañoPociones];
    }

    public String armasDatos() {
        String s = "";
        for (int i = 0; i < arsenal.length; i++) {
            s = s + "< " + arsenal[i].getNombre() + " con poder de: " + arsenal[i].getPoder() + " >";
        }

        return s;
    }

    public String pocionesDatos() {
        String s = "";
        for (int i = 0; i < Pociones.length; i++) {
            s = s + "< " + Pociones[i].getNombre() + " con un nivel de: " + Pociones[i].getNivel() + " >";
        }

        return s;
    }

    
    /** 
     * @param a
     * @throws Exception
     */
    public void addArma(arma a) throws Exception {
        for (int i = 0; i <= this.arsenal.length; i++) {
            if (this.arsenal[i] == null) {
                this.arsenal[i] = a;
                break;
            }
            if (i >= this.arsenal.length) {
                throw new Exception("Mochila llena");
            }
        }
    }

    
    /** 
     * @param p
     * @throws Exception
     */
    public void addPocion(pocion p) throws Exception {
        for (int i = 0; i <= this.Pociones.length; i++) {
            if (this.Pociones[i] == null) {
                this.Pociones[i] = p;
                break;
            }
            if (i >= this.Pociones.length) {
                throw new Exception("Mochila llena");
            }
        }
    }

    
    /** 
     * @param i
     * @return arma
     * @throws Exception
     */
    public arma sacarArma(int i) throws  Exception{
        arma a;

        if (i >= 0 && i < this.arsenal.length) {
            if (this.arsenal[i] != null) {
                a = this.arsenal[i];
                this.arsenal[i] = null;
        
                return a;
            } else {
                throw new Exception("No hay nada en la pocision " + i);
            }
        } else {
            throw new Exception("Posicion no valida");
        }

    }

    
    /** 
     * @param a
     * @return arma
     * @throws Exception
     */
    public arma sacarArma(arma a) throws Exception{
        int i = 0;
        arma r = null;
        for (i = 0; i < this.arsenal.length; i++) {
            if (a == this.arsenal[i]) {
                r = this.arsenal[i];
                this.arsenal[i] = null;
            }
        }
        if (i >= arsenal.length && r == null) {
            throw new Exception("El arma no esta en la mochila");
        } else {
            return r;
        }
  
        /* if (int i =  >= 0 && i < this.arsenal.length) {
            if (this.arsenal[i] != null) {
                a = this.arsenal[i];
                this.arsenal[i] = null;
        
                return a;
            } else {
                throw new Exception("No hay nada en la pocision " + i);
            }
        } else {
            throw new Exception("Posicion no valida");
        } */

    }

    
    /** 
     * @param p
     * @return pocion
     * @throws Exception
     */
    public pocion sacarPocion(pocion p) throws  Exception{
        int i = 0;
        pocion r = null;
        for (i = 0; i < this.Pociones.length; i++) {
            if (p == this.Pociones[i]) {
                r = this.Pociones[i];
                this.Pociones[i] = null;
            }
        }
        if (i >= arsenal.length && r == null) {
            throw new Exception("El arma no esta en la mochila");
        } else {
            return r;

        }
    }
}
 