package models.AreaEffect;


import models.Buff.HealthBuff;

/**
 *
 */
public class HealthAreaEffect extends AreaEffect{
    /* Constructor */
    public HealthAreaEffect(){
        super();
    }

    public HealthAreaEffect(double modifier){
        this.buff = new HealthBuff(modifier);
    }

}
