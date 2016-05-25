package models.States;

import input.KeyManager;
import input.PlayKeyManager;
import models.Entity.Avatar;
import models.Location;
import models.Map.Map;


import java.awt.*;

/**
 *
 */
public class PlayState extends State {
    /* Attributes */
    private Avatar player;
    private PlayKeyManager keyManager;
    private Map gameMap;

    /* Constructors*/
    public PlayState(){
        super();
    }

    public PlayState(Avatar player , PlayKeyManager keyManager){
        this.player = player;
        this.keyManager = keyManager;
        gameMap = new Map(player);
    }


    /* Methods */
    public void tick(){
        keyManager.tick();

        if( keyManager.north){
            player.testNorth();
        }
        if(keyManager.south){
            player.testSouth();
        }
        if(keyManager.northEast){
            player.testNorthEast();
        }
        if(keyManager.northWest){
            player.testNorthWest();
        }
        if(keyManager.southEast){
            player.testSouthEast();
        }
        if(keyManager.southWest){
            player.testSouthWest();
        }
    }

    public void render(Graphics g){
        gameMap.render(g);
        player.render(g);
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
}
