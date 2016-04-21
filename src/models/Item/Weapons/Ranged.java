package models.Item.Weapons;

import utilities.Location.Location;
import views.Assets;

import java.awt.image.BufferedImage;

/**
 *   Implemented by Peter Camejo
 *
 *   Ranged weaponSpeed = OneHand weaponSpeed = 2.00;
 *
 *
 */
public class Ranged extends Weapon{
    /* Constructors */
    //No level requirement
    public Ranged( int id, String name , double attackRating){
        super(2.00 , "Sneak" , Assets.ranged, id,  name, attackRating);
    }

    //Level requirement
    public Ranged(int requiredLevel , int id,  String name , double attackRating){
        super(2.00 , "Sneak" , requiredLevel , Assets.ranged, id, name, attackRating);
    }
}