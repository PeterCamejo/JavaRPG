package models.Map;

import models.Location;
import views.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by The Alex on 5/28/2016.
 */
public class Hexagon {
    /*  Attributes */
    private int size;
    private Location center;
    private Color color;

    private BufferedImage image;
    private Graphics2D g;

    /* Constructor */
    public Hexagon(Location  center , int size ){
        this.center = center;
        this.size = size;
        color = Color.GREEN; //default color;
        image = Assets.agilityPotion;
        init();
    }

    /* Methods */
    public static Location hexCorner(Location center,int xLength,int yLength, int i){
        double angleDegree = 60*i;
        double angleRad = Math.PI / 180 * angleDegree;

        double newYLength = yLength/Math.sin(60*Math.PI/180);

        return new Location((int)(center.getX() + xLength* Math.cos(angleRad)),
                (int)(center.getY() + newYLength * Math.sin(angleRad)) , 0);
    }

    private void init(){
       /*
       image = new BufferedImage(size , size ,BufferedImage.TYPE_4BYTE_ABGR);
        g = image.getGraphics();

        int[] xPoly = new int[6];
        int[] yPoly = new int[6];
        Location temp;

        for(int  i = 0 ; i < 6 ; i++){
            temp = Hexagon.hexCorner(center, size , size , i);
            xPoly[i] = (int) temp.getX();
            yPoly[i] = (int) temp.getY();
        }

        Polygon hex = new Polygon(xPoly , yPoly , 6);
        g.setColor(color);
        g.fillRect( (int) center.getX() ,(int) center.getY() , size , size);
        */
    }

    public BufferedImage getImage(){
        image = new BufferedImage(size , size ,BufferedImage.TYPE_4BYTE_ABGR);
        g = (Graphics2D) image.getGraphics();

        int[] xPoly = new int[6];
        int[] yPoly = new int[6];
        Location temp;

        for(int  i = 0 ; i < 6 ; i++){
            temp = Hexagon.hexCorner(center, size , size , i);
            xPoly[i] = (int) temp.getX();
            yPoly[i] = (int) temp.getY();
        }

        Polygon hex = new Polygon(xPoly , yPoly , 6);
        g.setColor(color);
        g.fillRect( (int) center.getX() ,(int) center.getY() , size , size);

        return image;
    }
}
