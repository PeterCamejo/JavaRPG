package utilities.KeyCommand;
import models.Entity.Entity;
import controllers.Locomotion;
import models.Map.Map;
import utilities.Direction.Direction;
import models.Map.Tile;
import utilities.Location.Location;

/**
 * Created by clayhausen on 4/13/16.
 */

/** Responsibilities: checks for obstacles preventing Entity unit,
 *  then tells its Entity to move, passing it the Terrain it's moving to.
 */
public class MovementKeyCommand implements KeyCommand {

    private Map map;
    private Entity entity;
    private Direction direction;
    private Locomotion locomotion;

    public MovementKeyCommand(Map map, Entity entity, Direction direction, Locomotion locomotion) {
        this.map = map;
        this.entity = entity;
        this.direction = direction;
        this.locomotion = locomotion;
    }


    @Override
    public void execute() {
        entity.changeDirection(direction);
        locomotion.move(direction);
    }

}
