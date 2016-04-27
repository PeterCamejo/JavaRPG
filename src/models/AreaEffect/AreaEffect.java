package models.AreaEffect;

import models.Buff.Buff;
import models.Entity.Entity;
import models.Stat.Stat;

import java.awt.geom.Area;


public abstract class AreaEffect{
    /* Attributes */
    protected Buff buff;

    /* Constructor */
    public AreaEffect(){
        buff = null;
    }

    /* Methods */
    public void activate(Stat stats){
        buff.apply(stats);
    }

}
