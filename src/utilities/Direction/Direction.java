package utilities.Direction;

import utilities.Location.Location;

/**
 * Created by walkhard on 4/7/16.
 */
public enum Direction {
    //TODO: I DONT THINK THIS ONE SHOULD CREATE NEXT LOCATION

    NorthWest(new Location(-1,-1,0), new Location(0,-1,0)),
    North(new Location(-1,0,0), new Location(-1,0,0)),
    NorthEast(new Location(-1,1,0), new Location(0,1,0)),
    SouthEast(new Location(0,1,0), new Location(1,1,0)),
    South(new Location(1,0,0), new Location(1,0,0)),
    SouthWest(new Location(0,-1,0), new Location(1,-1,0)),
    //TODO:SHOULD NOT BE HERE
    Up( new Location(0,0,1), new Location(0,0,1) ),
    Down( new Location(0,0,-1), new Location(0,0,-1) );

    private Location evenCol;
    private Location oddCol;

    Direction(Location evenCol, Location oddCol){
        this.evenCol = evenCol;
        this.oddCol = oddCol;
    }

    public Location getNextLocation(Location now){
        Location move = (now.getCol()%2 == 0)?evenCol :oddCol;
        return now.add(move);
    }


    public static Direction counterCloclwise(Direction selected){
        int pos = selected.ordinal();
        if(pos > Direction.values().length - 3){
            return Direction.North;
        }

        if(pos == 0){
            return Direction.values()[Direction.values().length -3];
        }
        return Direction.values()[pos -1];
    }
    public static Direction clockwise(Direction selected){

        int pos = selected.ordinal();
        if(pos > Direction.values().length - 3){
            return Direction.North;
        }
        if(pos == Direction.values().length-3){
            return Direction.values()[0];
        }
        return Direction.values()[pos + 1];
    }
}
