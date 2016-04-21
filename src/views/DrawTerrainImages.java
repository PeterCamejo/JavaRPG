package views;

import utilities.Geometry.Hexagon;
import views.MapView;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by jcvarela on 4/15/2016.
 */
public class DrawTerrainImages {
    public static final int LENGTH = MapView.TILE_LENGTH;
    public static final int WIDTH = MapView.TILE_WIDTH;
    public static final int HEIGHT = MapView.TILE_HEIGHT;

    public static BufferedImage getAirImage(){
        BufferedImage image = new BufferedImage(LENGTH,HEIGHT+WIDTH,BufferedImage.TYPE_4BYTE_ABGR);
        return image;
    }

    public static BufferedImage getFullTerrain(Color baseColor, Color topColor){
        BufferedImage image = new BufferedImage(LENGTH,HEIGHT+WIDTH,BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = (Graphics2D)image.getGraphics();

        int hight = HEIGHT;
        int length = LENGTH/2;
        int width = WIDTH/2;

        Point center = new Point(LENGTH/2,WIDTH/2);

        //paint ground------------------------------------------
        int[] xPoly2 = new int[6];
        int[] yPoly2 = new int[6];

        {
            Point temp = Hexagon.getXMin(center,length,width);
            xPoly2[0] = temp.x;
            yPoly2[0] = temp.y + hight;

            xPoly2[1] = temp.x;
            yPoly2[1] = temp.y;

            temp = Hexagon.getXMax(center,length,width);
            xPoly2[2] = temp.x;
            yPoly2[2] = temp.y;

            xPoly2[3] = temp.x;
            yPoly2[3] = temp.y + hight;
        }
        {
            Point[] temp = Hexagon.getYMax(center,length,width);
            xPoly2[4] = temp[0].x;
            yPoly2[4] = temp[0].y + hight;

            xPoly2[5] = temp[1].x;
            yPoly2[5] = temp[1].y + hight;
        }

        Polygon ground = new Polygon(xPoly2,yPoly2,xPoly2.length);
        g.setColor(baseColor);
        g.fill(ground);

        //paint grass----------------------------------------------------
        int[] xPoly = new int[6];
        int[] yPoly = new int[6];



        for (int i = 0 ; i < xPoly.length; i++){
            Point p = Hexagon.hexCorner(center,length,width,i);
            xPoly[i] = p.x;
            yPoly[i] = p.y;
        }


        Polygon p = new Polygon(xPoly,yPoly,xPoly.length);
        g.setColor(topColor);
        g.fill(p);

        return image;
    }


    public static BufferedImage makeHalfTerrain(Color baseColor, Color topColor){
        BufferedImage image = new BufferedImage(LENGTH,HEIGHT+WIDTH,BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = (Graphics2D)image.getGraphics();

        int hight = HEIGHT/2;
        int length = LENGTH/2;
        int width = WIDTH/2;

        Point center = new Point(LENGTH/2,WIDTH/2 + hight);

        //paint ground------------------------------------------
        int[] xPoly2 = new int[6];
        int[] yPoly2 = new int[6];

        {
            Point temp = Hexagon.getXMin(center,length,width);
            xPoly2[0] = temp.x;
            yPoly2[0] = temp.y + hight;

            xPoly2[1] = temp.x;
            yPoly2[1] = temp.y;

            temp = Hexagon.getXMax(center,length,width);
            xPoly2[2] = temp.x;
            yPoly2[2] = temp.y;

            xPoly2[3] = temp.x;
            yPoly2[3] = temp.y + hight;
        }
        {
            Point[] temp = Hexagon.getYMax(center,length,width);
            xPoly2[4] = temp[0].x;
            yPoly2[4] = temp[0].y + hight;

            xPoly2[5] = temp[1].x;
            yPoly2[5] = temp[1].y + hight;
        }

        Polygon ground = new Polygon(xPoly2,yPoly2,xPoly2.length);
        g.setColor(baseColor);
        g.fill(ground);

        //paint grass----------------------------------------------------
        int[] xPoly = new int[6];
        int[] yPoly = new int[6];



        for (int i = 0 ; i < xPoly.length; i++){
            Point p = Hexagon.hexCorner(center,length,width,i);
            xPoly[i] = p.x;
            yPoly[i] = p.y;
        }


        Polygon p = new Polygon(xPoly,yPoly,xPoly.length);
        g.setColor(topColor);
        g.fill(p);

        return image;
    }
}