package model;

/**
 * Create mochila.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */

public class mochila {
    private arma[] arsenal;
    private pocion[] Pociones;

    public mochila(int tamañoArsenal, int tamañoPociones) {
        this.arsenal = new arma[tamañoArsenal];
        this.Pociones = new pocion[tamañoPociones];
    }

    
    /** 
     * @return String
     */
    public String armasDatos() {
        String s = "";
        for (int i = 0; i < arsenal.length; i++) {
            if (arsenal[i] != null) {
                s = s + "< " + arsenal[i].getNombre() + " con poder de: " + arsenal[i].getPoder() + " >";
            } else {
                break;
            }
        }

        return s;
    }

    
    /** 
     * @param i
     * @return String
     */
    public String armasDatos(int i) {
        String s = " ";
        if (arsenal[i] != null) {
            s = s + "< " + arsenal[i].getNombre() + " con poder de: " + arsenal[i].getPoder() + " >";
        }
        return s;
    }
    
    
    /** 
     * @return String
     */
    public String pocionesDatos() {
        String s = "";
        for (int i = 0; i < Pociones.length; i++) {
            if (Pociones[i] != null) {
                s = s + "< " + Pociones[i].getNombre() + " con un nivel de: " + Pociones[i].getNivel() + " >";
            } else {
                break;
            }
        }
        
        return s;
    }
    
    
    /** 
     * @param i
     * @return String
     */
    public String pocionesDatos(int i) {
        String s = " ";
        if (Pociones[i] != null) {
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

    
    /** 
     * @param i
     * @return pocion
     * @throws Exception
     */
    public pocion sacarPocion(int i) throws  Exception{
        pocion p;

        if (i >= 0 && i < this.Pociones.length) {
            if (this.Pociones[i] != null) {
                p = this.Pociones[i];
                this.Pociones[i] = null;
        
                return p;
            } else {
                throw new Exception("No hay nada en la pocision " + i);
            }
        } else {
            throw new Exception("Posicion no valida");
        }
    }

    
    /** 
     * @return int
     */
    public int pocionesLenght() {
        return Pociones.length;
    }
    
    /** 
     * @return int
     */
    public int armasLenght() {
        return arsenal.length;
    }
}
 