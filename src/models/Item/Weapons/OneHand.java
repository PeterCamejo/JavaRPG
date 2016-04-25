package models.Item.Weapons;

import models.Buff.Buff;
import views.Assets;

import java.util.ArrayList;

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
    public OneHand( int id,  String name , double attackRating, ArrayList<Buff> buffs){
        super(2.00 , "Smasher" , Assets.oneHand, id, name, attackRating , buffs);
    }

    //Level requirement
    public OneHand(int requiredLevel ,   int id, String name , double attackRating, ArrayList<Buff> buffs){
        super(2.00 , "Smasher" , requiredLevel , Assets.oneHand, id, name, attackRating, buffs);
    }
}