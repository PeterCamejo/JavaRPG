package models.Buff;

import models.Stat.Stat;

/**
 *
 */
public class IntellectBuff extends Buff {
    /* Constructor */
    public IntellectBuff(){
        super();
    }

    public IntellectBuff(double modifier){
        super(modifier);
    }

    /* Methods */
    public void apply(Stat stats) {
        stats.modifyIntellect(this.modifier);
    }
}
