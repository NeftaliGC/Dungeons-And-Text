package view;

import java.io.IOException;
import java.util.Scanner;

import controller.config;
import model.Menu;
import model.juego;
import model.jugador;
import model.mapa;

/**
 * main
 */
public class dungeonsAndText {

    /**
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        jugador PLAYER;
        mapa MAPA;
        boolean ejecucion = true;
        int ns, v;
        String opcion;

        juego game = new juego();
        config config = new config();

        Menu inicio = new Menu(4);
        inicio.addOpcion("Iniciar partida");
        inicio.addOpcion("Configurar");
        inicio.addOpcion("Creditos");
        inicio.addOpcion("Salir al escritorio");

        do {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // limpia pantalla
            titulo();

            for (int i = 0; i < inicio.large(); i++) {
                inicio.dimeOpcion(i);
            }

            int flujo = inicio.leeOpcion();

            switch (flujo) {
                case 1:
                    if (config.configCheck(game.getCofig())) {

                    } else {
                        mensaje("Configura el juego antes de empezar a jugar. Pulsa ENTER para continuar: ");
                    }
                    break;
                case 2:
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // limpia pantalla
                    configuracionText();
                    do {
                        opcion = mensaje("Escribe tu nombre de jugador:");
                        ns = option(
                                "Las salas se organizaran de forma cuadrada, ejemplo 5x5 ó 2x2. \n Escribe el numero de salas, mayor a 1 y menor a 6: ");
                        System.out.println(
                                "Tú nombre es: " + opcion + "\n" + "El mapa tendra el tamaño de: " + ns + "x" + ns);
                        v = option("¿Estas seguro de esta configuración? 1 : Si, 2 : No");
                        if (v == 1) {
                            game.setJugadorAtributos(opcion);
                            game.setMapaAtributos(ns);
                            game.setCofig(true);
                        } else {
                            System.out.println("Vuelve a configurar el juego.");
                        }
                    } while (config.configCheck(game.getCofig()) == false);

                    break;
                case 3:
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // limpia pantalla
                    creditos();
                    System.out.println("Desarolladores:");
                    System.out.println("");
                    System.out.println("Dev: 1");
                    System.out.println("Dev: 2");
                    System.out.println("Dev: 3");
                    System.out.println("Dev: 4");
                    System.out.println("Dev: 5");

                    mensaje("Pulsa ENTER para volver al menu principal: ");

                    break;
                case 4:
                    ejecucion = false;

                    break;
                default:
                    System.out.println("Debes elegir una de las opciones");

                    break;
            }

        } while (ejecucion);

    }

    public static void titulo() {
        System.out.println("██████╗░██╗░░░██╗███╗░░██╗░██████╗░███████╗░█████╗░███╗░░██╗░██████╗");
        System.out.println("██╔══██╗██║░░░██║████╗░██║██╔════╝░██╔════╝██╔══██╗████╗░██║██╔════╝");
        System.out.println("██║░░██║██║░░░██║██╔██╗██║██║░░██╗░█████╗░░██║░░██║██╔██╗██║╚█████╗░");
        System.out.println("██║░░██║██║░░░██║██║╚████║██║░░╚██╗██╔══╝░░██║░░██║██║╚████║░╚═══██╗");
        System.out.println("██████╔╝╚██████╔╝██║░╚███║╚██████╔╝███████╗╚█████╔╝██║░╚███║██████╔╝");
        System.out.println("╚═════╝░░╚═════╝░╚═╝░░╚══╝░╚═════╝░╚══════╝░╚════╝░╚═╝░░╚══╝╚═════╝░");

        System.out.println(" ░█████╗░███╗░░██╗██████╗░       ████████╗███████╗██╗░░██╗████████╗ ");
        System.out.println(" ██╔══██╗████╗░██║██╔══██╗       ╚══██╔══╝██╔════╝╚██╗██╔╝╚══██╔══╝ ");
        System.out.println(" ███████║██╔██╗██║██║░░██║       ░░░██║░░░█████╗░░░╚███╔╝░░░░██║░░░ ");
        System.out.println(" ██╔══██║██║╚████║██║░░██║       ░░░██║░░░██╔══╝░░░██╔██╗░░░░██║░░░ ");
        System.out.println(" ██║░░██║██║░╚███║██████╔╝       ░░░██║░░░███████╗██╔╝╚██╗░░░██║░░░ ");
        System.out.println(" ╚═╝░░╚═╝╚═╝░░╚══╝╚═════╝░       ░░░╚═╝░░░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░ ");
        System.out.println("");
    }

    public static void configuracionText() {
        System.out.println("█▀▀ █▀█ █▄░█ █▀▀ █ █▀▀ █░█ █▀█ ▄▀█ █▀▀ █ █▀█ █▄░█");
        System.out.println("█▄▄ █▄█ █░▀█ █▀░ █ █▄█ █▄█ █▀▄ █▀█ █▄▄ █ █▄█ █░▀█");
        System.out.println("");
    }

    public static void creditos() {
        System.out.println("█▀▀ █▀█ █▀▀ █▀▄ █ ▀█▀ █▀█ █▀ ▀");
        System.out.println("█▄▄ █▀▄ ██▄ █▄▀ █ ░█░ █▄█ ▄█ ▄");
        System.out.println("");
    }

    /**
     * @param mensaje
     * @return String
     */
    public static String mensaje(String mensaje) {
        String m;
        do {
            Scanner entrada = new Scanner(System.in);
            System.out.print(mensaje + " ");
            try {
                m = entrada.nextLine();
                break;
            } catch (Exception e) {
                /*
                 * System.out.println("Escribe un numero.");
                 * m = 0;
                 */
            }

        } while (true);
        return m;
    }

    public static int option(String mensaje) {
        int num;
        do {
            Scanner entrada = new Scanner(System.in);
            System.out.print(mensaje);
            try {
                num = entrada.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Escribe un numero.");
                num = 0;
            }
        } while (true);
        return num;
    }
}