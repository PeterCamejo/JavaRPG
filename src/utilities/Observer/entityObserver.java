package utilities.Observer;

import models.Entity.Entity;
import models.Map.MapEditor.MapOperator;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by clayhausen on 4/18/16.
 */
public class entityObserver implements Observer {

    private MapOperator mapOperator;
    private Entity entity;
    private double lives;

    public entityObserver(MapOperator mapOperator, Entity entity) {
        this.mapOperator = mapOperator;
        this.entity = entity;
    }

    @Override
    public void update(Observable o, Object arg) {
            double oldLives = this.lives;
            this.lives = entity.getLives();
            // if entity has lost a life
            if (lives < oldLives) {
                mapOperator.handleDeath(this);
            }
    }

    public Entity getEntity() {
        return entity;
    }
}
