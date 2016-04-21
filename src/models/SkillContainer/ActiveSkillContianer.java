package models.SkillContainer;

import models.Skill.Skill;

import java.util.ArrayList;

/**
 * Created by Matthew on 4/13/2016.
 */
public class ActiveSkillContianer extends SkillContainer {

    public ActiveSkillContianer(SkillContainer basicSkillContianer, SkillContainer occupationSkillContainer){
        ArrayList<Skill> basicSkillContainerListOfSkills = basicSkillContianer.getListOfSkills();
        ArrayList<Skill> occupationSkillContainerListOfSkills = occupationSkillContainer.getListOfSkills();

        setSkillActive(basicSkillContainerListOfSkills.get(1));
        setSkillActive(basicSkillContainerListOfSkills.get(2));

        setSkillActive(occupationSkillContainerListOfSkills.get(0));
        setSkillActive(occupationSkillContainerListOfSkills.get(1));
    }

    public void setSkillActive(Skill skill) {
        listOfSkills.add(skill);
    }

    public void setSkillDeactivated(Skill skill) {
        listOfSkills.remove(skill);
    }

}
