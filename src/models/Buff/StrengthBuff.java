package models.Buff;

import models.Stat.Stat;

/**
 *
 */
public class StrengthBuff extends Buff {
    /* Constructor */
    public StrengthBuff(){
        super();
    }

    public StrengthBuff(double modifier){
        super(modifier);
    }

    /* Methods */
    public void apply(Stat stats){
        stats.modifyStrength(this.modifier);
    }
}
