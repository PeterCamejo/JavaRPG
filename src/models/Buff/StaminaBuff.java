package models.Buff;

import models.Stat.Stat;

/**
 *
 */
public class StaminaBuff extends Buff {
    /* Constructor */
    public StaminaBuff(){
        super();
    }

    public StaminaBuff(double modifier){
        super(modifier);
    }

    /* Methods */
    public void apply(Stat stats){
        stats.modifyStamina(modifier);
    }
}
