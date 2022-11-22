package controller;

import java.io.*;
import org.json.*;

public class json {

    public static void main(String[] args) {

        String a = leerJson(".\\src\\class\\controller\\asets\\armas.json");
        //String a = leerJson("./ejemplo/in.txt");
        
        //System.out.println(a);
        JSONArray jArray = new JSONArray(a);
        JSONObject jObject = jArray.optJSONObject(6);

        System.out.println(jObject.getInt("id"));

    }

    public static String leerJson(String url) {

        String texto = "";
        
        try {
            File f = new File(url);
            System.out.println(f.exists()); //saber si encontro el archivo

            BufferedReader bf = new BufferedReader(new FileReader(f.getPath()));
            String temp = "";
            String bfRead;

            while ( ( bfRead = bf.readLine() ) != null ) {
                // ciclo hasta que bfRead ya no tiene datos
                temp = temp + bfRead; // guarda el texto
            }

            texto = temp;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Archivo no encontrado");
        }

        return texto;
    }

}
