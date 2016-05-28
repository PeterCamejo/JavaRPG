package models.Map.Tile;

import models.AreaEffect.AreaEffect;
import models.Entity.Entity;
import models.Item.InteractiveItems.Obstacle;
import models.Item.Item;
import models.Item.TakeableItem;
import models.Location;
import models.Map.Hexagon;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 */
public abstract class Tile {
    /* Attributes */
    protected int height;
    protected Tile bottomTile;
    protected Tile topTile;
    protected Tile northTile;
    protected Tile southTile;
    protected Tile southEastTile;
    protected Tile northEastTile;
    protected Tile southWestTile;
    protected Tile northWestTile;

    protected Entity entity;
    protected Item item;
    protected AreaEffect areaEffect;

    protected Hexagon hexagon;
    protected Location location;

    /* Constructor */
    public Tile(){
        height = 1;
        bottomTile = topTile = northTile =southTile = southEastTile =southWestTile = northEastTile = northWestTile = null;
        entity = null;
        item = null;
        areaEffect = null;
    }

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

    public Tile(Entity entity , TakeableItem item , AreaEffect areaEffect , Location location){
        this.entity  = entity;
        this.item = item;
        this.areaEffect = areaEffect;
        this.location = location;

        hexagon = new Hexagon(location , 20);
    }

    /* Methods */
    /*
    public abstract void sendEntityNorth();
    public abstract void sendEntitySouth();
    public abstract void sendEntitySouthEast();
    public abstract void sendEntitySouthWest();
    public abstract void sendEntityNorthEast();
    public abstract void sendEntityNorthWest();
    */
    public abstract Boolean receiveEntity(Entity entity);
    public abstract void render(Graphics g);

    public int getHeight(){
        return this.height;
    }

    public void update(){
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

}
