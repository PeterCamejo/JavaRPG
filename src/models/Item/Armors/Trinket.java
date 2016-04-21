package models.Item.Armors;

import models.Entity.Entity;
import models.Equipment.Equipment;
import models.Inventory.Inventory;
import utilities.Location.Location;
import views.Assets;

import java.awt.image.BufferedImage;


/**
 *  Implemented by Peter Camejo
 */
public class Trinket extends Armor {
    /* Constructor */
    public Trinket(){
        super();
    }

    public Trinket( int id,  String name, double rating){
        super(Assets.trinket, id,name ,rating);
    }

    public Trinket( int id,  String name, double rating , int requiredLevel){
        super(Assets.trinket, id,name ,rating , requiredLevel);
    }

    /* Methods */
    public void equip(Entity entity, Equipment equipment , Inventory inventory){
        equipment.addTrinket(this);
        inventory.removeItem(id);
        this.applyRating(entity);
    }

    public void unequip(Entity entity , Equipment equipment, Inventory inventory){
        equipment.removeTrinket();
        inventory.addItem(this);
        this.unapplyRating(entity);
    }
}