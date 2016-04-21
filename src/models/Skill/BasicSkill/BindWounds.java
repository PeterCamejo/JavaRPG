package models.Skill.BasicSkill;
import models.Entity.*;
import models.Signal.SkillSignal.SelfSkillSignal;

import java.util.HashMap;
import java.util.Map;


public class BindWounds extends BasicSkill {

    public BindWounds() {
        super("Bind Wounds", 5, "CURRENT_LIFE");
    }

    public void activate(Entity entity) {
        if (entity != null ) {
            Map<String, Double> healAmountMap = getHealAmountMap();
            entity.modifyStats(healAmountMap);
        }
    }

    public Map<String, Double> getHealAmountMap() {
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
