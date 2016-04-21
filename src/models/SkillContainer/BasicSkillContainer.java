package models.SkillContainer;
import models.Skill.BasicSkill.*;
import models.Skill.Skill;

public class BasicSkillContainer extends SkillContainer {

    public BasicSkillContainer() {
        initializeBasicSkills();
        initializeBasicSkillsToAdd();
    }


    //this creates new skills for each basic skill and adds to list
    private void initializeBasicSkills() {
        Skill bargain = new Bargain();
        Skill bindWounds = new BindWounds();
        Skill observation = new Observation();

        addSkillToList(bargain);
        addSkillToList(bindWounds);
        addSkillToList(observation);
    }


    //this is to add skills that can be available to the avatars if they pick them up
    private void initializeBasicSkillsToAdd() {

    }
}
