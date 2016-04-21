package models.Skill.BasicSkill;
import models.Entity.Entity;
import models.Skill.*;


public abstract class BasicSkill extends Skill {

    protected String statAbv;

    public BasicSkill(String name, double manaCost, String abv) {
        super(name, manaCost, 0);
        statAbv = abv;
    }
    public abstract void activate(Entity entity);
}
