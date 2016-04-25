package models.Item.Weapons;

import models.Buff.Buff;
import views.Assets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *   Implemented by Peter Camejo
 *
 *   Fist weaponSpeed = 3.00;
 *   OneHand weaponSpeed = 2.00;
 *   TwoHand weaponSpeed = 1.00;
 */
public class TwoHand extends Weapon{
    /* Constructors */
    //No level requirement
    public TwoHand( int id, String name , double attackRating, ArrayList<Buff> buffs){
        super(1.00 , "Smasher" , Assets.twoHand , id,  name, attackRating,buffs );
    }

    //Level requirement
    public TwoHand(int requiredLevel , int id,  String name , double attackRating, ArrayList<Buff> buffs){
        super(1.00 , "Smasher" , requiredLevel , Assets.twoHand, id, name, attackRating , buffs);
    }
}