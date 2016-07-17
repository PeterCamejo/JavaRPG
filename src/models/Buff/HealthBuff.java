package models.Buff;

import models.Stat.Stat;

/**
 *  Refers to current Health.
 *
 *  Max Health needs to be buffed with a Stamina buff.
 */
public class HealthBuff extends Buff{
    /* Constructor */
    public HealthBuff(){
        super();
    }

    public HealthBuff(double modifier){
        super(modifier);
    }

    /* Attributes */

    public void apply(Stat stats) {
        stats.modifyHealth(modifier);
    }
}
