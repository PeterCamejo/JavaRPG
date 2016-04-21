package models.Signal.SkillSignal.RadialSkill;

import models.Decal.Decal;
import models.Decal.FireBallDecal;
import models.Entity.Entity;
import models.Map.Map;
import models.Signal.SkillSignal.SkillSignal;
import models.Skill.Skill;
import utilities.Direction.Direction;
import utilities.Location.Location;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public abstract class RadialSkill extends SkillSignal {

    Direction dir;

    public RadialSkill(Map map, Entity avatar, Skill skill) {
        super(map, avatar, skill);
        dir = avatar.getDirection();
    }


    protected void useSkill(Skill skill) {

        Decal decal = new FireBallDecal();

        if (skill.canUseSkill(avatar)) {
            Timer t = new Timer();
            t.schedule(new TimerTask() {
                ArrayList<Location> nextLocation = new ArrayList<Location>();
                ArrayList<Location> allLocation = new ArrayList<Location>();

                public void run() {

                    nextLocation.add(avatarLocation);
                    allLocation.add(avatarLocation);

                    for (int i = 0; i < nextLocation.size(); ++i) {
                        map.getTileAt(nextLocation.get(i)).removeDecal();
                    }

                    nextLocation = getLocationArray2(allLocation, currentRadius);
                    allLocation.addAll(nextLocation);

                    for (int i = 0; i < nextLocation.size(); ++i) {
                        Location locationToAttack = nextLocation.get(i);
                        map.getTileAt(locationToAttack).addDecal(decal);
                        Entity entityToAttack = map.getTileAt(locationToAttack).getEntity();
                        skill.activate(entityToAttack);
                        checkForExperienceGain(entityToAttack);
                    }

                    currentRadius++;
                    if (currentRadius == 4) {
                        for (int i = 0; i < nextLocation.size(); ++i) {
                            map.getTileAt(nextLocation.get(i)).removeDecal();
                        }
                        t.cancel();
                    }

                }
            }, 0, 1000);
        }
    }


    protected abstract ArrayList<Location> getLocationArray2(ArrayList<Location> list, int n);

}
