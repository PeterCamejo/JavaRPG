package models.Item.Weapons;

import models.Buff.Buff;
import views.Assets;

import java.util.ArrayList;

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
    public Ranged( int id, String name , double attackRating, ArrayList<Buff> buffs){
        super(2.00 , "Sneak" , Assets.ranged, id,  name, attackRating , buffs);
    }

    //Level requirement
    public Ranged(int requiredLevel , int id,  String name , double attackRating , ArrayList<Buff> buffs){
        super(2.00 , "Sneak" , requiredLevel , Assets.ranged, id, name, attackRating , buffs);
    }
}