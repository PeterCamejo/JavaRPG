package models.Item;

import models.Entity.Entity;

import java.awt.image.BufferedImage;

/**
 *  Implemented by Peter Camejo
 *
 *  Need a concrete Takeable subtype that was not consumable and not equippable (e.g. Keys).
 *
 *  Also can't pass up chance for a Pokemon Easter Egg.
 */
public class MiscItem extends TakeableItem{
    /* Constructor */
    public MiscItem(){
        super();
    }

    public MiscItem(BufferedImage image, int id , String name){
        super(image, id, name);
    }

    /* Methods */
    public void use(Entity entity){
        System.out.println("OAK : Red, there is a time and place for everything. But not now.");
        return; //do nothing
    }

}