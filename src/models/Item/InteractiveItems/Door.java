package models.Item.InteractiveItems;

/*
* Implemented by Peter Camejo
*/

import models.Entity.Entity;
import models.Item.ItemFactory;
import models.Item.Requirement;
import views.Assets;

import java.awt.image.BufferedImage;

public class Door extends InteractiveItem {
    /* Constructor */
    public Door(){
        super();
    }

    public Door(int id){
        super(Assets.door, id , "Door" , ItemFactory.getDoorKey());
    }

    /* Methods */
    public void passReqActivation(Entity entity){
         this.image = /* Same as background */;
    }
}
