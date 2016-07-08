package game;

/**
 *  Responsible for instantiating the game and running it.
 */
public class Launcher {
    public static void main (String args[]){
        Game game = new Game("JavaRPG" , 800 , 800);
        game.start();
        return;
    }
}
