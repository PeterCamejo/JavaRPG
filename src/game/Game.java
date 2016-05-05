package game;

import views.Display;

import java.util.DuplicateFormatFlagsException;

/**
 *
 */
public class Game {
    private Display display;

    int width, height;

    public Game(String title , int width, int height){
        this.width =    width;
        this.height =   height;
        display = new Display(title, width, height);
    }
}
