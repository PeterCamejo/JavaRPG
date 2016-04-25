package models.Item.Weapons;

import models.Buff.Buff;
import views.Assets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
    public Staff( int id, String name , double attackRating , ArrayList<Buff> buffs){
        super(1.00 , "Summoner" , Assets.staff, id, name, attackRating , buffs);
    }

    //Level requirement
    public Staff(int requiredLevel, int id, String name , double attackRating, ArrayList<Buff> buffs){
        super(1.00 , "Summoner" , requiredLevel , Assets.staff, id, name, attackRating , buffs);
    }
}
