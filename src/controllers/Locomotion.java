package controllers;

import models.Entity.Entity;
import models.Map.Map;
import models.Map.Tile;
import utilities.Direction.Direction;
import utilities.Location.Location;

import java.util.HashMap;

/**
 * Created by clayhausen on 4/15/16.
 */
public abstract class Locomotion{

    protected Entity entity;
    protected Map map;

    public Locomotion(Entity entity, Map map) {
        this.entity = entity;
        this.map = map;
    }

    //TODO add description of Locomotion/Terrain interaction
    // Moves Entity one tile forward
    public void move(Direction direction) {

          boolean tileBlocked = false;

        Location currentLocation = entity.getLocation();
        Tile oldTile = map.getTileAt(currentLocation);
        oldTile.removeEntity();

        Location nextLocation = direction.getNextLocation(currentLocation);
        Tile nextTile = map.getTileAt(nextLocation);


        // If Entity attempts to move out of bounds, remove a life and prevent movement
        if ( nextTile == null ) {
            HashMap<String, Double> livesMap = new HashMap<>();
            livesMap.put("CURRENT_LIVES", -1d);
            entity.modifyStats(livesMap);
            tileBlocked = true;
        } else if ( checkForEntities(nextTile) || checkForObstacles(nextTile) ) {
            tileBlocked = true;
        }

        if (!tileBlocked) {
            Terrain terrain = nextTile.getTerrain();
            terrain.moveTo(this);
        }

        updateMap();

        // Check for AreaEffects
        Location finalLocation = entity.getLocation();
        Tile finalTile = map.getTileAt(finalLocation);
        if(checkForAreaEffects(finalTile)){
            System.out.println("AreaEffect should take effect");
            nextTile.activateAreaEffect(entity);
        }

    }

    public void move(Location location) {

        boolean tileBlocked = false;

        Tile nextTile = map.getTileAt(location);

        if ( checkForEntities(nextTile) || checkForObstacles(nextTile) ) { tileBlocked = true; }

        if (!tileBlocked) {
            Terrain terrain = nextTile.getTerrain();
            terrain.moveTo(this);
        }
    }

    public abstract void moveToGround();
    public abstract void moveToMountain();
    public abstract void moveToWater();
    public abstract void moveToAir();


    /** HELPER METHODS **/
    //TODO modify once Map/Obstacle have been implemented
    // Returns true if an Entity is occupying the Tile to be moved to
    private boolean checkForEntities(Tile tile) {

        return tile.hasEntity();

    }

    private boolean checkForAreaEffects(Tile tile){

        return tile.hasAreaEffect();

    }


    //TODO modify once Map/Obstacle have been implemented
    // Returns true if an Obstacle is occupying the Tile to be moved to
    private boolean checkForObstacles(Tile tile) {

        // Guard for map out of bounds
        if (tile == null) { return true; }
        /*
        boolean occupied = true;

            if ( tile.getObstacle == null ) { occupied = false; }
            return occupied;

        */
        return false;
    }


    // Helper methods
    protected void updateEntityLocation() {
        Location oldLocation = entity.getLocation();
        Direction direction = entity.getDirection();
        Location newLocation = direction.getNextLocation(oldLocation);
        entity.changeLocation(newLocation);

    }

    // sync the map with the Entities current location
    protected void updateMap() {
        Location location = entity.getLocation();
        Tile tile = map.getTileAt(location);
        tile.addEntity(entity);
    }


    protected void jumpToLocation(Location newLocation) {
        // Get old and new Locations so we can get the Tiles
        Location oldLocation = entity.getLocation();

        // Remove the Entity from the old Tile
        Tile oldTile = map.getTileAt(oldLocation);
        if (oldTile != null) { oldTile.removeEntity(); }

        // Add the Entity to the new Tile
        Tile newTile = map.getTileAt(newLocation);
        if (newTile != null) {
            entity.changeLocation(newLocation);
            newTile.addEntity(entity);
        }
    }



}
