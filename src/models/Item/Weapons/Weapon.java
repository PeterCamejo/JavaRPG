package models.Item.Weapons;

import models.Buff.Buff;
import models.Buff.WeaponBuff;
import models.Item.EquipableItem;
import models.Inventory.Inventory;
import models.Equipment.Equipment;
import models.Item.Requirement;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import models.Entity.Entity;

/**
 *  Implemented by Peter Camejo
 */
public class Weapon extends EquipableItem {
    /* Attributes */
    protected Requirement requirement;
    protected double weaponSpeed;

    /* Constructor */
    public Weapon() {
        super();
        requirement = new Requirement();
    }

    public Weapon(double weaponSpeed,String requiredOccupation, BufferedImage image, int id, String name, double attackRating , ArrayList<Buff> buffs) {
        super(image, id, name, attackRating , buffs);
        requirement = new Requirement(null, 0, requiredOccupation);
        this.weaponSpeed = weaponSpeed;
        buffs.add(new WeaponBuff(attackRating));
    }

    public Weapon(double weaponSpeed, String requiredOccupation, int requiredLevel, BufferedImage image, int id, String name, double attackRating , ArrayList<Buff> buffs) {
        super(image, id, name, attackRating, buffs);
        requirement = new Requirement(null, requiredLevel, requiredOccupation);
        this.weaponSpeed = weaponSpeed;
        buffs.add(new WeaponBuff(attackRating));

    }

    /* Methods */
    public void equip(Entity entity, Equipment equipment, Inventory inventory) {
        if(requirement.meetsRequirements(entity) == false){
            System.out.println("Can't Equip! You must be a "+ requirement.getRequiredOccupation() + " over level "+ requirement.getRequiredLevel());
            return; //do nothing
        }
        if(equipment.setEquippedWeapon(this)) {
            inventory.removeItem(id);
            this.applyBuffs(entity);
        }
    }

    public void unequip(Entity entity, Equipment equipment, Inventory inventory) {
       if(inventory.addItem(this)){
           equipment.clearEquippedWeapon();
           this.removeBuffs(entity);
       }


    }




}