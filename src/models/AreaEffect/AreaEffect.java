package models.AreaEffect;

import models.Buff.Buff;
import models.Entity.Entity;
import models.Stat.Stat;

import java.awt.geom.Area;
import java.awt.image.BufferedImage;


public abstract class AreaEffect{
    /* Attributes */
    protected Buff buff;
    protected BufferedImage image;

    /* Constructor */
    public AreaEffect(){
        buff = null;
    }

    public AreaEffect(BufferedImage image){
        this.image = image;
    }

    /* Methods */
    public void activate(Entity entity){
        buff.apply(entity);
    }
    public void setImage(BufferedImage image){ this.image = image;}
    public BufferedImage getImage(){ return image;}

}
