package views;

import models.Entity.Avatar;
import models.Map.Map;
import models.Map.Tile.Tile;

/**
 * Created by The Alex on 7/10/2016.
 */
public class Camera {

    private int gameWidth, gameHeight;
    private float xOffset, yOffset;
    private Map map;

    public Camera(int gameWidth, int gameHeight, Map map) {
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;
        this.map = map;
        yOffset = 100;
        xOffset = 100;
    }

    public void keepCameraonMap() {
        if (xOffset < 0) {
            setxOffset(0);
        } else if (xOffset > (map.getMapSize() / 2 * (map.getTileSize()) - gameWidth)) {
            xOffset = map.getMapSize() / 2 * (map.getTileSize()) - gameWidth;
        }
        if (yOffset < 0) {
            yOffset = 0;
        }
        else if (yOffset > ((map.getMapSize() / 2 * map.getTileSize()) - gameHeight) + 20) {
            yOffset = (map.getMapSize() / 2 * map.getTileSize() ) - gameHeight + 20;

        }
    }
    public void centerOnPlayer(Avatar player) {
        xOffset = player.getLocation().getX() - gameWidth/2 + map.getTileSize()/2;
        yOffset = player.getLocation().getY() - gameHeight/2 + map.getTileSize()/2;
        keepCameraonMap();
    }


    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
        keepCameraonMap();
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
        keepCameraonMap();
    }
}