package controller;

import org.json.JSONObject;

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

}
