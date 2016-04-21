package models.Skill.SneakSkill;
import java.util.Map;
import models.Entity.*;


public class PickPocket extends SneakSkill {

    private Entity avatar;

    public PickPocket() {
        super("Pick Pocket", 10.0);
    }

    public void activate(Entity entity) {
        if (entity != null) {

        }
       // avatar.addItem(entity.getRandomItem());
    }

    public void createSignal(models.Map.Map map, Entity entity) {

    }

    public boolean canUseSkill(Entity entity) {
        boolean canPerform = canPerform();
        double hasEnoughMana = 100;
        if (hasEnoughMana >= manaCost && canPerform) {
            Map<String, Double> modifyManaCostMap = getManaCostMap();
            entity.modifyStats(modifyManaCostMap);
            avatar = entity;
            return true;
        }
        return false;
    }
}
