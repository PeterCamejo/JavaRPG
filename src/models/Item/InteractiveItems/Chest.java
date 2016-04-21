package models.Item.InteractiveItems;

/*
* Implemented by Peter Camejo
*/

import models.Entity.Entity;
import models.Inventory.Inventory;
import models.Item.TakeableItem;

import java.awt.image.BufferedImage;

public class Chest extends InteractiveItem{
    /* Attributes */
    private Inventory inventory;

    /* Constructors */
    public Chest(){
        super();
        inventory = new Inventory(3);
    }

    public Chest(BufferedImage image, int id, String name , TakeableItem requiredItem , TakeableItem[] loot , int goldAmount){
        super(image, id, name, requiredItem);
        inventory = new Inventory(3);
        for(int i = 0 ; i < 3; i++) {
            inventory.addItem(loot[i]);
        }
        inventory.addGold(goldAmount);
    }

    /* Methods */
    public void passReqActivation(Entity entity) {
        for(int i = 0; i < 3; i++){
            entity.addItem(inventory.removeItemByIndex(i));
        }

        entity.destroyItem(32); // Destroy a Chest Key
    }
}