package models.Signal.SkillSignal;

import models.Decal.CircleDash;
import models.Decal.Decal;
import models.Entity.Entity;
import models.Map.Map;
import models.Skill.Skill;
import utilities.Location.Location;

import java.util.Timer;
import java.util.TimerTask;


public class SelfSkillSignal extends SkillSignal {


    public SelfSkillSignal(Map map, Entity avatar, Skill skill) {
        super(map, avatar, skill);
    }

    protected void useSkill(Skill skill) {
        if (skill.canUseSkill(avatar)) {

            Decal decal = new CircleDash();

            Timer t = new Timer();
            t.schedule(new TimerTask() {
                public void run() {
                    map.getTileAt(avatarLocation).addDecal(decal);
                    skill.activate(avatar);
                    if (currentRadius == 1) {
                        map.getTileAt(avatarLocation).removeDecal();
                        t.cancel();
                    }
                    currentRadius++;
                }
            }, 0, 1000);

        }
    }

}
