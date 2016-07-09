package input;

import models.States.PlayState;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 */
public class PlayKeyManager extends KeyManager {
    /* Attributes */
    public boolean north, south, east, west , inventory , equipment;

    /* Constructor */
    public PlayKeyManager(){
        super();
    }

    /* Methods */
    public void tick(){
        north = keys[KeyEvent.VK_UP];
        south = keys[KeyEvent.VK_DOWN];
        east = keys[KeyEvent.VK_RIGHT];
        west = keys[KeyEvent.VK_LEFT];
        inventory = keys[KeyEvent.VK_I];
        equipment = keys[KeyEvent.VK_E];
    }
}
