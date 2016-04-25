package models.Buff;

import models.Item.Armors.Armor;
import models.Stat.Stat;

/**
 * Buffs armorRating.
 *
 * Meant to be applied/unapplied with the equipping/unequipping of Armor.
 */
public class ArmorBuff extends Buff{
    /* Constructor */
    public ArmorBuff(){
        super();
    }

    public ArmorBuff(double modifier){
        super(modifier);
    }

    /* Methods */
    public void apply(Stat stats) {
        stats.modifyArmorRating(this.modifier);
    }
}
