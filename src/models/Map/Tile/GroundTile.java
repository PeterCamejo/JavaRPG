package models.Map.Tile;

import models.AreaEffect.AreaEffect;
import models.Entity.Entity;
import models.Item.InteractiveItems.Obstacle;
import models.Item.TakeableItem;

/**
 * Created by The Alex on 4/21/2016.
 */
public class GroundTile extends Tile {
    /* Attributes */
    private Obstacle obstacle;

    /* Constructors */
    public GroundTile(){
        super();
    }

    public GroundTile(Tile bottomTile , Tile topTile , Tile northTile , Tile southTile , Tile southEastTile , Tile southWestTile , Tile northEastTile , Tile northWestTile , Entity entity , TakeableItem item , AreaEffect areaEffect){
        super(bottomTile , topTile , northTile , southTile , southEastTile , southWestTile ,  northEastTile , northWestTile ,entity ,item , areaEffect);
    }

    /* Methods */
    public void sendEntityNorth(){
        if(northTile.receiveEntityFromSouth(this.entity)){
            this.entity = null;
        }
    }

    public void sendEntitySouth(){
        if(southTile.receiveEntityFromNorth(this.entity)){
            this.entity = null;
        }
    }

    public void sendEntityNorthEast(){
        if(northEastTile.receiveEntityFromSouthWest(this.entity)){
            this.entity = null;
        }
    }

    public void sendEntitySouthEast(){
        if(southEastTile.receiveEntityFromNorthWest(this.entity)){
            this.entity = null;
        }
    }

    public void sendEntityNorthWest(){
        if(northWestTile.receiveEntityFromSouthEast(this.entity)){
            this.entity = null;
        }
    }

    public void sendEntitySouthWest(){
        if(southWestTile.receiveEntityFromNorthEast(this.entity)){
            this.entity = null;
        }
    }

    public Boolean receiveEntityFromNorth(Entity entity){
        if(entity.getGroundMovement() && (obstacle = null || obstacle.passable(););
        }
    }
}
