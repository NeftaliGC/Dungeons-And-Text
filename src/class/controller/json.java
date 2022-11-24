package controller;

import java.io.*;
import org.json.*;

public class json {

    public static JSONObject Jobject(String file, int index) throws Exception {

        String archivo = file;
        String a = leerJson("./src/asets/" + archivo);
        
        JSONArray jArray = new JSONArray(a);
        JSONObject jObject = jArray.optJSONObject(index);

        return jObject;

    }

    public static String leerJson(String url) throws Exception{

        String texto = "";
        
        try {
            File f = new File(url);

            BufferedReader bf = new BufferedReader(new FileReader(f.getPath()));
            String temp = "";
            String bfRead;

            while ( ( bfRead = bf.readLine() ) != null ) {
                // ciclo hasta que bfRead ya no tiene datos
                temp = temp + bfRead; // guarda el texto
            }

            texto = temp;

        } catch (Exception e) {
            throw new Exception("Archivo no encontrado");
        }

        return texto;
    }

}
