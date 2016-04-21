package utilities.Geometry;

import java.awt.*;

/**
 * Created by jcvarela on 4/13/2016.
 */
public class Hexagon {

    public static final int X_LENGTH = 30;
    public static final int Y_LENGTH = 15;

    public static Point hexCorner(Point center, int i){
        return hexCorner(center,X_LENGTH,Y_LENGTH,i);
    }

    public static Point getXMin(Point center){
        return hexCorner(center,3);
    }
    public static Point getXMax(Point center){
        return hexCorner(center,0);
    }

    public static Point[] getYMin(Point center){
        return getYMin(center,X_LENGTH,Y_LENGTH);
    }
    public static Point[] getYMax(Point center){
        return getYMax(center,X_LENGTH,Y_LENGTH);
    }

    public static Point hexCorner(Point center,int xLength,int yLength, int i){
        double angleDegree = 60*i;
        double angleRad = Math.PI / 180 * angleDegree;

        double newYLength = yLength/Math.sin(60*Math.PI/180);

        return new Point((int)(center.x + xLength* Math.cos(angleRad)),
                (int)(center.y + newYLength * Math.sin(angleRad)));
    }

    public static Point getXMin(Point center, int xLength, int yLength){
        return hexCorner(center,xLength,yLength,3);
    }
    public static Point getXMax(Point center, int xLength,int yLength){
        return hexCorner(center,xLength,yLength,0);
    }

    public static Point[] getYMin(Point center,int xLength, int yLength){
        Point[] value = new Point[2];
        value[0] = hexCorner(center,xLength,yLength,4);
        value[1] = hexCorner(center,xLength,yLength,5);
        return value;
    }
    public static Point[] getYMax(Point center, int xLength,int yLength){
        Point[] value = new Point[2];
        value[0] = hexCorner(center,xLength,yLength,1);
        value[1] = hexCorner(center,xLength,yLength,2);
        return value;
    }
}