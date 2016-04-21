package models.Item.Armors;

import models.Item.EquipableItem;
import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;
import java.util.Map;
import models.Entity.Entity;
import models.Item.Requirement;
import utilities.Location.Location;


/**
 *  Implemented by Peter Camejo
 *
 *  Class is meant to insure that armor pieces are of the type Armor
 */
public abstract class Armor extends EquipableItem {
    /* Attributes */
    protected Requirement requirement;

    /* Constructor */
    public Armor(){
        super();
        requirement = new Requirement();
    }

    //No Level requirement
    public Armor(BufferedImage image , int id, String name, double rating){
        super(image,id,name,rating);
        requirement = new Requirement();
    }

    public Armor(BufferedImage image , int id, String name, double rating , int requiredLevel){
        super(image,id,name,rating);
        requirement = new Requirement(null , requiredLevel , null);
    }

    public void applyRating(Entity entity){
        Map<String , Double > statModifier =  new LinkedHashMap<>();
        statModifier.put("Armor" , this.rating);
        entity.modifyStats(statModifier);
    }

    public void unapplyRating(Entity entity){
        Map<String, Double> statModifier = new LinkedHashMap<>();
        statModifier.put("Armor" , -this.rating);
        entity.modifyStats(statModifier);
    }

}