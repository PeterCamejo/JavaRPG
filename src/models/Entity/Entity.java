package models.Entity;


import models.Item.EquipableItem;
import models.Item.Item;
import models.Item.TakeableItem;
import models.Location;
import models.Map.Tile.*;

import models.Movement;
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
    protected Movement movement;


    /* Constructor */
    public Entity(){
        name = "";
        occupation = "Smasher";
        stats = new Stat();
        inventory = new Inventory();
        equipment = new Equipment();
        currentTile = new GroundTile();
        location = new Location();
        movement = new Movement();

    }

    public Entity(String name , String occupation , Stat stats){
        this.name = name;
        this.occupation = occupation;
        this.stats = stats;
        inventory = new Inventory();
        equipment = new Equipment();
        currentTile = new GroundTile();
        location = new Location();
        movement = new Movement();
    }

    public Entity(String name , String occupation , Stat stats, Inventory inventory , Equipment equipment , Tile currentTile , Location location , Movement movement){
        this.name = name;
        this.occupation = occupation;
        this.stats = stats;
        this.inventory = inventory;
        this.equipment = equipment;
        this.currentTile = currentTile;
        this.location = location;
        this.movement = movement;
    }

    /*** Methods ***/
    /* Inventory */
    public Inventory getInventory(){ return this.inventory;}

    public void dropItem(TakeableItem item ,int index){
        if(item != null){
            if(currentTile.addItem(item)){
                inventory.removeItemByIndex(index);
            }
        }
    }
    private void placeItem(Item item){ currentTile.addItem(item);}
    public void destroyItem(int id){inventory.removeItem(id);}
    public void addItem(TakeableItem item){
        if(inventory.addItem(item)){
            currentTile.setItem(null);
        }
    }

    /* Stats */
    public Stat getStats(){
        return this.stats;
    }
    public Boolean getGroundMovement(){ return stats.getGroundMovement();}
    public Boolean getWaterMovement(){ return stats.getWaterMovement();}
    public Boolean getAirMovement(){ return stats.getAirMovement();}
    public int getLevel(){ return stats.getLevel();}
    public double getMovementSpeed(){ return stats.getMovement();}

    /* Equipment */
    public void equip(EquipableItem item){
        item.equip(this , this.equipment , this.inventory);
    }
    public Equipment getEquipment(){ return equipment;}

    /* Occupation */
    public String getOccupationName(){
        return this.occupation;
    }


    public void render(Graphics g){
        g.drawImage(Assets.healthPotion, (int) location.getX() , (int) location.getY() , null);
    }

    public void tick(){

    }

    /* Movement and Location */
    public void moveNorth(){movement.move("north");}
    public void moveSouth(){movement.move("south");}
    public void moveEast(){movement.move("east");}
    public void moveWest(){movement.move("west");}
    public Location getLocation(){ return location;}
    public void setLocation(Location location){ this.location = location;}
    public void setMovement(Movement movement){ this.movement = movement;}
    public void setCurrentTile(Tile tile){ this.currentTile = tile;}
    public Location getCenter(){
        int x =(int) location.getX() + 40;
        int y = (int) location.getY() + 40;
        return new Location(x, y);
    }



}
