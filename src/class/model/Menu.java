package model;
import java.util.Scanner;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu{
    private String[] opciones;
    private int numeroOpciones;
    
    
    /** 
     * @param op
     * @return String
     */
    public String dimeOpcion(int op){
        return this.opciones[op];
    }

    
    /** 
     * @return int
     */
    public int leeOpcion(){
        Scanner entrada;
        String cad;
        int salida=1;
        do{
            try{
                this.pinta();
                entrada= new Scanner(System.in);
                System.out.println("Selecciona una opcion: ");
                cad= entrada.next();
                salida = Integer.parseInt(cad);
                if(salida<1 || salida>this.numeroOpciones){
                    System.out.println("Elige una de las opciones disponibles.");
                    salida = -1;
                }
            }catch(NumberFormatException e){
                System.out.println("Debes selacionar un numero entero");
                salida = -1;
            }
        }while(salida==-1);
        return salida;
    }

    
    /** 
     * @param op
     */
    public void addOpcion(String op){
        for(int i=0;i<this.opciones.length;i++){
            if(this.opciones[i]==null){
                this.opciones[i]=op;
                this.numeroOpciones+=1;
                break;
            }
        }
    }

    public Menu(int t){
        this.opciones = new String[t];
        this.numeroOpciones = 0;
    }

    public void pinta(){
        for(int i=0,j=1;i<this.opciones.length;i++,j++){
            if(this.opciones[i]!=null){
                System.out.println(j+ ") "+ this.opciones[i]);
            }else{
                break;
            }
        }
    }

    public void reset() {
        opciones = null;
    }

    /** 
     * @return int
     */
    public int large() {
        int l;
        l = opciones.length;
        return l;
    }
}
