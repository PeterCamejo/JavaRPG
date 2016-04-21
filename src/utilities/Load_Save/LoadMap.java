package utilities.Load_Save;

import models.Map.Map;
import models.Map.Tile;
import utilities.Location.Location;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by jcvarela on 4/17/2016.
 */
public class LoadMap {

    public static Map loadMap(String path){
        File file = new File(path);
        Map map = new Map(0,0,0);

        try{
            Scanner in = new Scanner(file);

            int row = in.nextInt();
            int col = in.nextInt();
            int height = in.nextInt();

            map = new Map(row,col,height);

            while(in.hasNext()){
                in.next();
                int r = in.nextInt();
                int c = in.nextInt();
                int h = in.nextInt();
                int terrain = in.nextInt();
                in.next();

                map.addTileAt(new Tile(Terrain.values()[terrain]), new Location(r,c,h));
            }

            for(int h = 0; h < height; h++){
                for(int c =0; c < col; c++){
                    for(int r = 0; r < row; r++) {

                    }
                }
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        LoadMap.loadMap("res\\Map\\Map.txt");
    }

}