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
public class GloveArmor extends Armor {
    /* Constructor */
    public GloveArmor(){
        super();
    }

    public GloveArmor(int id,  String name, double rating){
        super(Assets.gloveArmor , id, name ,rating);
    }

    public GloveArmor(int id,  String name, double rating , int requiredLevel){
        super(Assets.gloveArmor , id, name ,rating , requiredLevel);
    }

    /* Methods */
    public void equip(Entity entity , Equipment equipment , Inventory inventory){
        equipment.addGloves(this);
        inventory.removeItem(id);
        this.applyRating(entity);
    }

    public void unequip(Entity entity , Equipment equipment, Inventory inventory){
        equipment.removeGloves();
        inventory.addItem(this);
        this.unapplyRating(entity);
    }

}