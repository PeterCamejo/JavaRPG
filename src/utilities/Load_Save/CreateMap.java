package utilities.Load_Save;

import utilities.Direction.Direction;
import utilities.Location.Location;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class CreateMap {

    private int rowSize;
    private int colSize;
    private int heightSize;

    public CreateMap(int row, int col, int height){
        rowSize = row;
        colSize = col;
        heightSize = height;
    }

    public void writing() {
        try {
            // Whatever the file path is.
            File statText = new File("res/Map/Map.txt");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.write(rowSize +" "+ colSize +" "+ heightSize + "\n");

            addFirstLayerGrass(10,10,w);
            addLader(7, 4, 5,w);

            makeGOTWall(10,5,10,w);
            makeBridgeNorth(new Location(11,4,4),2,4,w);
            makeGOTWall(14,5,10,w);
            makeRiverEast(new Location(11,0,2),3,10,w);

            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file Map.txt");
        }
    }

    private void addFirstLayerGrass(int row, int col,Writer w){
        for(int c =0; c < col; c++){
            for(int r = 0; r <row; r++) {
                write(rowSize - r -1 ,c,0,1,w);
            }
        }
    }

    private void addLader(int rowStart,int c ,int height, Writer w){

        Location loc = new Location(rowSize - rowStart, c, 0);

        for(int r = 0; r < height; r++ ){
            for(int h = 0; h <= r; h++){

                if(h == r ){
                    write(loc.add(0,0,h),1,w);
                }else {
                    write(loc.add(0,0,h),2,w);
                }
            }
            loc = Direction.NorthEast.getNextLocation(loc);
        }
    }

    //Game of Throne
    private void makeGOTWall(int rowStart, int height, int colEnd, Writer w){
        Location loc = new Location(rowSize - rowStart,0, 0);

        for(int c = 0; c < colEnd;c++){
            for(int h = 0; h < height;h++){
                if(h == height-1) {
                    write(loc.add(0, c, h),1 , w);
                }
                else {
                    write(loc.add(0, c, h), 2, w);
                }
            }
        }
    }

    private void makeBridgeNorth(Location start, int width, int length, Writer w){
        start = new Location(rowSize - start.getRow() ,start.getCol(),start.getHeight());

        for(int c= 0; c < width; c++){
            for(int r = 0; r < length; r++){
                write(start.sub(r,c,0),6,w);
            }
        }
    }

    private void makeRiverEast(Location start, int width, int length,Writer w){
        start = new Location(rowSize - start.getRow() ,start.getCol(),start.getHeight());

        for(int c = 0; c < length; c++){
            for(int r = 0; r < width; r++){
                write(start.sub(r,-c,start.getHeight()),3,w);
            }
        }
    }

    private void write(Location loc,int t,Writer w){
        this.write(loc.getRow(),loc.getCol(),loc.getHeight(),t,w);
    }
    public void write(int r,int c, int h, int t, Writer w){
        try{
            w.write(" ( " + r + " " + c + " " + h + " " + t + " ) ");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addGround(int height,Writer w){
        for(int h = 0; h < height; h++){
            for(int c =0; c < colSize; c++){
                for(int r = 0; r < rowSize; r++){

                    try {
                        w.write(" ( " +r + " " + c + " " + h);

                        if(h== height-1){
                            w.write(" " + 1 + " )"); //grass
                        }else {
                            w.write(" " + 2 + " )"); //mountain
                        }

                    }
                    catch(IOException e){
                        System.err.println("Problem writing to the file Map.txt");
                    }
                }
            }
            try{
                w.write("\n");
            }
            catch(IOException e){
                System.err.println("Problem writing to the file Map.txt");
            }
        }
    }


    public static void main(String[] args) {
        CreateMap write = new CreateMap(50, 50, 10);
        write.writing();

    }
}