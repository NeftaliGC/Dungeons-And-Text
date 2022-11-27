package controller;
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
