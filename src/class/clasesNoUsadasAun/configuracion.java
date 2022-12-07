package clasesNoUsadasAun;

import java.util.Scanner;

public class configuracion {
    
    
    /** 
     * @return String
     */
    public static String player() {
        Scanner in = new Scanner(System.in);
        System.out.print("Ingresa tú nombre de jugador: ");
        String Nombre = in.nextLine();
        return Nombre;
    }

    

}
