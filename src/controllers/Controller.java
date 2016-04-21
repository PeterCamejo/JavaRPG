package controllers;

import utilities.GameStateManager;
import utilities.KeyCommand.KeyCommand;

import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by denzel on 4/11/16.
 */

//TODO: I don't think controllers should extend the inputmanager. AI Controllers dont need input
public abstract class Controller{

    // Hashmap of KeyEvents
    protected HashMap<Integer, KeyCommand> keyMap;

    //GameStateManager
    protected GameStateManager gsm;

    public Controller( GameStateManager gsm) {
        keyMap = new HashMap<>();
        this.gsm = gsm;
        loadKeyCommand();
    }

    // update method
    public void handleInput(KeyEvent e){
        if(keyMap.get(e.getKeyCode())!= null) {
            keyMap.get(e.getKeyCode()).execute();
        }else{
            System.out.println("Key Mapping Does Not Exist");
        }
    }

    public abstract void loadKeyCommand();

    public abstract void updateModel();
}