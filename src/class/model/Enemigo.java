package constructor;

/**
 * Write a description of class Enemigos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo
{
    public static void EnemyRNG( String args[] ) {
        int min = 1;
        int max = 25;

        System.out.println("El enemigo a enfrentar es ");
        int Enem = (int)Math.floor(Math.random()*(max-min+1)+min);

        switch(Enem){
            case 1:
                System.out.println("Esqueleto");
                break;
            case 2:
                System.out.println("Araña");
                break;
            case 3:
                System.out.println("Golem");
                break;
            case 4:
                System.out.println("Rata");
                break;
            case 5:
                System.out.println("Rata Gigante");
                break;
            case 6:
                System.out.println("Minotauro");
                break;
            case 7:
                System.out.println("Escorpion Gigante");
                break;
            case 8:
                System.out.println("Esqueleto Armado");
                break;
            case 9:
                System.out.println("Cria de dragon");
                break;
            case 10:
                System.out.println("Espiritu de Fuego");
                break;
            case 11:
                System.out.println("Espiritu  de Hielo");
                break;
            case 12:
                System.out.println("Espiritu");
                break;
            case 13:
                System.out.println("Fantasma");
                break;
            case 14:
                System.out.println("Demonio Menor");
                break;
            case 15:
                System.out.println("Calavera Fantasma");
                break;
            case 16:
                System.out.println("Slime");
                break;
            case 17:
                System.out.println("Zombie");
                break;
            case 18:
                System.out.println("Murcielago");
                break;
            case 19:
                System.out.println("Esqueleto Mago");
                break;
            case 20:
                System.out.println("Nigromante");
                break;
            case 21:
                System.out.println("Momia");
                break;
            case 22:
                System.out.println("Observador");
                break;
            case 23:
                System.out.println("Golem de Roca");
                break;
            case 24:
                System.out.println("Ent");
                break;
            case 25:
                System.out.println("Abogado Exigente");
                break;
        }
    }
}