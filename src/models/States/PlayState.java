package models.States;

import input.KeyManager;
import input.MenuKeyManager;
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

    public PlayState(Avatar player) {
        tileSize = 80;
        mapSize = 10;

        this.player = player;
        this.keyManager = new PlayKeyManager();
        gameMap = new Map(player, tileSize, mapSize);

        player.setMovement(new Movement(player, gameMap));

}


    /* Methods */
    public void tick(){
        keyManager.tick();
        gameMap.tick();
           if (keyManager.north) {
               player.moveNorth();
           }
           if (keyManager.south) {
               player.moveSouth();
           }
           if (keyManager.east) {
               player.moveEast();
           }
           if (keyManager.west) {
               player.moveWest();
           }
           if (keyManager.inventory) {
               GameStateManager.setState(new InventoryState(new MenuKeyManager(), this));
           }
           if (keyManager.equipment) {
               GameStateManager.setState(new EquipmentState(this));
           }


    }

    public void render(Graphics g){
        gameMap.render(g);
        player.render(g);
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
    public Avatar getPlayer(){ return player;}
}
