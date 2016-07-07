package models;

import java.awt.*;

/**
 * Created by The Alex on 5/22/2016.
 */
public class Location {
    /* Attributes */
    float x;
    float y;


    /* Constructor */
    public Location(){
        x = 0;
        y = 0;
    }
    public Location(float x , float y){
        this.x = x;
        this.y = y;
    }

    /* Methods */
    public float getX(){return x;}
    public float getY(){return y;}


    public void setX(float x){this.x = x;}
    public void setY(float y){this.y = y;}


    public void modifyX(float modification){x += modification;}
    public void modifyY(float modification){y -= modification;}


    //Converts the location into what tile it corresponds to.
    public Point convertToTile(int tileSize){
        int row , col;
        int tempX = (int) x;
        int tempY = (int) y;

        tempX -= (x % tileSize);
        tempY -= (y % tileSize);

        row = tempX / tileSize;
        col = tempY / tileSize;

        return new Point(row , col);




    }
}
