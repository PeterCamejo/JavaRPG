package models.Item.Armors;

import models.Buff.Buff;
import models.Entity.Entity;
import models.Equipment.Equipment;
import models.Inventory.Inventory;
import views.Assets;

import java.util.ArrayList;


/**
 *  Implemented by Peter Camejo
 */
public class LegArmor extends Armor {
    /* Constructor */
    public LegArmor(){
        super();
    }

    public LegArmor( int id,  String name, double rating , ArrayList<Buff> buffs){
        super(Assets.legArmor, id, name ,rating , buffs);
    }

    public LegArmor( int id,  String name, double rating , int requiredLevel , ArrayList<Buff> buffs){
        super(Assets.legArmor, id, name ,rating , requiredLevel , buffs);
    }

    /* Methods */
    public void equip(Entity entity , Equipment equipment, Inventory inventory){
        equipment.addLegs(this);
        inventory.removeItem(id);
        this.applyBuffs(entity);
    }

    public void unequip(Entity entity ,Equipment equipment, Inventory inventory){
        equipment.removeLegs();
        inventory.addItem(this);
        this.removeBuffs(entity);
    }

}