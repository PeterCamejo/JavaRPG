package models.Skill.SneakSkill;
import models.Entity.*;

public class DetectRemoveTrap extends SneakSkill {

    public DetectRemoveTrap() {
        super("Detect and Remove Trap", 5);
    }

    public void activate(Entity entity) {
        if (entity != null) {

        }
        //avatar.addItem(entity.getRandomItem());
    }

    public void createSignal(models.Map.Map map, Entity entity) {

    }
}
