package models.Action;

import models.Entity.Entity;

/**
 * Created by walkhard on 4/7/16.
 */
public interface Action {
    //
    void talk();
    void attack();
    void useSkill(Entity entity);
    void useItem(Entity entity);
}

