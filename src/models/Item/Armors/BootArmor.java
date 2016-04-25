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
public class BootArmor extends Armor{
    /* Constructor */
    public BootArmor(){
        super();
    }

    public BootArmor( int id, String name, double rating , ArrayList<Buff> buffs){
        super(Assets.bootArmor , id, name ,rating , buffs);
    }

    public BootArmor( int id, String name, double rating , int requiredLevel , ArrayList<Buff> buffs){
        super(Assets.bootArmor , id, name ,rating ,requiredLevel , buffs);
    }

    /* Methods */
    public void equip(Entity entity, Equipment equipment, Inventory inventory){
        equipment.addBoots(this);
        inventory.removeItem(id);
        this.applyBuffs(entity);
    }

    public void unequip(Entity entity, Equipment equipment, Inventory inventory){
        equipment.removeBoots();
        inventory.addItem(this);
        this.removeBuffs(entity);
    }


}