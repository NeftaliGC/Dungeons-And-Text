package model;
import java.util.Scanner;
public class mapa {

    private int ns; //Numero de salas//
    private int [][] mapa; //arreglo de mapa dependiente a la variable ns//



    public int DimeSalas(){
        //Clase para especificar la cantidad de salas//

        Scanner sc = new Scanner(System.in);
        System.out.println("Especifica la cantidad de salas a generar");
        ns = sc.nextInt();
        System.out.println("La cantidad de salas a generar es"+ns+"x"+ns);
        return ns;
    }




    public void PintaSalas(){
        //Clase dedicada para generar las salas//
        mapa = new int [ns][ns];
        
    }
}


