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
public class ChestArmor extends Armor {
    /* Constructor */
    public ChestArmor() {
        super();
    }

    public ChestArmor( int id,  String name, double rating , ArrayList<Buff> buffs){
        super(Assets.chestArmor , id, name ,rating , buffs);
    }

    public ChestArmor( int id,  String name, double rating, int requiredLevel , ArrayList<Buff> buffs){
        super(Assets.chestArmor , id, name ,rating , requiredLevel , buffs);
    }

    /* Methods */
    public void equip(Entity entity , Equipment equipment , Inventory inventory){
        equipment.addChest(this);
        inventory.removeItem(id);
        this.applyBuffs(entity);
    }

    public void unequip(Entity entity, Equipment equipment , Inventory inventory){
        equipment.removeChest();
        inventory.addItem(this);
        this.removeBuffs(entity);
    }

}