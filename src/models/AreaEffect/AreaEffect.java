package models.AreaEffect;

import models.Entity.Entity;
import utilities.Location.Location;

public abstract class AreaEffect {
    Location loc;

    public Location getLocation(){
        return loc;
    }
    public void setLocation(Location l){
        loc = l;
    }

    public abstract void execute(Entity e);

}
