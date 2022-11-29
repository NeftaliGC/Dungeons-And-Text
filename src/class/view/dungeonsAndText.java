package view;

import java.util.Scanner;

import controller.combate;
import controller.config;
import controller.random;
import model.Enemigo;
import model.Menu;
import model.arma;
import model.juego;
import model.jugador;
import model.mapa;
import model.pocion;
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

        Menu salaMenu = new Menu(2);
        salaMenu.addOpcion("Recoger objeto de la sala");
        salaMenu.addOpcion("No hacer nada");

        Menu moverse = new Menu(4);
        moverse.addOpcion("Moverse al Norte");
        moverse.addOpcion("Moverse al Sur");
        moverse.addOpcion("Moverse al Este");
        moverse.addOpcion("Moverse al Oeste");

        Menu mMochila = new Menu(2);
        mMochila.addOpcion("Abrir bolsillo de pociones");
        mMochila.addOpcion("Abrir bolsillo de armas");

        Menu bPociones = new Menu(2);
        bPociones.addOpcion("Usar una pocion");
        bPociones.addOpcion("Tirar pocion");

        Menu bArmas = new Menu(2);
        bArmas.addOpcion("Equipar arma");
        bArmas.addOpcion("Tirar arma");

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
                        int op;

                        do {
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // limpia pantalla
                            s = MAPA.getSala(x, y);
                            Enemigo e = null;
                            try {
                                e = s.getEnemigo();
                                System.out.println(
                                        PLAYER.getNombre() + " estas en " + s.getNombre() + " con " + e.getNombre());

                            } catch (Exception z) {
                                System.out.println(PLAYER.getNombre() + " estas en " + s.getNombre());
                            }
                            System.out.println("¿Que haces?");
                            for (int i = 0; i < jMenu.large(); i++) {
                                jMenu.dimeOpcion(i);
                            }
                            op = jMenu.leeOpcion();

                            switch (op) {
                                case 1:
                                    try {
                                        System.out.println("Combates a " + e.getNombre());
                                        System.out.println("Atacas con " + combate.ataqueJugador(PLAYER.ataca(), PLAYER.poderArmaEquipada()) + " de Poder a " + e.getNombre());
                                        System.out.println(e.getNombre() + " te ataca con " + combate.ataqueEnemigo(e.ataque()) + " de poder");
                                        boolean[] resultadoPelea = combate.jGanador(PLAYER.defender(), e.defender());
                                        if (resultadoPelea[0] == true && resultadoPelea[1] == false) {
                                            System.out.println("Has ganado la pelea contra: " + e.getNombre());
                                            s.setEnemigo(null);
                                            mensaje("Pulsa ENTER para continuar");
                                        } else if (resultadoPelea[0] == false && resultadoPelea[1] == false) {
                                            System.out.println("Has perdido la pelea contra: " + e.getNombre());
                                            PLAYER.setArma(PLAYER.getPuño());
                                            PLAYER.setVida(-1);
                                            mensaje("Pulsa ENTER para continuar");
                                        } else if (resultadoPelea[0] == false && resultadoPelea[1] == true) {
                                            System.out.println("Fue un empate, vuelve a empezar.");
                                            mensaje("Pulsa ENTER para continuar");
                                        }
                                    } catch (Exception z) {
                                        System.out.println("No hay enemigo que combatir");
                                        mensaje("Pulsa ENTER para continuar");
                                    }

                                    break;
                                case 2:
                                    try {
                                        System.out.println(s.getDatos());
                                        for (int i = 0; i < salaMenu.large(); i++) {
                                            salaMenu.dimeOpcion(i);
                                        }
                                        op = salaMenu.leeOpcion();
                                        if (e == null && op == 1) {
                                            if (op == 1) {
                                                if (s.rtPocion(null) != null) {
                                                    try {
                                                        pocion p = s.rtPocion(null);
                                                        PLAYER.recogerPocion(p);
                                                    } catch (Exception z) {
                                                        System.out.println("La mochila de pociones esta llena");
                                                    }
                                                } else if (s.rtArma(null) != null) {
                                                    try {
                                                        arma ar = s.rtArma(null);
                                                        PLAYER.recogerArma(ar);
                                                    } catch (Exception z) {
                                                        System.out.println("La mochila de armas esta llena");
                                                    }
                                                }

                                                mensaje("Pulsa ENTER para continuar: ");
                                            }
                                        } else if (s.getEnemigo() != null && op == 1) {
                                            System.out.println("Derrota al enemigo primero");
                                            mensaje("Pulsa ENTER para continuar: ");
                                        }
                                    } catch (Exception z) {
                                        System.out.println("La sala no tiene objetos");
                                        mensaje("Pulsa ENTER para continuar: ");
                                    }

                                    break;
                                case 3:
                                    try {
                                        System.out.println("En la sala esta: " + e.getNombre());
                                        mensaje("Pulsa ENTER para continuar: ");
                                    } catch (Exception z) {
                                        System.out.println("No hay enemigo");
                                        mensaje("Pulsa ENTER para continuar: ");
                                    }

                                    break;
                                case 4:
                                    System.out.println("¿Hacia donde te quieres mover?");
                                    for (int i = 0; i < moverse.large(); i++) {
                                        moverse.dimeOpcion(i);
                                    }
                                    op = moverse.leeOpcion();
                                    switch (op) {
                                        case 1:
                                            x -= 1;
                                            if (x < 0) {
                                                x = MAPA.getSalas() - 1;
                                            }
                                            break;
                                        case 2:
                                            x += 1;
                                            if (x > MAPA.getSalas() - 1) {
                                                x = 0;
                                            }
                                            break;
                                        case 3:
                                            y += 1;
                                            if (y > MAPA.getSalas() - 1) {
                                                y = 0;
                                            }
                                            break;
                                        case 4:
                                            y -= 1;
                                            if (x < 0) {
                                                y = MAPA.getSalas() - 1;
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 5:
                                    System.out.println("¿Que deseas hacer?");
                                    for (int i = 0; i < mMochila.large(); i++) {
                                        mMochila.dimeOpcion(i);
                                    }
                                    op = mMochila.leeOpcion();

                                    

                                default:
                                    break;
                            }

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

    
    /** 
     * @param mensaje
     * @return int
     */
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