package models.Item;

/*
* Implemented by Peter Camejo
*/

import models.Buff.Buff;
import models.Entity.Entity;

import java.awt.image.BufferedImage;

public class OneShot extends Item {
    /* Attributes */
    private Buff buff;

    /* Constructor */
    public OneShot(){
        super();
    }

    public OneShot(BufferedImage image,  int id, String name, Buff buff){
        super(image, id, name);
        this.buff = buff;
    }

    /* Methods */
    public void activate(Entity entity){
        buff.apply(entity.getStats());
    }

}
