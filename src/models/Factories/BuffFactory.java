package models.Factories;

import models.Buff.*;

/**
 *
 */
public class BuffFactory {
    /* Methods */
    public static Buff getHealthBuff(double amount){return new HealthBuff(amount);}
    public static Buff getManaBuff(double amount){ return new ManaBuff(amount);}
    public static Buff getStrengthBuff(double amount){return new StrengthBuff(amount);}
    public static Buff getIntellectBuff(double amount){ return new IntellectBuff(amount);}
    public static Buff getAgilityBuff(double amount){ return new AgilityBuff(amount);}
    public static Buff getExperienceBuff(double amount){ return new ExperienceBuff(amount);}
    public static Buff getMovementBuff(double amount){ return new MovementBuff(amount);}
    public static Buff getStaminaBuff(double amount){ return new StaminaBuff(amount);}
}
