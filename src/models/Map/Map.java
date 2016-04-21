package models.Map;

import models.Entity.Entity;
import utilities.Geometry.Hexagon;
import utilities.Location.Location;
import views.DrawTerrainImages;

import java.util.HashMap;


public class Map {


    private HashMap<Location, Tile> tiles;

    //maximum size of the keyMap once its been created cannot be change
    private int rowSize;
    private int colSize;
    private int heightSize;

    public Map(int rowSize, int colSize, int heightSize){
        this.rowSize = rowSize;
        this.colSize = colSize;
        this.heightSize = heightSize;
        tiles = new HashMap<>();
    }

    public boolean isOutOfBound(Location loc){
        if (loc.getRow() < 0 || loc.getRow() >= getRowSize()) {
            return true;
        }
        if (loc.getCol() < 0 || loc.getCol() >= getColSize()) {
            return true;
        }
        if (loc.getHeight() < 0 || loc.getHeight() >= getHeightSize()) {
            return true;
        }
        return false;
    }

    public boolean isTileEmpty(Location loc){
        if(isOutOfBound(loc)) {
            return false;
        }
        return tiles.containsKey(loc);
    }

    public int getRowSize(){return rowSize;}
    public int getColSize(){return colSize;}
    public int getHeightSize(){return heightSize;}

    public Tile getTileAt(Location loc){
        if(isOutOfBound(loc)) {
            return null;
        }
        if(!tiles.containsKey(loc)) {
            return getDefaultTile();
        }
        else {
            return tiles.get(loc);
        }
    }

    public Tile getDefaultTile(){
        Terrain terrain = Terrain.Air;
        Tile temp = new Tile(terrain);
        return temp;
    }

    public void addTileAt(Tile tile, Location loc){
        if(isOutOfBound(loc)) {
            return;
        }
        else {
            tiles.put(loc, tile);
        }
    }
    public void removeTileAt(Location loc){
        if(tiles.containsKey(loc)){
            tiles.remove(loc);
        }
    }

    public void removeEntityAt(Location loc){
        tiles.get(loc).removeEntity();
    }
    public void addEntityAt(Location loc,Entity e){tiles.get(loc).addEntity(e);}

    public boolean groundTileAbove(Location location) {
        Location tmpLocation = location.add(0,0,1);
        if (isOutOfBound(tmpLocation)) {
            return false;
        }
        if (getTileAt(tmpLocation).isGround()) {
            return true;
        }
        return false;
    }
}

