package models.Buff;

import models.Entity.Entity;
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
    public void apply(Entity entity){
        Stat stats = entity.getStats();
        apply(stats);
        entity.setStat(stats);
    }

    public double getModifier(){ return this.modifier;}

    // Used to negate buffs (for when they are unapplied)
    public void negateModifier(){
        this.modifier = this.modifier * -1;
    }
}
