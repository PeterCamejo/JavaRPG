package models.Entity;


import models.Item.TakeableItem;
import models.Map.Tile;
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



}
