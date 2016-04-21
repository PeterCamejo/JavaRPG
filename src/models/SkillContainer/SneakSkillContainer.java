package models.SkillContainer;
import models.Skill.SneakSkill.*;
import models.Skill.Skill;

public class SneakSkillContainer extends SkillContainer {

    public SneakSkillContainer() {
        initializeBasicSkills();
        initializeBasicSkillsToAdd();
    }


    //this creates new skills for each basic skill and adds to list
    private void initializeBasicSkills() {
        Skill detectRemoveTrap = new DetectRemoveTrap();
        Skill pickPocket = new PickPocket();
        Skill rangedWeapon = new RangedWeapon();
        Skill creep = new Creep();

        addSkillToList(detectRemoveTrap);
        addSkillToList(pickPocket);
        addSkillToList(rangedWeapon);
        addSkillToList(creep);
    }


    //this is to add skills that can be available to the avatars if they pick them up
    private void initializeBasicSkillsToAdd() {

    }
}
