package models.Skill.SummonerSkill;
import models.Entity.*;
import models.Signal.SkillSignal.LinearSkillSignal;

import java.util.HashMap;
import java.util.Map;


public class Staff extends SummonerSkill {

    public Staff() {
        super("Staff", 0, 1);
    }

    public void activate(Entity entity) {
        if (entity != null) {
            Map<String, Double> damageAmountMap = getDamageAmountMap();
            entity.modifyStats(damageAmountMap);
        }
    }

    public Map<String, Double> getDamageAmountMap() {
        Map<String, Double> map = new HashMap<>();
        double modifyAmount = getModifyAmount();
        map.put("CURRENT_LIFE", -modifyAmount);
        return map;
    }

    public void createSignal(models.Map.Map map, Entity entity) {
        new LinearSkillSignal(map, entity, this);
    }

    private double getModifyAmount() {
        return level * 3 * calculatorMultiplier;
    }
}
