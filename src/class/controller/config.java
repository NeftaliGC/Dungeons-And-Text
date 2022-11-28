package controller;

import org.json.JSONObject;

import model.Enemigo;
import model.arma;
import model.pocion;
import model.sala;
import model.salaArma;
import model.salaPocion;
import model.tesoro;

public class config {
    
    
    /** 
     * @param conf
     */
    public boolean configCheck(boolean conf) {
        boolean config;
        if (conf) {
            config = true;
        } else {
            config = false;
        }

        return config;
    }

    public JSONObject setObjectsOnSala(String objet) throws Exception {
        JSONObject objeto = null;

        if(objet == "arma") {

            objeto = json.Jobject("armas.json", random.generateRandom(0, 24));

        } else if (objet == "enemigo") {
            
            objeto = json.Jobject("Enemigos.json", random.generateRandom(0, 24));

        } else if (objet == "pocion") {

            objeto = json.Jobject("pociones.json", random.generateRandom(0, 7));

        } else if (objet == "zona") {

            objeto = json.Jobject("zonas.json", random.generateRandom(0, 24));

        } else if (objet == "tesoro") {

            objeto = json.Jobject("tesoro.json", 0);

        }

        return objeto;
    }

    public sala createSala() throws Exception {
        sala s = null;
        boolean salaT = false;
        JSONObject enemigo = setObjectsOnSala("enemigo");
        JSONObject zona = setObjectsOnSala("zona");

        Enemigo e = new Enemigo(enemigo.getString("nombre"), enemigo.getInt("Poder"), enemigo.getInt("Defensa"));
        arma a;
        pocion p;
        tesoro t;

        int sTipe;
        sTipe = random.generateRandom(1, 3);
        if (sTipe == 3 && salaT == false) {
            salaT = true;
            JSONObject tesoro = setObjectsOnSala("tesoro");
            t = new tesoro(tesoro.getString("nombre"));
        } else {
            sTipe = random.generateRandom(1, 2);
        }
        
        if (sTipe == 1) {
            
            JSONObject arma = setObjectsOnSala("arma");
            a = new arma(arma.getString("nombre"), arma.getInt("ataque"));
            
            s = new salaArma(e, zona.getString("nombre"), a);

        } else if (sTipe == 2) {

            JSONObject pocion = setObjectsOnSala("pocion");
            p = new pocion(pocion.getInt("nivel"), pocion.getInt("tipo"), pocion.getString("nombre"));

            s = new salaPocion(e, zona.getString("nombre"), p);
        }

        return s;
    }


}
