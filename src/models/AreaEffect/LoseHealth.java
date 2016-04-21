package models.AreaEffect;

import models.Entity.Entity;
import utilities.Location.Location;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 4/14/2016.
 */
public class LoseHealth extends AreaEffect {

    double healthLoss;
    public LoseHealth(Location l, int health){
        loc = l;
        healthLoss = health;
        if(healthLoss > 0){
            healthLoss = healthLoss*-1;
        }
    }

    public void execute(Entity e){
        loseHealth(e);
    }

    private void loseHealth(Entity e){
        Map<String, Double> statChange = new HashMap<>();
        statChange.put("CURRENT_LIFE",healthLoss);
        e.modifyStats(statChange);

    }

}
