package models.Skill.SneakSkill;
import models.Entity.Entity;
import models.Skill.*;

public abstract class SneakSkill extends Skill {

    public SneakSkill(String name, double manaCost) {
        super(name, manaCost, 1);
    }

    public SneakSkill(String name, double manaCost, int radius) {
        super(name, manaCost, radius);
    }


}
