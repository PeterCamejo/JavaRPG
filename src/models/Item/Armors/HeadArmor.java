package models.Item.Armors;


import models.Buff.Buff;
import models.Entity.Entity;
import models.Inventory.Inventory;
import models.Equipment.Equipment;
import views.Assets;

import java.util.ArrayList;


/**
 *  Implemented by Peter Camejo
 */
public class HeadArmor extends Armor{
    /*Constructors*/
    public HeadArmor() {
        super();
    }

    public HeadArmor(int id, String name, double rating , ArrayList<Buff> buffs){
        super(Assets.headArmor, id,  name ,rating , buffs);
    }

    public HeadArmor(int id, String name, double rating , int requiredLevel , ArrayList<Buff> buffs){
        super(Assets.headArmor, id,  name ,rating , requiredLevel , buffs);
    }


    /* Methods */
    public void equip(Entity entity, Equipment equipment , Inventory inventory) {
        /*
        if(equipment.hasHead()){
            equipment.getHead().unequip(equipment , inventory); //NOT OOP. Should probably do this within models.Equipmen
        }
        */
        equipment.addHead(this);
        inventory.removeItem(id);
        this.applyBuffs(entity);
    }

    public void unequip(Entity entity, Equipment equipment, Inventory inventory) {
        inventory.addItem(this);
        equipment.removeHead();
        this.removeBuffs(entity);
    }

}