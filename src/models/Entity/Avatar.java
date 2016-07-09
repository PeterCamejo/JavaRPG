package models.Entity;

import models.Equipment.Equipment;
import models.Inventory.Inventory;
import models.Location;
import models.Map.Tile.Tile;
import models.Movement;
import models.Stat.Stat;

/**
 * Created by The Alex on 4/23/2016.
 */
public class Avatar extends Entity {
    /* Constructor */
    public Avatar(){
        super();
    }

    public Avatar(String name , String occupation , Stat stats, Inventory inventory , Equipment equipment , Tile currentTile , Location location , Movement movement){
        super(name, occupation, stats , inventory, equipment ,currentTile ,location , movement);
    }

    public Avatar(String name,  String occupation , Stat stats){
        super(name, occupation , stats);
    }


}
