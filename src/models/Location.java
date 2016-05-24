package models;

/**
 * Created by The Alex on 5/22/2016.
 */
public class Location {
    /* Attributes */
    float x;
    float y;
    float z;

    /* Constructor */
    public Location(){
        x = 0;
        y = 0;
        z = 0;
    }
    public Location(float x , float y , float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /* Methods */
    public float getX(){return x;}
    public float getY(){return y;}
    public float getZ(){return z;}

    public void setX(float x){this.x = x;}
    public void setY(float y){this.y = y;}
    public void setZ(float z){this.z = z;}

    public void modifyX(float modification){x += modification;}
    public void modifyY(float modification){y += modification;}
    public void modifyZ(float modification){z += modification;}
}
