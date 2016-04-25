package models.Item.Armors;

import models.Buff.ArmorBuff;
import models.Buff.Buff;
import models.Item.EquipableItem;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import models.Item.Requirement;



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
    public Armor(BufferedImage image , int id, String name, double rating, ArrayList<Buff> buffs){
        super(image,id,name,rating , buffs);
        requirement = new Requirement();
        buffs.add(new ArmorBuff(rating));
    }

    public Armor(BufferedImage image , int id, String name, double rating , int requiredLevel , ArrayList<Buff> buffs){
        super(image,id,name,rating , buffs);
        requirement = new Requirement(null , requiredLevel , null);
        buffs.add(new ArmorBuff(rating));
    }


}