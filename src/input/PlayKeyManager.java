package input;

import models.States.PlayState;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 */
public class PlayKeyManager extends KeyManager {
    /* Attributes */
    public boolean north, south, northEast, northWest, southWest, southEast;

    /* Constructor */
    public PlayKeyManager(){
        super();
    }

    /* Methods */
    public void tick(){
        north = keys[KeyEvent.VK_NUMPAD8];
        south = keys[KeyEvent.VK_NUMPAD5];
        northEast = keys[KeyEvent.VK_NUMPAD9];
        northWest = keys[KeyEvent.VK_NUMPAD7];
        southEast = keys[KeyEvent.VK_NUMPAD6];
        southWest = keys[KeyEvent.VK_NUMPAD4];
    }
}
