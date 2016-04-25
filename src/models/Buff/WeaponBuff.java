package models.Buff;

import models.Stat.Stat;

/**
 * Buffs weaponDamage.
 *
 * Meant to be applied and unapplied with the equipping/unequipping of a Weapon.
 */
public class WeaponBuff extends Buff{
    /* Constructor */
    public WeaponBuff(){
        super();
    }

    public WeaponBuff(double modifier){
        super(modifier);
    }

    /* Methods */
    public void apply(Stat stats) {
        stats.modifyWeaponDamage(this.modifier);
    }
}
