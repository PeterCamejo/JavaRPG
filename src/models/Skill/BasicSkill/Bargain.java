package models.Skill.BasicSkill;
import models.Entity.*;
import models.Signal.SkillSignal.SelfSkillSignal;

import java.util.HashMap;
import java.util.Map;


public class Bargain extends BasicSkill {

    public Bargain() {
        super("Bargain", 5, "BARGAIN");
    }

    public void activate(Entity entity) {
        if (entity != null) {
            Map<String, Double> bagainSkillAmountMapModifier = getBargainSkillAmountMap();
            entity.modifyStats(bagainSkillAmountMapModifier);
        }
    }

    public Map<String, Double> getBargainSkillAmountMap() {
        Map<String, Double> map = new HashMap<>();
        double modifyByAmount = getModifyAmount();
        map.put(statAbv, modifyByAmount);
        return map;
    }

    public void createSignal(models.Map.Map map, Entity entity) {
        new SelfSkillSignal(map, entity, this);
    }

    protected double getModifyAmount() {
        return calculatorMultiplier * level * 10;
    }

}
