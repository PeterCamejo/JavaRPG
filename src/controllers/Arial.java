package controllers;

import models.Entity.Entity;
import models.Map.Map;
import utilities.Direction.Direction;
import utilities.Location.Location;

import java.util.HashMap;

/**
 * Created by clayhausen on 4/18/16.
 */
public class Arial extends Locomotion {
    // Used for checking the maximum Mountain height an Entity can scale
    private int climbDelta = 0;
    // The maximum Mountain height an Entity can scale
    private int maxClimbHeight = 1;

    public Arial(Entity entity, Map map) { super(entity, map); }

    // Can move to Ground
    // If falling, take damage based on movement speed
    @Override
    public void moveToGround() {
        updateEntityLocation();
    }

    // Can not directly move to Mountains of a certain height.
    // However, these Tiles can be reached by first moving up
    @Override
    public void moveToMountain() {
        if ( entity.getDirection() == Direction.Down ) {
            // Do nothing
        } else {

            Direction direction = entity.getDirection();
            Location oldLocation = entity.getLocation();

            // Base case
            if (climbDelta >= maxClimbHeight) {
                entity.changeLocation(oldLocation.sub(0,0,climbDelta));
                climbDelta = 0;
                return;
            }

            // Entities move slower when moving up Mountains
            double weight = 0.5;
            double speedDelta = entity.statValue("MOVEMENT") * weight;
            HashMap<String, Double> decreaseSpeedMap = new HashMap<>();
            decreaseSpeedMap.put("MOVEMENT", -speedDelta);

            // Recursive call
            ++climbDelta;
            // Place entity one tile up
            Location tempLocation = oldLocation.add(0,0,1);
            entity.changeLocation(tempLocation);
            move(direction);
            climbDelta = 0;

            // Revert speed
            HashMap<String, Double> increaseSpeedMap = new HashMap<>();
            increaseSpeedMap.put("MOVEMENT", speedDelta);

        }
    }

    // Cannot swim
    @Override
    public void moveToWater() {
        updateEntityLocation();
    }

    // Can fly
    @Override
    public void moveToAir() {
        updateEntityLocation();
    }
}
