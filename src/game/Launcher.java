package game;

import views.Display;

/**
 *
 */
public class Launcher {
    public static void main (String args[]){
        Game game = new Game("JavaRPG" , 750 , 750);
        game.run();
        return;
    }
}
