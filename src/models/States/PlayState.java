package models.States;

import input.KeyManager;
import input.PlayKeyManager;
import models.Entity.Avatar;
import views.Assets;

import java.awt.*;

/**
 *
 */
public class PlayState extends State {
    /* Attributes */
    private Avatar player;
    private PlayKeyManager keyManager;

    /* Constructors*/
    public PlayState(){
        super();
    }

    public PlayState(Avatar player , PlayKeyManager keyManager){
        this.player = player;
        this.keyManager = keyManager;
    }


    /* Methods */
    public void tick(){
        keyManager.tick();

        if( keyManager.north){
            player.testUp();
        }
        if(keyManager.south){
            player.testDown();
        }
    }
    public void render(Graphics g){
        player.render(g);
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
}
