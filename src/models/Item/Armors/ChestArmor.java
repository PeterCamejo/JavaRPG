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
public class ChestArmor extends Armor {
    /* Constructor */
    public ChestArmor(){
        super(Assets.chestArmor,1,"Chess Armor", 5,1);
    }

    public ChestArmor( int id,  String name, double rating){
        super(Assets.chestArmor , id, name ,rating);
    }

    public ChestArmor( int id,  String name, double rating, int requiredLevel){
        super(Assets.chestArmor , id, name ,rating , requiredLevel);
    }

    /* Methods */
    public void equip(Entity entity , Equipment equipment , Inventory inventory){
        equipment.addChest(this);
        inventory.removeItem(id);
        this.applyRating(entity);
    }

    public void unequip(Entity entity, Equipment equipment , Inventory inventory){
        equipment.removeChest();
        inventory.addItem(this);
        this.unapplyRating(entity);
    }

}