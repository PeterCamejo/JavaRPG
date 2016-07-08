package models.Map;

import game.Game;
import models.Entity.Avatar;
import models.Entity.Entity;
import models.Factories.ItemFactory;
import models.Item.InteractiveItems.Obstacle;
import models.Location;
import models.Map.Tile.GroundTile;
import models.Map.Tile.Tile;


import java.awt.*;
import java.util.HashMap;


public class Map {
    /* Attributes */
    private Avatar player;
    private Tile[][] tiles;
    private int tileSize;
    private int mapSize;

    //test
    Location test;

    /* Constructors */
    public Map(Avatar player , int tileSize , int mapSize ){
        this.player = player;
        this.tileSize = tileSize;
        this.mapSize = mapSize;
        tiles = new Tile[mapSize][mapSize];
        init();
    }

    /* Methods */
    public void init() {
        for(int i = 0 ; i < mapSize; i++){
            for(int j = 0 ; j < mapSize; j++){
                if(i == 4){
                    tiles[i][j] = new GroundTile(null , ItemFactory.getDoorKey() , null , null , new Location(i * tileSize , j* tileSize) , tileSize);
                }else if(i == 25){
                    tiles[i][j] = new GroundTile(null , null , null , new Obstacle() , new Location(i * tileSize , j* tileSize) , tileSize);
                } else{
                    tiles[i][j] = new GroundTile(null, null, null, null, new Location(i * tileSize, j * tileSize), tileSize);
                }
            }
        }


       // tiles[0] = new GroundTile(null, null, null, null , new Location(20 ,20 , 0) , tileSize);
    }

    public void render(Graphics g){

        for(int i = 0 ; i < mapSize ; i++){
            for(int j = 0 ; j < mapSize; j++){
                if(tiles[i][j] != null){
                    tiles[i][j].render(g);
                }
            }
        }

        //test
        if(test != null){
            g.setColor(Color.CYAN);
            g.fillRect((int) test.getX() , (int) test.getY() , 5 , 5 );
        }
    }

    public Tile getTileAtLocation(Location location){
        Point tileCoords = location.convertToTile(tileSize);
        return tiles[tileCoords.x][tileCoords.y];
    }

    public void clearTileAtLocation(Location location){
        Point tileCoords = location.convertToTile(tileSize);
        tiles[tileCoords.x][tileCoords.y].clearEntity();
    }

    public int getTileSize(){
        return tileSize;
    }

    //test
    public void test(Location location){
        test = location;
    }
}

