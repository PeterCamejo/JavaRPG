package models.Item.InteractiveItems;

/*
* Implemented by Peter Camejo
*/

import models.Entity.Entity;
import models.Item.Requirement;

import java.awt.image.BufferedImage;

public class Door extends InteractiveItem {
    /* Constructor */
    public Door(){
        super();
    }

    public Door(int id, String name , Requirement requirement){
        super(/*Assest.door*/ , id , name , requirement);
    }

    /* Methods */
    public void passReqActivation(Entity entity){
         this.image = /* Same as background */;
    }
}
