package models.Item;

import models.Entity.Entity;
import models.Inventory.Inventory;

/**
 *  Implemented by Peter Camejo
 */
public class Requirement {
    /* Attributes */
    private TakeableItem requiredItem;
    private int requiredLevel;
    private String requiredOccupation;

    /* Constructors */
    public Requirement(){
        this.requiredItem = null;
        this.requiredLevel = 0;
        this.requiredOccupation = null;
    }

    public Requirement(TakeableItem requiredItem , int requiredLevel , String requiredOccupation){
        this.requiredItem = requiredItem;
        this.requiredLevel = requiredLevel;
        this.requiredOccupation = requiredOccupation;
    }

    /* Methods */
    public Boolean hasItem(Inventory inventory){
        if(requiredItem == null){
            return true;
        }
        return inventory.hasItemInstance(requiredItem.getId());
    }

    public Boolean hasLevel(Entity entity){
        return (int)entity.getLevel() >= requiredLevel;
    }

    public Boolean hasOccupation(Entity entity){
        if(requiredOccupation == null){
            return true;
        }
        return entity.occupationName() == requiredOccupation;
    }

    public Boolean meetsRequirements(Entity entity){
        return hasOccupation(entity) && hasLevel(entity) && hasItem(entity.getInventory());
    }

    public String getRequiredOccupation(){
        return this.requiredOccupation;
    }

    public int getRequiredLevel(){
        return this.requiredLevel;
    }

    public String getRequiredItemName(){ return this.requiredItem.getName();}

}