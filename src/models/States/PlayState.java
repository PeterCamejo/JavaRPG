package models.States;

import input.KeyManager;
import input.PlayKeyManager;
import models.Entity.Avatar;
import models.Location;
import models.Map.Map;
import models.Movement;


import java.awt.*;

/**
 *
 */
public class PlayState extends State {
    /* Attributes */
    private Avatar player;
    private PlayKeyManager keyManager;
    private Map gameMap;
    private int tileSize;
    private int mapSize;

    /* Constructors*/
    public PlayState(){
        super();
    }

    public PlayState(Avatar player , PlayKeyManager keyManager) {
        tileSize = 32;
        mapSize = 30;

        this.player = player;
        this.keyManager = keyManager;
        gameMap = new Map(player, tileSize, mapSize);

        player.setMovement(new Movement(player, gameMap));
    }


    /* Methods */
    public void tick(){
        keyManager.tick();

        if( keyManager.north) {
            player.moveNorth();
        }
        if(keyManager.south){
            player.moveSouth();
        }
        if(keyManager.east){
            player.moveEast();
        }
        if(keyManager.west){
            player.moveWest();
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
