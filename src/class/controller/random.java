package controller;

/**
 * Randoom Number Generator.
 * 
 * @author Aalan Kalid Ruiz Colin 
 * @author Fabian Neftaly Guia Cruz 
 * @author Harumy Genaro González
 * @author Josué Hernández Ventura 
 * @author Miguel Omaet Aguilar Martinez 
 * @version (1.0.0)
 */

public class random {

    
    /** 
     * @param min
     * @param max
     * @return int
     */
    public static int generateRandom(int min, int max) {
        int random_int = (int)Math.floor(Math.random()*(max - min + 1) + min);
        return random_int;
    }

}
