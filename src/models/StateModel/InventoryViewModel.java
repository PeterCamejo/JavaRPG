package models.StateModel;

import models.Entity.Entity;
import models.Equipment.Equipment;
import models.Inventory.Inventory;
import models.Item.TakeableItem;
import utilities.Location.Location;
import utilities.State.State;
import models.Map.Map;

import java.awt.image.BufferedImage;

/**
 * Implemented by Peter Camejo
 */
public class InventoryViewModel{

    private Entity entity;
    private Inventory inventory;
    private Equipment equipment;
    private int goldAmount;
    private Map map;
    int index;


    public InventoryViewModel(Entity entity, Map map){
        this.entity = entity;
        inventory = entity.getInventory();
        equipment = entity.getEquipment();
        index = 0;
        this.map = map;
    }



    public State nextState() {
        return null;
    }

    public void update() {
        /*int count = 0;
        items[0] = equipment.getHead();
        items[1] = equipment.getChest();
        items[2] = equipment.getGloves();
        items[3] = equipment.getLegs();
        items[4] = equipment.getBoots();
        items[5] = equipment.getTrinket();
        items[6] = equipment.getWeapon();

        for(int i = 7; i < 22; i++){
            items[i] = inventory.getItemByIndex(count++);
        }

        goldAmount = inventory.getGold();
        currentItem = items[index];
        System.out.println( " Current index: " + index);*/
    }

    public void up(){
        if(index > 4){ //Index is in Inventory portion.
            index = index - 5;
        }else{ //Index is in Equipment portion.
            index = inventory.size - (5 - index);
        }
    }


    public void down(){
        index = (index +5)%(inventory.size);
    }

    public void right(){
        index = (index/5)*5 +  (index + 1)%5;
    }

    public void left(){
        index = (index/5)*5 + (index - 1)%5;
        if(index < 0)
            index = 4;
    }

    public void select(){

    }

    public TakeableItem getCurrentItem(){
        return inventory.getItemByIndex(index);
    }

    public BufferedImage getItemImageAt(int index){
        if(inventory.getItemByIndex(index) == null)
            return null;
        return inventory.getItemByIndex(index).getImage();
    }

    public int getCurrentIndex(){
        return this.index;
    }

    public int getInventorySize(){
        return  inventory.size;
    }

    public void dropItem(){
        TakeableItem item = inventory.getItemByIndex(index);
        if(item != null){
            inventory.removeItemByIndex(index);
            Location loc =entity.getLocation();
            map.getTileAt(loc).addItem(item);
        }
    }
}