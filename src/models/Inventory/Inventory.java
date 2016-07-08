package models.Inventory;

import models.Entity.Entity;
import models.Item.TakeableItem;
import models.ItemContainer.ItemContainer;

import java.awt.image.BufferedImage;

/*
* Implemented by Peter Camejo
*/

public class Inventory implements ItemContainer {

    /* Attributes */
    public int size;
    private TakeableItem[] items;
    private int goldAmount;


    /* Constructors */
    public Inventory(){
        size = DEFAULT_SIZE;
        items = new TakeableItem[DEFAULT_SIZE];
        goldAmount = 0;
    }

    public Inventory(int goldAmount){
        size = DEFAULT_SIZE;
        items = new TakeableItem[DEFAULT_SIZE];
        this.goldAmount = goldAmount;
    }

    public Inventory(int size , int goldAmount){
        this.size = size;
        items = new TakeableItem[size];
        this.goldAmount = goldAmount;
    }

    /* Methods */

    public boolean addItem(TakeableItem item) {

        for(int i = 0; i < size; i++){
            if(items[i] == null){
                items[i] = item;
                return true;
            }
        }

        System.out.println("Take Item failed: Inventory full.");

        return false;
    }

    public boolean isFull(){
        for(int i = 0; i < size; i++){
            if(items[i] == null){
                return false;
            }
        }
        return true;
    }

    public TakeableItem removeItem(int id){
        TakeableItem itemCopy = null;

        for(int i = 0; i < size; i++){
            if(items[i]!= null) {
                if (items[i].getId() == id) {
                    itemCopy = items[i];
                    items[i] = null;
                }
            }
        }
        if(itemCopy == null){
            System.out.println("Remove models.Item failed: models.Item not found");
        }

        return itemCopy;
    }

    public TakeableItem removeItemByIndex(int index){
        TakeableItem itemCopy  = items[index];
        items[index] = null;
        return itemCopy;
    }

    public void useItemByIndex(int index , Entity entity){
        if(items[index] != null){
            items[index].use(entity);
        }
    }

    public Boolean hasItemInstance(int id){
        for(int i = 0 ; i < size; i++){
            if(items[i].getId() == id){
                return true;
            }
        }
        return false;
    }

    public TakeableItem getItemByIndex(int index){
        return items[index];
    }
    public BufferedImage getItemImageByIndex(int index){
        if(items[index] != null){
            return items[index].getImage();
        }else{
            return null;
        }
    }

    public void addGold(int amount){
        goldAmount += amount;
        return;
    }

    public Boolean removeGold(int amount){
        if((goldAmount - amount) < 0){  //Make sure goldAmount never goes below 0;
            return false;   //Do nothing ; return that operation failed.
        }

        goldAmount -= amount;   //else perform operation
        return true;            // and return that operation succeeded.
    }

    public int getGold(){
        return goldAmount;
    }
    public int getSize(){ return size;}
}