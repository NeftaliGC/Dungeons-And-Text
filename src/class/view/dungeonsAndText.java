package view;

import java.util.Scanner;

import controller.combate;
import controller.config;
import controller.controlJugador;
import controller.controlMochila;
import controller.random;
import model.Enemigo;
import model.Menu;
import model.arma;
import model.juego;
import model.jugador;
import model.mapa;
import model.mochila;
import model.pocion;
import model.sala;


/**
 * Class Main.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */


/**
 * main
 */
public class dungeonsAndText {

    public static jugador player;
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
        mochila m;

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

        Menu bPociones = new Menu(3);
        bPociones.addOpcion("Usar una pocion");
        bPociones.addOpcion("Tirar pocion");
        bPociones.addOpcion("No hacer nada");

        Menu botiquin = null;

        Menu bArmas = new Menu(3);
        bArmas.addOpcion("Equipar arma");
        bArmas.addOpcion("Tirar arma");
        bArmas.addOpcion("No hacer nada");

        Menu armas = null;
        boolean ejecucionJuego = true;

        do {
            // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // limpia pantalla windows
            clear();
            titulo();

            int flujo = inicio.leeOpcion();

            switch (flujo) {

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Start Game Zone

                case 1:
                    if (config.configCheck(game.getCofig()) && ejecucionJuego == true) {
                        // inGame.game();

                        int x = random.generateRandom(0, MAPA.getSalas() - 1);
                        int y = random.generateRandom(0, MAPA.getSalas() - 1);

                        sala s;
                        int op;
                        m = player.getMochila();
                        pocion pocion_temp;
                        arma arma_temp;

                        do {
                            // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // limpia pantalla
                            clear();
                            op = 0;
                            s = MAPA.getSala(x, y);
                            Enemigo e = null;
                            botiquin = new Menu(player.getMochila().pocionesLenght());

                            armas = new Menu(player.getMochila().armasLenght());

                            try {
                                e = s.getEnemigo();
                                System.out.println(
                                        player.getNombre() + " tienes " + player.getVida() + " vidas" + " y estas en " + s.getNombre() + " con " + e.getNombre());

                            } catch (Exception z) {
                                System.out.println(player.getNombre() + " estas en " + s.getNombre());
                            }
                            System.out.println("¿Que haces?");
                            op = jMenu.leeOpcion();

                            switch (op) {
                                case 1:
                                    try {
                                        System.out.println("Combates a " + e.getNombre());
                                        System.out.println("Atacas con "
                                                + combate.ataqueJugador(player.ataca(), player.poderArmaEquipada())
                                                + " de Poder a " + e.getNombre());
                                        System.out.println(e.getNombre() + " te ataca con "
                                                + combate.ataqueEnemigo(e.ataque()) + " de poder");
                                        boolean[] resultadoPelea = combate.jGanador(player.defender(), e.defender());
                                        if (resultadoPelea[0] == true && resultadoPelea[1] == false) {
                                            System.out.println("Has ganado la pelea contra: " + e.getNombre());
                                            s.setEnemigo(null);
                                            mensaje("Pulsa ENTER para continuar");
                                        } else if (resultadoPelea[0] == false && resultadoPelea[1] == false) {
                                            System.out.println("Has perdido la pelea contra: " + e.getNombre());
                                            player.setArma(player.getPuño());
                                            player.setVida(controlJugador.subirEstadistica(player.getVida(), -1));
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
                                        op = salaMenu.leeOpcion();
                                        if (e == null && op == 1) {

                                            if (s.getTesoro()) {
                                                System.out.println("Has recogido el TESORO");
                                                System.out.println("Has ganado el juego");
                                                ejecucionJuego = false;
                                                mensaje("Pulsa ENTER para continuar");
                                            }

                                            if (op == 1) {
                                                if (s.getPocion(null) != null) {
                                                    try {
                                                        pocion p = s.getPocion(null);
                                                        player.recogerPocion(p);
                                                        s.setPocion(null);
                                                    } catch (Exception z) {
                                                        System.out.println("La mochila de pociones esta llena");
                                                    }
                                                } else if (s.getArma(null) != null) {
                                                    try {
                                                        arma ar = s.getArma(null);
                                                        player.recogerArma(ar);
                                                        s.setArma(null);
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
                                            if (y < 0) {
                                                y = MAPA.getSalas() - 1;
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case 5:
                                    System.out.println("¿Que deseas hacer?");
                                    String d;
                                    op = mMochila.leeOpcion();

                                    try {
                                        if (op == 1) {
                                            d = player.getMochila().pocionesDatos();
                                            System.out.println(controlMochila.datosMochila(d));
                                            System.out.println("¿Que quieres hacer?");
                                            op = bPociones.leeOpcion();
                                            switch (op) {
                                                case 1:
                                                    System.out.println("¿Que pocion quieres usar?");
                                                    for (int i = 0; i < botiquin.large(); i++) {
                                                        d = player.getMochila().pocionesDatos(i);
                                                        botiquin.addOpcion(d);
                                                    }
                                                    op = botiquin.leeOpcion();

                                                    pocion_temp = player.getMochila().sacarPocion(op - 1);
                                                    if (controlJugador.indetificarTipoPocion(pocion_temp) == 1) {

                                                        System.out.println("Tienes una vida de " + player.getVida());
                                                        System.out.println("Tu vida aumentara en: " + pocion_temp.getNivel());
                                                        mensaje("Pulsa ENTER para continuar");
                                                        player.setVida(controlJugador.subirEstadistica(player.getVida(), pocion_temp.getNivel()));
                                                        System.out.println("Tu vida ahora es de: " + player.getVida());

                                                    } else if (controlJugador.indetificarTipoPocion(pocion_temp) == 2) {

                                                        System.out.println("Tienes un poder de " + player.getPoder());
                                                        System.out.println(
                                                                "Tu poder aumentara en: " + pocion_temp.getNivel());
                                                        mensaje("Pulsa ENTER para continuar");
                                                        player.setPoder(controlJugador.subirEstadistica(player.getPoder(), pocion_temp.getNivel()));
                                                        System.out
                                                                .println("Tu poder ahora es de: " + player.getPoder());

                                                    } else if (controlJugador.indetificarTipoPocion(pocion_temp) == 3) {

                                                        System.out.println(
                                                                "Tienes una defensa de " + player.getDefensa());
                                                        System.out.println(
                                                                "Tu defensa aumentara en: " + pocion_temp.getNivel());
                                                        mensaje("Pulsa ENTER para continuar");
                                                        player.setDefensa(controlJugador.subirEstadistica(
                                                                player.getDefensa(), pocion_temp.getNivel()));
                                                        System.out.println(
                                                                "Tu defensa ahora es de: " + player.getDefensa());

                                                    }

                                                    mensaje("Pulsa ENTER para continuar: ");
                                                    break;

                                                case 2:
                                                    if (s.getTesoro()) {
                                                        System.out.println("No puedes tirar objetos en la sala del tesoro");
                                                        mensaje("Pulsa ENTER para continuar: ");
                                                    } else {
                                                        System.out.println("¿Que pocion quieres tirar?");
                                                        for (int i = 0; i < botiquin.large(); i++) {
                                                            d = player.getMochila().pocionesDatos(i);
                                                            botiquin.addOpcion(d);
                                                        }
                                                        op = botiquin.leeOpcion() - 1;
    
                                                        try {
                                                            pocion_temp = player.getMochila().sacarPocion(op);
                                                            mensaje("Dejaras la pocion en " + s.getNombre()
                                                                    + " pulsa ENTER para continuar");
                                                            s.setPocion(pocion_temp);
                                                        } catch (Exception z) {
                                                            System.out.println("No pudes dejar mas cosas en esta sala.");
                                                        }
                                                        mensaje("Pulsa ENTER para continuar: ");
                                                    }
                                                    
                                                    break;
                                                case 3:
                                                    break;
                                            }

                                        } else if (op == 2) {
                                            d = player.getMochila().armasDatos();
                                            System.out.println(controlMochila.datosMochila(d));
                                            System.out.println("¿Que quieres hacer?");
                                            op = bArmas.leeOpcion();

                                            switch (op) {
                                                case 1:
                                                    System.out.println("¿Que arma quieres usar?");
                                                    for (int i = 0; i < armas.large(); i++) {
                                                        d = player.getMochila().armasDatos(i);
                                                        armas.addOpcion(d);
                                                    }
                                                    op = armas.leeOpcion() - 1;

                                                    arma_temp = player.getMochila().sacarArma(op);

                                                    player.setArma(arma_temp);

                                                    System.out.println("Ahora llevas equipada el arma: " + arma_temp.getNombre());
                                                    mensaje("Pulsa ENTER para continuar");

                                                    break;
                                                case 2:
                                                    if (s.getTesoro()) {
                                                        System.out.println("No puedes tirar objetos en la sala del tesoro");
                                                        mensaje("Pulsa ENTER para continuar: ");
                                                    } else {
                                                        System.out.println("¿Que arma quieres tirar?");
                                                        for (int i = 0; i < botiquin.large(); i++) {
                                                            d = player.getMochila().pocionesDatos(i);
                                                            botiquin.addOpcion(d);
                                                        }
                                                        op = botiquin.leeOpcion() - 1;
                                                        try {
                                                            arma_temp = player.getMochila().sacarArma(op);
                                                            mensaje("Dejaras el arma en " + s.getNombre() + " pulsa ENTER para continuar");
                                                            s.setArma(arma_temp);
                                                        } catch (Exception z) {
                                                            System.out.println("No pudes dejar mas cosas en esta sala.");
                                                        }
                                                        mensaje("Pulsa ENTER para continuar");
                                                    }
                                                    break;
                                                case 3:
                                                    break;
                                            }
                                        }
                                    } catch (Exception z) {
                                        System.out.println("La mochila esta vacia.");
                                        mensaje("Pulsa ENTER para continuar: ");
                                    }
                                    botiquin.reset();
                                    armas.reset();

                                default:
                                    break;
                            }

                        } while (player.getVida() > 0 && ejecucionJuego);
                        System.out.println("El  juego ha terminado");

                    } else {
                        mensaje("Configura el juego antes de empezar a jugar. Pulsa ENTER para continuar: ");
                    }
                    break;

// End Game Zone
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                case 2:
                    // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // limpia pantalla
                    clear();
                    configuracionText();
                    do {
                        ejecucionJuego = true;
                        opcion = mensaje("Escribe tu nombre de jugador:");
                        do {
                            System.out.println(" ");
                            ns = option("Las salas se organizaran de forma cuadrada, ejemplo 5x5 ó 2x2. \n Escribe el numero de salas, mayor a 1 y menor a 6: ");
                            if (ns > 5 || ns < 2) {
                                System.out.println(" ");
                                System.out.println("El minimo de salas es 2x2 y el maximo es 5x5, vuelve a configurar las salas");
                            } else {
                                break;
                            }
                        } while (ejecucion);

                        System.out.println(" ");
                        System.out.println("Tú nombre es: " + opcion + "\n" + "El mapa tendra el tamaño de: " + ns + "x" + ns);
                        v = option("¿Estas seguro de esta configuración? 1 : Si, 2 : No => ");
                        if (v == 1) {
                            game.setJugadorAtributos(opcion);
                            game.setMapaAtributos(ns);
                            game.setCofig(true);
                            player = game.getJugador();
                            MAPA = game.getMapa();
                        } else {
                            System.out.println("Vuelve a configurar el juego.");
                        }
                    } while (config.configCheck(game.getCofig()) == false);

                    break;
                case 3:
                    // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // limpia pantalla
                    clear();
                    creditos();
                    System.out.println("Desarolladores:");
                    System.out.println("");
                    System.out.println("Dev: Aalan Kalid Ruiz Colin");
                    System.out.println("Dev: Fabian Neftaly Guia Cruz");
                    System.out.println("Dev: Harumy Genaro González");
                    System.out.println("Dev: Josué Hernández Ventura");
                    System.out.println("Dev: Miguel Omaet Aguilar Martinez");

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

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}