package models.Buff;

import models.Stat.Stat;

/**
 * Created by The Alex on 4/24/2016.
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
