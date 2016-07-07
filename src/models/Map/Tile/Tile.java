package models.Map.Tile;

import models.AreaEffect.AreaEffect;
import models.Entity.Entity;
import models.Item.Item;
import models.Item.TakeableItem;
import models.Location;

import java.awt.*;

/**
 *
 */
public abstract class Tile {
    /* Attributes */
    protected int tileSize;


    protected Entity entity;
    protected Item item;
    protected AreaEffect areaEffect;


    protected Location location;

    /* Constructor */
    public Tile(){
        entity = null;
        item = null;
        areaEffect = null;
        tileSize = 0;
    }
/*
    public Tile(Tile bottomTile , Tile topTile , Tile northTile , Tile southTile , Tile southEastTile , Tile southWestTile , Tile northEastTile , Tile northWestTile , Entity entity , TakeableItem item , AreaEffect areaEffect){
        this.bottomTile = bottomTile;
        this.topTile = topTile;
        this.northTile = northTile;
        this.southTile = southTile;
        this.southEastTile = southEastTile;
        this.southWestTile = southWestTile;
        this.northEastTile = northEastTile ;
        this.northEastTile = northWestTile;

        this.entity  = entity;
        this.item = item;
        this.areaEffect = areaEffect;

        location = null;

        if(bottomTile != null){
            this.height = bottomTile.getHeight() + 1;
        }else{
            this.height = 1;
        }
    }
    */

    public Tile(Entity entity , TakeableItem item , AreaEffect areaEffect , Location location, int tileSize){
        this.entity  = entity;
        this.item = item;
        this.areaEffect = areaEffect;
        this.location = location;
        this.tileSize = tileSize;

    }

    /* Methods */
    public abstract boolean isPassable();
    public abstract Boolean receiveEntity(Entity entity);
    public abstract void render(Graphics g);

    public void tick(){
        if(entity != null) {
            if (areaEffect != null) {
                areaEffect.activate(entity.getStats());
            }

        }
    }

    public void addItem(Item item){
        if(this.item == null){
            this.item = item;
            return;
        }

        System.out.print("Can't drop that. There is already an item in this tile!");
        return; //do nothing
    }

    public Location getLocation(){
        return location;
    }

    public void clearEntity(){
        this.entity = null;
    }

    public void setItem(Item item){
        this.item = item;
    }

}
