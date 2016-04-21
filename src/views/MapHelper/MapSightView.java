package views.MapHelper;

import models.Map.Map;
import models.Map.Tile;
import utilities.Direction.Direction;
import utilities.Location.Location;

import java.util.HashMap;

/**
 * Created by jcvarela on 4/16/2016.
 */
public class MapSightView{

    public static final float MIN_SIGHT =0.15f;

    public static HashMap<Location, Float> getTileSIght(Map map, Location center, int radius){
        HashMap<Location,Float> tilesSight = new HashMap<Location,Float>();

        float reduce = 1f/radius;

        tileSight(center,1f,reduce,tilesSight,map,center);

        return tilesSight;
    }

    private static void tileSight(Location loc, float sight, float reduce, HashMap<Location,Float> tileSight, Map map, Location center){

        if(sight <= MIN_SIGHT){
            return;
        }

        if(tileSight.containsKey(loc) && (tileSight.get(loc) >= sight)) {
            return;
        }

        if(map.isOutOfBound(loc)) {
            return;
        }

        tileSight.put(loc,sight);

        tileUpDownSight(loc,sight,reduce,tileSight,map,center);
        tileDirectionSight(loc,sight,reduce,tileSight,map,center);
    }

    private static void tileUpDownSight(Location loc, float sight, float reduce, HashMap<Location,Float> tileSight, Map map, Location center){
        Tile tile = map.getTileAt(loc);

        tileSight(loc.sub(0, 0, -1), sight - reduce * 0.4f, reduce, tileSight, map, center);

        //go down
        if(tile.getTerrain() == Terrain.Air){
            tileSight(loc.sub(0,0,1),sight - reduce,reduce ,tileSight,map,center);
        }

    }

    private static void tileDirectionSight(Location loc, float sight, float reduce, HashMap<Location,Float> tileSight, Map map, Location center){
        Tile tile =map.getTileAt(loc);

        sight -= reduce;

        if(tile.getTerrain() == Terrain.Mountain){
            sight -= 3*reduce;
        }

        for(Direction d: Direction.values()){
            tileSight(d.getNextLocation(loc),sight,reduce ,tileSight,map,center);
        }
    }


    public static HashMap<Location,Integer> basicArea(Map map, Location center, int radius){
        HashMap<Location,Integer> area = new HashMap<>();

        recBasicSight(0, new Location(center.getRow(),center.getCol(),0), radius,map,area);
        return area;
    }

    private static void recBasicSight(int value,Location loc, int r, Map map, HashMap<Location,Integer> area){
        if(r < 1){
            return;
        }
        if(map.isOutOfBound(loc)){
            return;
        }

        if(area.containsKey(loc) && area.get(loc) <= value) {
            return;
        }

        area.put(loc,value);

        for(Direction d: Direction.values()){
            recBasicSight(value + 1, d.getNextLocation(loc), r -1, map,area);
        }
    }

}