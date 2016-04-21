package models.Item.Weapons;

import models.Item.EquipableItem;
import models.Inventory.Inventory;
import models.Equipment.Equipment;
import models.Item.Requirement;
import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;
import java.util.Map;

import models.Entity.Entity;
import utilities.Location.Location;

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

    public Weapon(double weaponSpeedString,String requiredOccupation, BufferedImage image, int id, String name, double attackRating) {
        super(image, id, name, attackRating);
        requirement = new Requirement(null, 0, requiredOccupation);
        this.weaponSpeed = weaponSpeed;
    }

    public Weapon(double weaponSpeed, String requiredOccupation, int requiredLevel, BufferedImage image, int id, String name, double attackRating) {
        super(image, id, name, attackRating);
        requirement = new Requirement(null, requiredLevel, requiredOccupation);
        this.weaponSpeed = weaponSpeed;

    }

    /* Methods */
    public void equip(Entity entity, Equipment equipment, Inventory inventory) {
        if(requirement.meetsRequirements(entity) == false){
            System.out.println("Can't Equip! You must be a "+ requirement.getRequiredOccupation() + " over level "+ requirement.getRequiredLevel());
            return; //do nothing
        }
        equipment.setEquippedWeapon(this);
        inventory.removeItem(id);
        this.applyRating(entity);
    }

    public void unequip(Entity entity, Equipment equipment, Inventory inventory) {
        equipment.setEquippedWeapon(null);
        inventory.addItem(this);
        this.unapplyRating(entity);
    }


    public void applyRating(Entity entity){
        Map<String , Double > statModifier =  new LinkedHashMap<>();
        statModifier.put("Attack" , this.rating);
        entity.modifyStats(statModifier);
    }

    public void unapplyRating(Entity entity){
        Map<String, Double> statModifier = new LinkedHashMap<>();
        statModifier.put("Attack" , -this.rating);
        entity.modifyStats(statModifier);
    }


}