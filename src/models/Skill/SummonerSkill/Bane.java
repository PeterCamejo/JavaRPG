package models.Skill.SummonerSkill;
import models.Entity.Entity;
import models.Signal.SkillSignal.RadialSkill.RadialPlanarSkillSignal;

import java.util.HashMap;
import java.util.Map;


public class Bane extends SummonerSkill {

    public Bane() {
        super("Bane", 5, 3);
    }

    public void activate(Entity entity) {
        if (entity != null) {
            Map<String, Double> damageModifyAmountMap = getDamageMap();
            entity.modifyStats(damageModifyAmountMap);
        }
    }

    public Map<String, Double> getDamageMap() {
        Map<String, Double> map = new HashMap<>();
        double modifyAmount = getModifyAmount();
        map.put("CURRENT_LIFE", -modifyAmount);
        return map;
    }

    public void createSignal(models.Map.Map map, Entity entity) {
        new RadialPlanarSkillSignal(map, entity, this);
    }

    private double getModifyAmount() {
        return level * 10 * calculatorMultiplier;
    }
}
