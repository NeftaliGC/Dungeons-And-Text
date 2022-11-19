package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class json {

    public static void main(String[] args) throws FileNotFoundException {

        JSONParser jsonParser = new JSONParser();
        File f = new File("./Enemigos.json");
        
        try (FileReader fReader = new FileReader("Enemigos.json")) {
            Object obj = jsonParser.parse(fReader);
            JSONArray enemigos = (JSONArray) obj;
            System.out.println(enemigos);

        } catch (IOException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
