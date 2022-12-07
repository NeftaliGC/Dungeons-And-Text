package controller;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Enemigo;
import model.arma;
import model.pocion;
import model.sala;
import model.salaArma;
import model.salaPocion;
import model.salaTesoro;
import model.tesoro;

/**
 * Control objects JSON.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */

public class config {
    
    JSONArray armas;
    JSONArray enemigos;
    JSONArray pociones;
    JSONArray zonas;
    JSONArray tesoros;
    boolean salaT = false;

    
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

    
    /** 
     * @throws Exception
     */
    public void setObjectsOnSala() throws Exception {
        //JSONArray objeto = null;

        armas = json.Jobject("armas.json");
        enemigos = json.Jobject("Enemigos.json");
        pociones = json.Jobject("pociones.json");
        zonas = json.Jobject("zonas.json");
        tesoros = json.Jobject("tesoro.json");

        /* if(objet == "arma") {

            objeto = json.Jobject("armas.json");

        } else if (objet == "enemigo") {
            
            objeto = json.Jobject("Enemigos.json");

        } else if (objet == "pocion") {

            //objeto = json.Jobject("pociones.json", random.generateRandom(0, 7));
            objeto = json.Jobject("pociones.json");
            
        } else if (objet == "zona") {

            //objeto = json.Jobject("zonas.json", (random.generateRandom(1, 25) -1 ));
            objeto = json.Jobject("zonas.json");

        } else if (objet == "tesoro") {

            objeto = json.Jobject("tesoro.json");

        } */

    }


    
    /** 
     * @return sala
     * @throws Exception
     */
    public sala createSala() throws Exception {
        //JSONObject jObject = jArray.optJSONObject(index);
        setObjectsOnSala();
        sala s = null;
        int i = random.generateRandom(0, 24);
        JSONObject enemigo = enemigos.getJSONObject(i);
        i = random.generateRandom(0, 23);
        JSONObject zona = zonas.getJSONObject(i);

        Enemigo e = new Enemigo(enemigo.getString("nombre"), enemigo.getInt("Poder"), enemigo.getInt("Defensa"));
        arma a;
        pocion p;
        tesoro t;

        int sTipe;
        sTipe = random.generateRandom(1, 3);
        if (sTipe == 3 && salaT == false) {
            salaT = true;
            JSONObject tesoro = tesoros.getJSONObject(0);
            t = new tesoro(tesoro.getString("nombre"));

            s = new salaTesoro(e, zona.getString("nombre"), t, true);
        } else {
            sTipe = random.generateRandom(1, 2);
        }
        
        if (sTipe == 1) {
            
            i = random.generateRandom(0, 24);
            JSONObject arma = armas.getJSONObject(i);
            a = new arma(arma.getString("nombre"), arma.getInt("ataque"));
            
            s = new salaArma(e, zona.getString("nombre"), a, false);

        } else if (sTipe == 2) {
            i = random.generateRandom(0, 8);
            JSONObject pocion = pociones.getJSONObject(i);
            p = new pocion(pocion.getInt("nivel"), pocion.getInt("tipo"), pocion.getString("nombre"));

            s = new salaPocion(e, zona.getString("nombre"), p, false);
        }

        return s;
    }


}
