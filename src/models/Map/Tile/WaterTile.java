package models.Map.Tile;

import models.AreaEffect.AreaEffect;
import models.Entity.Entity;
import models.Item.InteractiveItems.Obstacle;
import models.Item.TakeableItem;
import models.Location;
import views.Assets;

import java.awt.*;

/**
 * Created by The Alex on 4/21/2016.
 */
public class WaterTile extends Tile{
    /* Attributes */
    private Obstacle obstacle;


    /* Constructors */
    public WaterTile(){
        super();
        obstacle = null;
        image = Assets.waterTile;
    }

    public WaterTile(Entity entity , TakeableItem item , AreaEffect areaEffect , Obstacle obstacle , Location location , int tileSize){
        super(entity, item, areaEffect , location , tileSize);
        this.obstacle = obstacle;
        image = Assets.waterTile;

    }

    /* Methods */

    public Boolean receiveEntity(Entity entity){
        // Entity Check
        if(this.entity != null){
            if(this.entity.equals(entity)){
                return true;
            }
            return false;
        }

        //Movement Requirement Check
        if(entity.getWaterMovement() == false){
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
            areaEffect.activate(entity);
        }

        return true;
    }

    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect((int) location.getX() ,(int) location.getY() , tileSize , tileSize);

        g.drawImage(image , (int) location.getX() + 3 , (int) location.getY() + 3 , tileSize - 6 , tileSize - 6 , null);

        if(item != null){
            g.drawImage(item.getImage() , (int) location.getX(), (int) location.getY()  , null );
        }

    }

    //test
    public boolean isPassable(){
        if(obstacle != null){
            return obstacle.passable();
        }

        return true;

    }
}
