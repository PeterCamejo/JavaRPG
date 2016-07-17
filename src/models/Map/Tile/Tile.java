package models.Map.Tile;

import models.AreaEffect.AreaEffect;
import models.Entity.Entity;
import models.Item.Item;
import models.Item.TakeableItem;
import models.Location;
import views.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

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
    protected BufferedImage image;
    protected int areaEffectBuffer;

    /* Constructor */
    public Tile(){
        entity = null;
        item = null;
        areaEffect = null;
        tileSize = 0;
        areaEffectBuffer = 0;
    }


    public Tile(Entity entity , TakeableItem item , AreaEffect areaEffect , Location location, int tileSize){
        this.entity  = entity;
        this.item = item;
        this.areaEffect = areaEffect;
        this.location = location;
        this.tileSize = tileSize;
        areaEffectBuffer = 0;

    }

    /* Methods */
    public abstract boolean isPassable();
    public abstract Boolean receiveEntity(Entity entity);
    public abstract void render(Graphics g);

    public void tick(){
        if(entity != null) {
            if (areaEffect != null) {
                if(areaEffectBuffer == 75) {
                    areaEffect.activate(entity);
                    areaEffectBuffer = 0;
                }else {
                    areaEffectBuffer++;
                }
            }

        }
    }

    public boolean addItem(Item item){
        if(this.item == null){
            this.item = item;
            return true;
        }

        System.out.println("Can't drop that. There is already an item in this tile!");
        return false; //do nothing
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
    public BufferedImage getImage(){ return image;}

}
