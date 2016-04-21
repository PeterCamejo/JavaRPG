package models.Item.Weapons;

import utilities.Location.Location;

import java.awt.image.BufferedImage;
import views.Assets;

/**
 *   Implemented by Peter Camejo
 *
 *   Fist weaponSpeed = 3.00;
 *   OneHand weaponSpeed = 2.00;
 *   TwoHand weaponSpeed = 1.00;
 */
public class OneHand extends Weapon{
    /* Constructors */
    //No level requirement
    public OneHand( int id,  String name , double attackRating){
        super(2.00 , "Smasher" , Assets.oneHand, id, name, attackRating);
    }

    //Level requirement
    public OneHand(int requiredLevel ,   int id, String name , double attackRating){
        super(2.00 , "Smasher" , requiredLevel , Assets.oneHand, id, name, attackRating);
    }
}