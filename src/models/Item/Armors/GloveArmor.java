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
public class GloveArmor extends Armor {
    /* Constructor */
    public GloveArmor(){
        super();
    }

    public GloveArmor(int id,  String name, double rating, ArrayList<Buff> buffs){
        super(Assets.gloveArmor , id, name ,rating , buffs);
    }

    public GloveArmor(int id,  String name, double rating , int requiredLevel , ArrayList<Buff> buffs){
        super(Assets.gloveArmor , id, name ,rating , requiredLevel , buffs);
    }

    /* Methods */
    public void equip(Entity entity , Equipment equipment , Inventory inventory){
        equipment.addGloves(this);
        inventory.removeItem(id);
        this.applyBuffs(entity);
    }

    public void unequip(Entity entity , Equipment equipment, Inventory inventory){
        equipment.removeGloves();
        inventory.addItem(this);
        this.removeBuffs(entity);
    }

}