package models.Item.Weapons;

import models.Buff.Buff;
import views.Assets;

import java.util.ArrayList;

/**
 * Created by The Alex on 7/9/2016.
 */
public class Dagger extends Weapon {
    /* Constructors */
    //No level requirement
    public Dagger( int id,  String name , double attackRating, ArrayList<Buff> buffs){
        super(1.00 , "Rogue" , Assets.dagger, id, name, attackRating , buffs);
    }

    //Level requirement
    public Dagger(int requiredLevel ,   int id, String name , double attackRating, ArrayList<Buff> buffs){
        super(1.00 , "Rogue" , requiredLevel , Assets.dagger, id, name, attackRating, buffs);
    }
}
