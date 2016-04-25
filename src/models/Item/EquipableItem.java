package models.Item;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import models.Buff.Buff;
import models.Inventory.Inventory;
import models.Equipment.Equipment;
import models.Entity.Entity;


/*
* Implemented by Peter Camejo
*/

public abstract class EquipableItem extends TakeableItem {
    /* Attributes */
    protected double rating; //meant to be armorRating and attackRating respectively.
    protected ArrayList<Buff> buffs;

    /* Constructor */
    public EquipableItem(){
        super();
    }

    public EquipableItem(BufferedImage image , int id, String name , double rating , ArrayList<Buff> buffs){
        super(image, id, name);
        this.rating = rating;
        this.buffs = buffs;
    }

    /* Methods */

    public abstract void equip(Entity entity , Equipment equipment , Inventory inventory);
    public abstract void unequip(Entity entity, Equipment equipment , Inventory inventory);

    public void use(Entity entity){
        entity.equip(this);
    }

    public void applyBuffs(Entity entity){
        for(Buff buff : buffs){
            buff.apply(entity.getStats());
        }
    }

    public void removeBuffs(Entity entity){
        for(Buff buff : buffs){
            buff.negateModifier();
            buff.apply(entity.getStats());
            buff.negateModifier();
        }
    }

    public double getRating(){
        return this.rating;
    }
    public void setRating(double rating){
        this.rating  = rating;
        return;
    }

}