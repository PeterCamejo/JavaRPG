package models.Item.Weapons;

import utilities.Location.Location;
import views.Assets;
import java.awt.image.BufferedImage;

/**
 *   Implemented by Peter Camejo
 *
 *   Fist weaponSpeed = 3.00;
 *   OneHand weaponSpeed = 2.00;
 *   TwoHand weaponSpeed = 1.00;
 */
public class Fist extends Weapon{
    /* Constructors */
    //No level requirement
    public Fist(int id, String name , double attackRating){
        super(3.00 , "Smasher" , Assets.fist , id, name, attackRating);
    }

    //Level requirement
    public Fist(int requiredLevel ,  int id,  String name , double attackRating){
        super(3.00 , "Smasher" , requiredLevel , Assets.fist, id,  name, attackRating);
    }
}