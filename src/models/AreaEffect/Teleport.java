package models.AreaEffect;

import models.Entity.Entity;
import models.Map.Map;
import utilities.Location.Location;

/**
 * Created by Andy on 4/14/2016.
 */
public class Teleport extends AreaEffect {
    Location toLoc;
    Map map;

    public Teleport(Location from,Location to, Map m){
        loc = from;
        toLoc = to;
        map = m;
    }

    public void execute(Entity e){
        teleportEntity(e);
    }

    private void teleportEntity(Entity e){
        e.changeLocation(toLoc);
       // map.getTileAt(loc).removeEntity();
        map.removeEntityAt(loc);
        map.addEntityAt(toLoc, e);
    }


}
