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
public class Fist extends Weapon{
    /* Constructors */
    //No level requirement
    public Fist(int id, String name , double attackRating, ArrayList<Buff> buffs){
        super(3.00 , "Smasher" , Assets.fist , id, name, attackRating , buffs );
    }

    //Level requirement
    public Fist(int requiredLevel ,  int id,  String name , double attackRating , ArrayList<Buff> buffs){
        super(3.00 , "Smasher" , requiredLevel , Assets.fist, id,  name, attackRating , buffs);
    }
}