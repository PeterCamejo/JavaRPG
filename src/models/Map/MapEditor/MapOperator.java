package models.Map.MapEditor;


import models.AreaEffect.AreaEffect;
import models.Decal.*;
import models.Entity.Entity;
import models.Item.Item;
import models.Item.TakeableItem;
import models.Map.*;
import utilities.Load_Save.LoadMap;
import utilities.Location.Location;
import utilities.Observer.entityObserver;
import views.MapView;

import java.util.ArrayList;

/**
 * Created by jcvarela on 4/15/2016.
 */
public class MapOperator {

    private Map map;
    private ArrayList<entityObserver> observers;
    private Location startLocation;

    public MapOperator(int maxRowSize, int maxColSize, int maxHeightSize){
        map = LoadMap.loadMap("res/Map/Map.txt");
        initMap();
        this.observers = new ArrayList<>();
        this.startLocation = new Location(44,0,0);
    }

    public void initMap(){

        int row = map.getRowSize();
        int col = map.getColSize();
        int height = map.getHeightSize();

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                for(int h =0; h < height; h++){

                    Tile tile = map.getTileAt(new Location(r,c,h));
                    map.addTileAt(tile,new Location(r,c,h));
                }
            }
        }
    }


    public boolean addNewEntityAt(Entity entity, Location loc){
        Tile tile = map.getTileAt(loc);
        entity.setLocation(loc);

        if(!tile.hasEntity()){
            tile.addEntity(entity);
            return true;
        }
        return false;
    }
    public boolean addNewAreaEffect(AreaEffect ae, Location loc){
        Tile tile = map.getTileAt(loc);
        ae.setLocation(loc);

        if(!tile.hasAreaEffect()){
            tile.addAreaEffect(ae);
            return true;
        }
        return false;
    }
    public void removeEntity(Entity entity){
        Location loc = entity.getLocation();
        Tile tile = map.getTileAt(loc);

        if(tile != null){
            if(entity.equals(tile.getEntity())){
                tile.removeEntity();
            }
        }
    }

    public MapView getMapView(){
        return new MapView(map);
    }

    public Map getMap() {
        return map;
    }

    public void addEntityObserver(Entity entity) {
        entityObserver eo = new entityObserver(this, entity);
        observers.add(eo);
        entity.addObserver(eo);
    }

    public void handleDeath(entityObserver eo) {
        Entity entity = eo.getEntity();
        double livesRemaining = entity.getLives();
        if (livesRemaining > 0) {
            Location oldLocation = entity.getLocation();
            map.removeEntityAt(oldLocation);
            entity.changeLocation(startLocation);
            Tile startTile = map.getTileAt(startLocation);
            startTile.addEntity(entity);
        } else {
            Location location = entity.getLocation();
            map.removeEntityAt(location);
        }
    }


    public void addItemAt(TakeableItem item,Location loc){
        Tile tile=map.getTileAt(loc);
        if(tile != null){
            tile.addItem(item);
        }
    }
    public Item takeItemAt(Location loc){
        Tile tile = map.getTileAt(loc);
        if(tile != null){
            Item item = tile.getItem();
            tile.removeItem();
            return item;
        }
        return null;
    }

    public void addDecalForTakeDamage(Location location) {
        Decal decal = new TakeDamageDecal();
        map.getTileAt(location).addDecal(decal);
    }

    public void addDecalForInstantDeath(Location location) {
        Decal decal = new InstantDeathDecal();
        map.getTileAt(location).addDecal(decal);
    }

    public void addDecalForTeleport(Location location) {
        Decal decal = new TeleportDecal();
        map.getTileAt(location).addDecal(decal);
    }

    public void addDecalForLevelUp(Location location) {
        Decal decal = new LevelUpDecal();
        map.getTileAt(location).addDecal(decal);
    }

    public void addDecalForGainHealth(Location location) {
        Decal decal = new GainHealthDecal();
        map.getTileAt(location).addDecal(decal);
    }

}
