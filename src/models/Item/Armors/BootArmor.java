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
public class BootArmor extends Armor{
    /* Constructor */
    public BootArmor(){
        super();
    }

    public BootArmor( int id, String name, double rating){
        super(Assets.bootArmor , id, name ,rating);
    }

    public BootArmor( int id, String name, double rating , int requiredLevel){
        super(Assets.bootArmor , id, name ,rating ,requiredLevel);
    }

    /* Methods */
    public void equip(Entity entity, Equipment equipment, Inventory inventory){
        equipment.addBoots(this);
        inventory.removeItem(id);
        this.applyRating(entity);
    }

    public void unequip(Entity entity, Equipment equipment, Inventory inventory){
        equipment.removeBoots();
        inventory.addItem(this);
        this.unapplyRating(entity);
    }


}