package models.AreaEffect;

import models.Entity.Entity;
import models.Map.Map;
import utilities.Direction.Direction;
import utilities.Location.Location;

/**
 * Created by Andy on 4/14/2016.
 */
public class FlowTile extends AreaEffect {

    private int flowRate;
    private Direction d;
    private Map map; //i fucking hate this

    public FlowTile(Location l, int rate, Direction di, Map m){
        loc = l;
        flowRate = rate;
        d = di;
        map = m;
    }

    public void execute(Entity e){
        flow(e);
    }

    private void flow(Entity e){
        //yeah I should probably figure this out.
        //Location l = getMoveLocation();
        //e.changeLocation(l);
        e.changeDirection(d);
        e.changeLocation(d.getNextLocation(loc));
        //map.getTileAt(loc).removeEntity();
        map.removeEntityAt(loc);

    }

    

    private Location getMoveLocation(){
        int x,y,z;
        x = loc.getRow();
        y = loc.getCol()-1;
        z = loc.getHeight();
        Location temp = new Location(x,y,z);
        return temp;
    }
}
