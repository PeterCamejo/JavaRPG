package Main;

/**
 * Created by denzel on 4/11/16.
 */


import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import utilities.GameStateManager;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
/**
 * Responsibilities: to listen to key input and send to current controller
 */

public class InputManager{

    //GameStateManager
    private GameStateManager gsm;

    // HashList
    static HashSet<Integer> active = new HashSet<>();

    public InputManager(GameStateManager gsm){
        this.gsm = gsm;
    }

    // called by InputManager
    public static void addCommand(KeyEvent event) {
        active.add(event.getKeyCode());
    }

    public static void removeCommand(KeyEvent event) {
        active.remove( event.getKeyCode());
    }

    //send the key to the controller
    public void getActiveKey(KeyEvent e){
        gsm.getCurrentController().handleInput(e);
    }


}
