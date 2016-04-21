package models.Skill.SummonerSkill;
import models.Entity.*;


public class Enchantment extends SummonerSkill {


    public Enchantment() {
        super("Enchantment", 15, 3);
    }

    //make NPC go to sleep
    public void activate(Entity entity) {
        //entity.goToSleep();
    }

    public void createSignal(models.Map.Map map, Entity entity) {

    }

}
