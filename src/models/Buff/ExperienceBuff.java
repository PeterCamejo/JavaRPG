package models.Buff;

import models.Stat.Stat;

/**
 *
 */
public class ExperienceBuff extends Buff {
    /* Constructor */
    public ExperienceBuff(){
        super();
    }

    public ExperienceBuff(double modifier){
        super(modifier);
    }

    /* Methods */
    public void apply(Stat stats){
        stats.modifyExperience(this.modifier);
    }
}
