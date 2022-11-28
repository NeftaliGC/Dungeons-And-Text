package view;

import java.util.Scanner;

import controller.config;
import controller.random;
import model.Enemigo;
import model.Menu;
import model.juego;
import model.jugador;
import model.mapa;
import model.sala;

/**
 * main
 */
public class dungeonsAndText {

    public static jugador PLAYER;
    public static mapa MAPA;

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

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

        Menu jMenu = new Menu(5);
        jMenu.addOpcion("Combatir");
        jMenu.addOpcion("Registrar sala");
        jMenu.addOpcion("Identificar Enemigo");
        jMenu.addOpcion("Moverse de sala");
        jMenu.addOpcion("Mochila");

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
                        // inGame.game();

                        int x = random.generateRandom(0, MAPA.getSalas() - 1);
                        int y = random.generateRandom(0, MAPA.getSalas() - 1);

                        sala s;

                        do {

                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // limpia pantalla
                            s = MAPA.getSala(x, y);
                            Enemigo e = s.getEnemigo();
                            System.out.println(PLAYER.getNombre() + " estas en " + s.getNombre() + " con " + e.getNombre());
                            System.out.println("¿Que haces?");
                            for (int i = 0; i < jMenu.large(); i++) {
                                jMenu.dimeOpcion(i);
                            }
                            jMenu.leeOpcion();
                            

                        } while (true);

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
                        v = option("¿Estas seguro de esta configuración? 1 : Si, 2 : No => ");
                        if (v == 1) {
                            game.setJugadorAtributos(opcion);
                            game.setMapaAtributos(ns);
                            game.setCofig(true);
                            PLAYER = game.getJugador();
                            MAPA = game.getMapa();
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