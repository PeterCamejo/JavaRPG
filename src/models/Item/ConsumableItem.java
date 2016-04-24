package models.Item;

import java.awt.image.BufferedImage;
import models.Buff.Buff;
import models.Entity.Entity;


/*
* Implemented by Peter Camejo
*/

public class ConsumableItem extends TakeableItem {
    /* Attributes */
    private Buff buff;

    /* Constructor */
    public ConsumableItem(){
        super();
    }

    public ConsumableItem(String statName , double modifier , BufferedImage image , int id, String name , Buff buff){
        super(image, id, name);
        this.buff = buff;
    }

    /* Methods */
    public void use(Entity entity){
        buff.apply(entity.getStats());
        entity.destroyItem(this);
    }

}