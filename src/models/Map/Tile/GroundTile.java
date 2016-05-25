package models.Map.Tile;

import models.AreaEffect.AreaEffect;
import models.Entity.Entity;
import models.Item.InteractiveItems.Obstacle;
import models.Item.TakeableItem;
import models.Location;
import views.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

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

    public GroundTile(Entity entity , TakeableItem item , AreaEffect areaEffect , Obstacle obstacle , Location location){
        this.entity = entity;
        this.item = item;
        this.areaEffect = areaEffect;
        this.obstacle = obstacle;
        this.location = location;
        terrainImage = Assets.TestHexagon;
    }

    /* Methods */
    public void sendEntityNorth(){
        if(northTile.receiveEntity(this.entity)){
            this.entity = null;
        }
    }

    public void sendEntitySouth(){
        if(southTile.receiveEntity(this.entity)){
            this.entity = null;
        }
    }

    public void sendEntityNorthEast(){
        if(northEastTile.receiveEntity(this.entity)){
            this.entity = null;
        }
    }

    public void sendEntitySouthEast(){
        if(southEastTile.receiveEntity(this.entity)){
            this.entity = null;
        }
    }

    public void sendEntityNorthWest(){
        if(northWestTile.receiveEntity(this.entity)){
            this.entity = null;
        }
    }

    public void sendEntitySouthWest(){
        if(southWestTile.receiveEntity(this.entity)){
            this.entity = null;
        }
    }

    public Boolean receiveEntity(Entity entity){
        // Entity Check
        if(this.entity != null){
            return false;
        }

        //Movement Requirement Check
        if(entity.getGroundMovement() == false){
            return false;
        }

        //Obstacle Check
        if(this.obstacle != null){
            obstacle.activate(entity);
            if(obstacle.passable() == false){
                return false;
            }
        }

        //Activate Stuff
        this.entity = entity;

        if(this.item != null){
            item.activate(entity);
            item = null;
        }
        if(this.areaEffect != null){
            areaEffect.activate(entity.getStats());
        }

        return true;
    }

    public void render(Graphics g){
        int multiplier = 100;
        g.drawImage(terrainImage , (int) location.getX() * multiplier , (int) location.getY() * multiplier , null);
        if(item != null){
            g.drawImage(item.getImage() , (int) location.getX() * multiplier , (int) location.getY() * multiplier , null );
        }

    }
}
