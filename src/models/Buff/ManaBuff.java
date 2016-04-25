package models.Buff;

import models.Stat.Stat;

/**
 * Raises or decreases current Mana
 *
 * Max mana is raised with IntellectBuff.
 */
public class ManaBuff extends Buff{
    /* Constructors */
    public ManaBuff(){
        super();
    }

    public ManaBuff(double modifier){
        super(modifier);
    }

    /* Methods */
    public void apply(Stat stat){
        stat.modifyMana(this.modifier);
    }
}
