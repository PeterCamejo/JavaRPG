package models.Entity;


import models.Item.EquipableItem;
import models.Item.TakeableItem;
import models.Map.Tile.*;
import models.SkillContainer.SkillContainer;
import models.Stat.Stat;

import models.Inventory.Inventory;
import models.Equipment.Equipment;


public abstract class Entity{
    /* Attributes */
    protected String name;
    protected String occupation;
    protected Stat stats;
    protected Inventory inventory;
    protected Equipment equipment;
    protected Tile currentTile;
    protected SkillContainer skills;

    /* Constructor */
    public Entity(){
        name = null;
        occupation = null;
        stats = null;
        inventory = null;
        equipment = null;
        currentTile = null;
        skills = null;
    }

    /*** Methods ***/
    /* Inventory */
    public Inventory getInventory(){ return this.inventory;}
    public void dropItem(TakeableItem item){
        currentTile.addItem(inventory.removeItem(item.getId()));
    }
    public void destroyItem(TakeableItem item){
        inventory.removeItem(item.getId());
    }

    /* Stats */
    public Stat getStats(){
        return this.stats;
    }
    public Boolean getGroundMovement(){ return stats.getGroundMovement();}
    public Boolean getWaterMovement(){ return stats.getWaterMovement();}
    public Boolean getAirMovement(){ return stats.getAirMovement();}
    public int getLevel(){ return stats.getLevel();}

    /* Equipment */
    public void equip(EquipableItem item){
        item.equip(this , this.equipment , this.inventory);
    }

    /* Occupation */
    public String getOccupationName(){
        return this.occupation;
    }



}
