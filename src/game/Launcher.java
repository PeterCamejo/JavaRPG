package game;

/**
 *  Responsible for instantiating the game and running it.
 */
public class Launcher {
    public static void main (String args[]){
        Game game = new Game("JavaRPG" , 750 , 750);
        game.start();
        return;
    }
}
