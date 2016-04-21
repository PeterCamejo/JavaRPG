package models.AreaEffect;

import models.Entity.Entity;
import utilities.Location.Location;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 4/14/2016.
 */
public class InstantDeath extends AreaEffect {

    public InstantDeath(Location l){
        loc = l;
    }

    public void execute(Entity e){
        killEntity(e);
    }

    private void  killEntity(Entity e){
        //double a = e.statValue("Life");
        //a = a*-1;
        Map<String, Double> statChange = new HashMap<>();
        statChange.put("CURRENT_LIVES",-1.0);
        e.modifyStats(statChange);

    }
}
