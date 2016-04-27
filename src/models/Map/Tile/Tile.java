package models.Map.Tile;

import models.AreaEffect.AreaEffect;
import models.Entity.Entity;
import models.Item.TakeableItem;

/**
 *
 */
public abstract class Tile {
    /* Attributes */
    protected int height;
    protected Tile bottomTile;
    protected Tile topTile;
    protected Tile northTile;
    protected Tile southTile;
    protected Tile southEastTile;
    protected Tile northEastTile;
    protected Tile southWestTile;
    protected Tile northWestTile;

    protected Entity entity;
    protected TakeableItem item;
    protected AreaEffect areaEffect;

    /* Constructor */

    /* Methods */
    public abstract void sendEntityNorth(Entity entity);
    public abstract void sendEntitySouth(Entity entity);
    public abstract void sendEntitySouthEast(Entity entity);
    public abstract void sendEntitySouthWest(Entity entity);
    public abstract void sendEntityNorthEast(Entity entity);
    public abstract void sendEntityNorthWest(Entity entity);

    public abstract Boolean receieveEntityFromNorth(Entity entity);
    public abstract Boolean receiveEntityFromSouth(Entity entity);
    

}
