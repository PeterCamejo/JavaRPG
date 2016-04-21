package views;


import models.AreaEffect.AreaEffect;
import models.Decal.Decal;
import models.Entity.Entity;
import models.Item.Item;
import models.Map.Map;
import models.Map.Tile;
import utilities.Geometry.Hexagon;
import utilities.Location.Location;
import views.MapHelper.MapSightView;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.util.HashMap;

public class MapView {

    public static final int TILE_LENGTH = 4 * Hexagon.X_LENGTH;
    public static final int TILE_WIDTH = 4 * Hexagon.Y_LENGTH;
    public static final int TILE_HEIGHT = 20;


    private int rowRange;
    private int colRange;
    private int heightRange;
    private int width;
    private int height;


    private HashMap<Location,Integer> sight;
    private Location center;
    private Map map;
    private int radius;

    public MapView(Map map) {
        sight = new HashMap<>();
        this.map = map;
        radius = 7;
    }

    public void setCenter(Location pos){
        this.center = pos;
    }

    protected void render(int width, int height, Graphics g) {
        this.height = height;
        this.width = width;

        sight = MapSightView.basicArea(map,center,radius);

        heightRange = 20;
        rowRange = 15;
        colRange = 15;

        renderMap((Graphics2D) g);
    }

    private void renderMap(Graphics2D g){
        int tileHeight = TILE_HEIGHT;

        int heightStart = center.getHeight() - heightRange/2;
        int heightEnd = center.getHeight()  + heightRange/2 + 1;

        //FOR PAINTING
        int drawYincrement = tileHeight + 1;
        int drawX = width/2;
        int drawY = height/2 + (center.getHeight() - heightStart)*drawYincrement;

        for(int h = heightStart; h < heightEnd; h++){
            renderHightAt(h,drawX,drawY,g);
            drawY -= drawYincrement;
        }

    }

    private void renderHightAt(int height, int centerX, int centerY, Graphics2D g){
        int tileWidth = TILE_WIDTH;


        int rowStart = center.getRow() - rowRange/2;
        int rowEnd = center.getRow() + rowRange/2 + 1;

        //FOR PAINTING
        int drawYIncrement = tileWidth + 1;
        int drawX = centerX;
        int drawY = centerY - drawYIncrement/2 -(center.getRow() - rowStart)*drawYIncrement;

        for(int r = rowStart; r < rowEnd; r++){
            renderRowAtHeight(r,height,drawX,drawY,g);
            drawY += drawYIncrement;
        }
    }

    private void renderRowAtHeight(int row,int height, int centerX, int centerY, Graphics2D g){

        int tileLength = TILE_LENGTH;
        int tileWidth = TILE_WIDTH;


        int colStart = center.getCol() - colRange/2;
        int colStart2 = colStart;

        int colEnd = center.getCol() + colRange/2 + 1;


        if(colStart%2 != 0) {
            colStart++;
        }else {
            colStart2++;
        }

        int space = 1;
        int drawXIncrement = tileLength*3/4 + 1;
        int drawX = centerX - (center.getCol() - colStart)*drawXIncrement;
        int drawY = centerY - tileWidth/4;

        for(int c = colStart; c < colEnd; c += 2){
            renderTileAt(drawX, drawY, new Location(row, c, height), g);
            drawX += 2*drawXIncrement;
        }

        drawX = centerX - (center.getCol() - colStart2)*drawXIncrement;
        drawY = space + centerY + tileWidth/4;

        for(int c = colStart2; c < colEnd; c += 2){
            renderTileAt( drawX,drawY , new Location(row,c,height),g);
            drawX += 2*drawXIncrement;
        }
    }

    private void renderTileAt(int x, int y, Location loc, Graphics2D g){

        Tile tile = map.getTileAt(loc);
        if(tile == null) {
            return;
        }

        Location temp = new Location(loc.getRow(),loc.getCol(),0);
        if(!sight.containsKey(temp)){
            return;
        }

        float value = (float)(radius - sight.get(temp))/radius;

        float[] scales = { value, value, value, 1f};
        float[] offsets = new float[4];
        RescaleOp rop = new RescaleOp(scales, offsets, null);

        if(tile.getTerrain() != Terrain.Air) {
            renderTerrain(x, y, tile, g, rop);
        }

        if(value > 0.2f) {
            renderElements(x, y,tile, g,rop);
        }
    }

    private void renderElements(int x, int y, Tile tile, Graphics2D g, RescaleOp rop){
        BufferedImage image;

        //draw decal
        Decal decal = tile.getDecal();
        if (decal != null) {
            image = decal.getBufferedImage();
            g.drawImage(image,x - image.getWidth()/2,y - image.getHeight()/2,null);
        }

        //draw AreaEffect
        AreaEffect areaEffect = tile.getAreaEffect();
        if(areaEffect != null){
            //TODO: MAT PUT STUFF HERE
        }

        //draw Item
        Item item = tile.getItem();
        if(item != null){
            image = item.getImage();
            g.drawImage(image,x - image.getWidth()/2,y - image.getHeight()/2,null);
        }

        //draw entity
        Entity temp = tile.getEntity();
        if(temp != null){
           Image im = temp.getImage();
            g.drawImage(im,x - im.getWidth(null)/2,y - im.getHeight(null)/2,null);
        }
    }


    private void renderTerrain(int x,int y, Tile tile, Graphics2D g,  RescaleOp rop){
        Terrain temp = tile.getTerrain();
        if(temp == null) {
            return;
        }

        BufferedImage image = temp.getImage();
        g.drawImage(image,rop ,x - image.getWidth()/2,y - image.getHeight()/2);

        Decal decal = tile.getDecal();
        if (decal != null) {
           image = decal.getBufferedImage();
            g.drawImage(image,x - image.getWidth()/2,y - image.getHeight()/2,null);
        }
    }


    private void renderTerrain(int x, int y, Tile tile, Graphics2D g){
        Terrain temp = tile.getTerrain();
        Decal decal = tile.getDecal();
        if(temp == null) {
            return;
        }

        if (decal != null) {
            BufferedImage image = decal.getBufferedImage();
            System.out.println(image.getWidth() + " "+ image.getHeight());
            g.drawImage(image,x - image.getWidth()/2,y - image.getHeight()/2,null);
        }
        else if (temp != null) {
            Image image = temp.getImage();
            g.drawImage(image,x - image.getWidth(null)/2,y - image.getHeight(null)/2,null);
        }
    }
}
