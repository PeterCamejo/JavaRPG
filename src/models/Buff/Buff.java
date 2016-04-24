package models.Buff;

import models.Stat.Stat;

/**
 * Created by The Alex on 4/24/2016.
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
