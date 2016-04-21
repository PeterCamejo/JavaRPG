package models.Item;

import java.awt.image.BufferedImage;
import models.Entity.Entity;
import utilities.Location.Location;


/*
* Implemented by Peter Camejo
*/
public abstract class Item {
    /* Attributes */
    protected BufferedImage image;
    protected int id;
    protected String name;

    /* Constructors */
    protected Item(){
        this.image = null;
        this.id = -1;
        this.name = null;
    }
    protected Item(BufferedImage image, int id, String name){
        this.image = image;
        this.id = id;
        this.name = name;
    }

    /* Methods */
    public abstract void activate(Entity entity);

    //TODO: add gets/sets as needed.
    public int getId(){
        return this.id;
    }
    public BufferedImage getImage (){ return this.image;}
    public String getName(){ return this.name;}

}