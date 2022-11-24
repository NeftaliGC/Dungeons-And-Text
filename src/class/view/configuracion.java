package view;

import java.util.Scanner;

public class configuracion {
    
    public static String player() {
        Scanner in = new Scanner(System.in);
        System.out.print("Ingresa tú nombre de jugador: ");
        String Nombre = in.nextLine();
        return Nombre;
    }

    

}
