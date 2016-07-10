package models.States;


import game.Game;
import input.KeyManager;
import input.MenuKeyManager;

import java.awt.*;

/**
 * Created by The Alex on 5/22/2016.
 */

public class MainMenuState extends State {
    /* Attributes */
    private MenuKeyManager keyManager;

    /* Constructors*/
    public MainMenuState(){
        super();
    };

    public MainMenuState(MenuKeyManager keyManager){
        this.keyManager = keyManager;
    }

    /* Methods*/
    public void tick(){
        keyManager.tick();

        if(keyManager.select0 || keyManager.select1){
            GameStateManager.setState(new CreateState());
        }
    }

    public void render(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(0 , 0 , 150 , 150);

    }

    public KeyManager getKeyManager(){
        return keyManager;
    }
}


