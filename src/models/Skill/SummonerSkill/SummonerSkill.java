package models.Skill.SummonerSkill;
import models.Entity.Entity;
import models.Skill.*;

public abstract class SummonerSkill extends Skill {

    public SummonerSkill(String name, double manaCost, int radius) {
        super(name, manaCost, radius);
    }

    public abstract void activate(Entity entity);
}
