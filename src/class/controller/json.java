package controller;

import java.io.*;
import org.json.*;

/**
 * Lectura de archivos JSON.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */

public class json {

    
    /** 
     * @param file
     * @param index
     * @return JSONObject
     * @throws Exception
     */
    public static JSONArray Jobject(String file/* , /*int index*/) throws Exception {

        String archivo = file;
        String a = leerJson("./src/assets/" + archivo);
        
        JSONArray jArray = new JSONArray(a);
        //JSONObject jObject = jArray.optJSONObject(index);

        //return jObject;
        return jArray;

    }

    
    /** 
     * @param url
     * @return String
     * @throws Exception
     */
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
