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
public class Trinket extends Armor {
    /* Constructor */
    public Trinket(){
        super();
    }

    public Trinket( int id,  String name, double rating , ArrayList<Buff> buffs){
        super(Assets.trinket, id,name ,rating , buffs);
    }

    public Trinket( int id,  String name, double rating , int requiredLevel ,ArrayList<Buff> buffs){
        super(Assets.trinket, id,name ,rating , requiredLevel, buffs);
    }

    /* Methods */
    public void equip(Entity entity, Equipment equipment , Inventory inventory){
        equipment.addTrinket(this);
        inventory.removeItem(id);
        this.applyBuffs(entity);
    }

    public void unequip(Entity entity , Equipment equipment, Inventory inventory){
        equipment.removeTrinket();
        inventory.addItem(this);
        this.removeBuffs(entity);
    }
}