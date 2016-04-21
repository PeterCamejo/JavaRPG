package models.Signal.SkillSignal;

import models.Entity.Entity;
import models.Map.Map;
import models.Skill.Skill;
import models.Skill.SummonerSkill.Staff;
import utilities.Direction.Direction;
import utilities.Location.Location;

import java.util.HashMap;


public abstract class SkillSignal {

    protected Map map;
    protected Entity avatar;
    protected int radius;
    protected int currentRadius;
    protected Skill skill;

    protected Location avatarLocation;
    protected Direction direction;


    public SkillSignal(Map map, Entity avatar, Skill skill) {
        this.map = map;
        this.avatar = avatar;
        this.skill = skill;

        radius = skill.getRadius();
        currentRadius = 0;
        setAvatarLocations();
        useSkill(skill);
    }

    private void setAvatarLocations() {
        avatarLocation = avatar.getLocation();
        direction = avatar.getDirection();
    }

    protected void checkForExperienceGain(Entity entityToAttack) {
        if (entityToAttack == null ) {
            return;
        }
//        HashMap<String, Double> map = new HashMap<>();
//        double xpToGain = entityToAttack.getExperience();
//        map.put("CURRENT_EXPERIENCE", xpToGain);
//        avatar.modifyStats(map);
//        avatar.levelUpIfReady();
    }

    protected abstract void useSkill(Skill skill);

}
