package controllers;

import models.Entity.Entity;
import models.Map.Map;
import utilities.Direction.Direction;
import utilities.Location.Location;

import java.util.HashMap;

/**
 * Created by clayhausen on 4/15/16.
 */
public class Amphibious extends Locomotion {

    // Used for checking the maximum Mountain height an Entity can scale
    private int climbDelta = 0;
    // The maximum Mountain height an Entity can scale
    private int maxClimbHeight = 1;

    public Amphibious(Entity entity, Map map) { super(entity, map); }

    // Can move to Ground
    // If falling, take damage based on movement speed
    @Override
    public void moveToGround() {
        // Falling
        if (entity.getDirection() == Direction.Down) {
            double speed = entity.statValue("MOVEMENT");
            HashMap<String, Double> damageMap = new HashMap<>();
            damageMap.put("CURRENT_LIFE", -speed);
            entity.modifyStats(damageMap);
        }
        updateEntityLocation();
    }

    // Entities cannot move to Mountain
    // If the Entity can move to the Terrain above the Mountain, it will
    // If falling, kills the Entity instantly
    @Override
    public void moveToMountain() {
        // Falling
        if ( entity.getDirection() == Direction.Down ) {
            HashMap<String, Double> livesMap = new HashMap<>();
            livesMap.put("CURRENT_LIVES", -1d);
            entity.modifyStats(livesMap);
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

    // Can move in water
    // No additional behavior if falling
    @Override
    public void moveToWater() {
        updateEntityLocation();
    }

    // If the Amphibious Entity moves to an Air tile it falls until it reaches a non-air terrain
    // If it reaches a...
    //      GroundTerrain: The Entity takes damage based on the number of Tiles it fell.
    //      WaterTerrain: The Entity drowns and dies
    //      MountainTerrain: The Entity dies instantly
    // In all cases, its speed increases as it falls, and returns to normal upon landing.
    @Override
    public void moveToAir() {
        if ( entity.getDirection() == Direction.Up ) {

           // implement jump?

        } else {
            Direction oldD = entity.getDirection();

            updateEntityLocation();
            entity.setDirection(Direction.Down);

            // If Height is negative, the Entity is out of bounds and dies
            Location location = entity.getLocation();
            if ( location.getHeight() < 0 ) {
                HashMap<String, Double> livesMap = new HashMap<>();
                livesMap.put("CURRENT_LIVES", -1d);
                entity.modifyStats(livesMap);
            }

            // As the Entity is falling, deal increase speed
            double speedDelta = 5;
            HashMap<String, Double> increaseSpeedMap = new HashMap<>();
            increaseSpeedMap.put("MOVEMENT", speedDelta);

            // Recursive call
            super.move(entity.getDirection());

            // Leaving recursion...change the movement speed back
            HashMap<String, Double> decreaseSpeedMap = new HashMap<>();
            decreaseSpeedMap.put("MOVEMENT", -speedDelta);

            entity.setDirection(oldD);
        }
    }


}
