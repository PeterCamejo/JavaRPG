package models.Item.InteractiveItems;

import models.Entity.Entity;
import models.Item.Item;

import java.awt.image.BufferedImage;

/**
 *
 */
public class Obstacle extends Item {
    /* Attributes */
    protected boolean isPassable;

    /* Constructor */
    public Obstacle(){
        super();
        this.isPassable = false;
    }

    public Obstacle(BufferedImage image, int id, String name){
        super(image, id, name);
        isPassable = false;
    }

    /* Methods */
    public Boolean passable(){
        return this.isPassable;
    }

    public void activate(Entity entity){
        return;
    }
}
