package models.Entity;


import models.Item.EquipableItem;
import models.Item.TakeableItem;
import models.Location;
import models.Map.Tile.*;

import models.Stat.Stat;

import models.Inventory.Inventory;
import models.Equipment.Equipment;
import views.Assets;

import java.awt.*;


public abstract class Entity{
    /* Attributes */
    protected String name;
    protected String occupation;
    protected Stat stats;
    protected Inventory inventory;
    protected Equipment equipment;
    protected Tile currentTile;
    protected Location location;


    /* Constructor */
    public Entity(){
        name = "";
        occupation = "";
        stats = new Stat();
        inventory = new Inventory();
        equipment = new Equipment();
        currentTile = new GroundTile();
        location = new Location();

    }

    public Entity(String name , String occupation , Stat stats, Inventory inventory , Equipment equipment , Tile currentTile , Location location){
        this.name = name;
        this.occupation = occupation;
        this.stats = stats;
        this.inventory = inventory;
        this.equipment = equipment;
        this.currentTile = currentTile;
        this.location = location;
    }

    /*** Methods ***/
    /* Inventory */
    public Inventory getInventory(){ return this.inventory;}
    public void addItem(TakeableItem item){ inventory.addItem(item);}
    public void dropItem(TakeableItem item){
        currentTile.addItem(inventory.removeItem(item.getId()));
    }
    public void destroyItem(int id){inventory.removeItem(id);}

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

    /* Loop */
    public void render(Graphics g){
        g.drawImage(Assets.healthPotion, (int) location.getX() , (int) location.getY() , null);
    }

    public void tick(){

    }

    /* Movement */
    public void moveNorth(){currentTile.sendEntityNorth();}
    public void moveNorthEast(){currentTile.sendEntityNorthEast();}
    public void moveNorthWest(){currentTile.sendEntityNorthWest();}
    public void moveSouth(){ currentTile.sendEntitySouth();}
    public void moveSouthEast(){ currentTile.sendEntitySouthEast();}
    public void moveSouthWest(){ currentTile.sendEntitySouthWest();}

    /* Test Movement */
    public void testUp(){ location.modifyY(3);}
    public void testDown(){ location.modifyY(-3);}



}
