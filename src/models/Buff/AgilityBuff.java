package models.Buff;

import models.Stat.Stat;

/**
 *
 */
public class AgilityBuff extends Buff {
    /* Constructor */
    public AgilityBuff(){
        super();
    }

    public AgilityBuff(double modifier){
        super(modifier);
    }

    /* Methods */
    public void apply(Stat stats){
        stats.modifyAgility(this.modifier);
    }
}
