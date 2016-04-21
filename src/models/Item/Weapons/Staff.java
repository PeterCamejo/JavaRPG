package models.Item.Weapons;

import utilities.Location.Location;
import views.Assets;

import java.awt.image.BufferedImage;

/**
 *   Implemented by Peter Camejo
 *
 *   Staff weaponSpeed = TwoHand weaponSpeed = 1.00;
 *
 *
 */
public class Staff extends Weapon{
    /* Constructors */
    //No level requirement
    public Staff( int id, String name , double attackRating){
        super(1.00 , "Summoner" , Assets.staff, id, name, attackRating);
    }

    //Level requirement
    public Staff(int requiredLevel, int id, String name , double attackRating){
        super(1.00 , "Summoner" , requiredLevel , Assets.staff, id, name, attackRating);
    }
}
