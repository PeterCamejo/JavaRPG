package models.Buff;

import models.Stat.Stat;

/**
 *
 */
public class MovementBuff extends Buff {
    /* Constructors */
    public MovementBuff(){
        super();
    }

    public MovementBuff(double modifier){
        super(modifier);
    }

    /* Methods */
    public void apply(Stat stats){
        stats.modifyMovement(this.modifier);
    }
}

