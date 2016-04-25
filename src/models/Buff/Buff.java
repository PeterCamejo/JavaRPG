package models.Buff;

import models.Stat.Stat;

/**
 *
 */
public abstract class Buff {
    /* Attributes */
    protected double modifier;

    /* Constructor */
    public Buff(){
        modifier = 0;
    }

    public Buff(double modifier){
        this.modifier = modifier;
    }

    /* Methods */
    public abstract void apply(Stat stats);
}
