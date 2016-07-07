package models;

import models.Entity.Entity;
import models.Map.Map;
import models.Map.Tile.Tile;

/**
 *
 */
public class Movement {
    /* Attributes */
    private Entity entity;
    private Map map;

    /* Constructors */
    public Movement(){
        entity = null;
        map = null;
    }

    public Movement(Entity entity , Map map){
        this.entity = entity;
        this.map = map;
    }

    /* Methods */
    public void move(String direction){
        Location entLocation = entity.getLocation();
        int originalX = (int) entLocation.x;
        int originalY = (int) entLocation.y;
        int hitboxX = 0;
        int hitboxY = 0;
        Tile tempTile;
        int tileSize = map.getTileSize();

        switch(direction){
            case "north":
                entLocation.y -= entity.getMovementSpeed();
                hitboxX = (int) entLocation.x + tileSize/2;
                hitboxY = (int) entLocation.y;
                break;
            case "south":
                entLocation.y += entity.getMovementSpeed();
                hitboxX = (int) entLocation.x + tileSize/2;
                hitboxY = (int) entLocation.y + tileSize;
                break;
            case "east":
                entLocation.x += entity.getMovementSpeed();
                hitboxX = (int) entLocation.x + tileSize;
                hitboxY = (int) entLocation.y + tileSize/2;
                break;
            case "west":
                entLocation.x -= entity.getMovementSpeed();
                hitboxX = (int) entLocation.x ;
                hitboxY = (int) entLocation.y + tileSize/2;
                break;
        }

        tempTile = map.getTileAtLocation(new Location(hitboxX , hitboxY));
        map.test(new Location(hitboxX , hitboxY));

        if(tempTile.receiveEntity(entity)){
            map.clearTileAtLocation(entity.getLocation());
            entity.setLocation(entLocation);
        }else{
            entity.setLocation(new Location(originalX , originalY));
        }

    }


}
