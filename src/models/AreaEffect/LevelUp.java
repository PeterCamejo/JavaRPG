package models.AreaEffect;

import models.Entity.Entity;
import utilities.Location.Location;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LevelUp extends AreaEffect {

    private double levels;

    public LevelUp(Location l, int lev){
        loc = l;
        levels = lev;
    }
    public void execute(Entity e){
        levelUp(e);
    }

    private void levelUp(Entity e){
//        Map<String, Double> statChange = new HashMap<>();
//        statChange.put("LEVEL",levels);
//        e.modifyStats(statChange);
        e.levelUp();
    }
}
