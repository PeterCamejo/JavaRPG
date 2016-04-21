package models.Signal.SkillSignal;

import models.Decal.CircleDash;
import models.Decal.Decal;
import models.Decal.FireBallDecal;
import models.Entity.Entity;
import models.Map.Map;
import models.Skill.Skill;
import utilities.Location.Location;

import java.util.Timer;
import java.util.TimerTask;


public class LinearSkillSignal extends SkillSignal {



    public LinearSkillSignal(Map map, Entity avatar, Skill skill) {
        super(map, avatar, skill);
    }


    protected void useSkill(Skill skill) {

        Decal decal = new CircleDash();

       if (skill.canUseSkill(avatar)) {
            Timer t = new Timer();
            t.schedule(new TimerTask() {
                public void run() {
                    currentRadius++;

                    map.getTileAt(avatarLocation).removeDecal();
                    Location nextLocation = direction.getNextLocation(avatarLocation);

                    if (!map.isOutOfBound(nextLocation)) {

                        if (map.getTileAt(nextLocation).isMountain()) {
                            currentRadius = radius;
                        } else {
                            map.getTileAt(nextLocation).addDecal(decal);
                            Entity entityToAttack = map.getTileAt(nextLocation).getEntity();

                            skill.activate(entityToAttack);
                            checkForExperienceGain(entityToAttack);

                            avatarLocation = nextLocation;
                        }
                    }
                    if (currentRadius == radius) {
                        map.getTileAt(avatarLocation).removeDecal();
                        t.cancel();
                    }
                }
            }, 0, 1000);
       }
    }


}
