package models.Map;

import game.Game;
import models.Entity.Avatar;
import models.Entity.Entity;
import models.Factories.AreaEffectFactory;
import models.Factories.ItemFactory;
import models.Item.InteractiveItems.Obstacle;
import models.Location;
import models.Map.Tile.GroundTile;
import models.Map.Tile.Tile;
import models.Map.Tile.WaterTile;


import java.awt.*;
import java.util.HashMap;


public class Map {
    /* Attributes */
    private Avatar player;
    private Tile[][] tiles;
    private int tileSize;
    private int tileAmount;
    private int mapSize;

    //test
    Location test;

    /* Constructors */
    public Map(Avatar player , int tileSize , int tileAmount ){
        this.player = player;
        this.tileSize = tileSize;
        this.tileAmount =  tileAmount;
        tiles = new Tile[tileAmount][tileAmount];
        mapSize = this.tileSize * this.tileAmount;
        init();
    }

    /* Methods */
    public void init() {
        for(int i = 0 ; i < tileAmount; i++){
            for(int j = 0 ; j < tileAmount; j++){
                if(i == 4){
                    tiles[i][j] = new GroundTile(null , ItemFactory.getDoorKey() , null , null , new Location(i * tileSize , j* tileSize) , tileSize);
                }else if(i == 6){
                    tiles[i][j] = new GroundTile(null , ItemFactory.getBasicOneHand() , null , null , new Location(i * tileSize , j* tileSize) , tileSize);
                } else if(j == 7){
                    tiles[i][j] = new WaterTile(null , null , null , null, new Location(i * tileSize , j * tileSize) , tileSize);
                }else if(i == 3 && j == 3){
                    tiles[i][j] = new GroundTile(null , null , null , ItemFactory.getBoulder() , new Location(i * tileSize , j * tileSize) , tileSize);
                }else if(i == 5 && j == 5){
                    tiles[i][j] = new GroundTile(null , null , AreaEffectFactory.getDamageHealthEffect(5), null , new Location(i * tileSize , j * tileSize) , tileSize );
                }

                else{
                    tiles[i][j] = new GroundTile(null, null, null, null, new Location(i * tileSize, j * tileSize), tileSize);
                }
            }
        }


       // tiles[0] = new GroundTile(null, null, null, null , new Location(20 ,20 , 0) , tileSize);
    }

    public void tick(){
        updateEntityTile();

    }

    public void render(Graphics g){

        for(int i = 0 ; i < tileAmount ; i++){
            for(int j = 0 ; j < tileAmount; j++){
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

    private void updateEntityTile(){
        Location center = player.getCenter();
        Point tilePoint = center.convertToTile(tileSize);
        player.setCurrentTile(tiles[tilePoint.x][tilePoint.y]);
        tiles[tilePoint.x][tilePoint.y].tick();
    }

    public int getMapSize(){ return mapSize;}
    public Avatar getPlayer(){return player;}
}

