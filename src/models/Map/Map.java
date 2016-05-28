package models.Map;

import models.Entity.Avatar;
import models.Entity.Entity;
import models.Factories.ItemFactory;
import models.Location;
import models.Map.Tile.GroundTile;
import models.Map.Tile.Tile;


import java.awt.*;
import java.util.HashMap;


public class Map {
    /* Attributes */
    private Avatar player;
    private Tile[] tiles;

    /* Constructors */
    public Map(Avatar player){
        this.player = player;
        init();
    }

    /* Methods */
    public void init() {
        tiles = new Tile[256];
          tiles[0] = new GroundTile(null, null, null, null , new Location(20 ,20 , 0));
          tiles[1] = new GroundTile(null , null , null , null , new Location(40 , 40, 0));
          tiles[2] = new GroundTile(null , ItemFactory.getChestKey(), null , null , new Location(60,60,0));

    }

    public void render(Graphics g){
        for(int i = 0; i < 256; i++){
            if(tiles[i] != null){
                tiles[i].render(g);
            }else{
                break;
            }
        }
    }
}

