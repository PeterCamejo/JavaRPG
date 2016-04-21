package utilities.Location;

/**
 * Created by walkhard on 4/7/16.
 */
public class Location {

    public static final int ROW_MAX_LENGTH = 1000;
    public static final int COL_MAX_LENGTH = 1000;
    public static final int HEIGHT_MAX_LENGTH = 100;

    //REQUIRE TO BE NEGATIVE FOR THE hashCode to work
    public static final int ROW_MIN_LENGTH = -1000;
    public static final int COL_MIN_LENGTH = -1000;
    public static final int HEIGHT_MIN_LENGTH = -100;

    private static final int ROW_COUNT = ROW_MAX_LENGTH - ROW_MIN_LENGTH;
    private static final int COL_COUNT = COL_MAX_LENGTH - COL_MIN_LENGTH;
    private static final int HEIGHT_COUNT = HEIGHT_MAX_LENGTH - HEIGHT_MIN_LENGTH;

    private int row;
    private int col;
    private int height;


    public Location(int row, int col, int height){
        if(row < ROW_MIN_LENGTH){
            this.row = ROW_MIN_LENGTH;
        }
        else if(row > ROW_MAX_LENGTH){
            this.row = ROW_MAX_LENGTH;
        }
        else {
            this.row = row;
        }

        if(col < COL_MIN_LENGTH){
            this.col = COL_MIN_LENGTH;
        }
        else if(col > COL_MAX_LENGTH){
            this.col = COL_MAX_LENGTH;
        }
        else {
            this. col = col;
        }

        if(height < HEIGHT_MIN_LENGTH){
            this.height = HEIGHT_MIN_LENGTH;
        }
        else if(height > HEIGHT_MAX_LENGTH){
            this.height = HEIGHT_MAX_LENGTH;
        }
        else {
            this.height = height;
        }
    }

    public int getRow(){return row;}
    public int getCol(){return col;}
    public int getHeight(){return height;}


    public Location sub(Location point){
        return sub(point.getRow(),point.getCol(),point.getHeight());
    }

    public Location sub(int row, int col, int height){
        return new Location(this.row - row, this.col - col, this.height - height);
    }

    public Location add(Location point){
        return add(point.getRow(),point.getCol(),point.getHeight());
    }

    public Location add(int row, int col, int height){
        return new Location(this.row + row, this.col + col, this.height + height);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Location){
            Location loc = (Location)o;
            return this.row == loc.getRow() &&
                    this.col == loc.getCol() &&
                    this.height == loc.getHeight();
        }
        return false;
    }

    @Override
    public String toString(){
        return "row: " + row + " col: " + col + " height: " + height;
    }

    @Override
    public int hashCode(){
        int value = (row - ROW_MIN_LENGTH);
        value += (col - COL_MIN_LENGTH)*(ROW_COUNT + 1);
        value += (height - HEIGHT_MIN_LENGTH)*((ROW_COUNT+1)*(COL_COUNT+1));
        return value;
    }
}