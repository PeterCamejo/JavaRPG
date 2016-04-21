package models.SkillContainer;
import models.Skill.*;
import java.util.ArrayList;


public abstract class SkillContainer {

    protected ArrayList<Skill> listOfSkills;
    protected ArrayList<Skill> listOfSkillsNotAdded;

    public SkillContainer() {
        listOfSkills = new ArrayList<>();
        listOfSkillsNotAdded = new ArrayList<>();
    }

    protected void addSkillToList(Skill skill) {
        listOfSkills.add(skill);
    }

    protected void addSkillToListNotAdded(Skill skill) {
        listOfSkillsNotAdded.add(skill);
    }

    public void addSkill(Skill skill) {
        if (listOfSkillsNotAdded.contains(skill)) {
            int indexOfSkill = listOfSkillsNotAdded.indexOf(skill);
            listOfSkillsNotAdded.remove(indexOfSkill);
            listOfSkills.add(skill);
        }
    }

    public void setSkillDeactivated(Skill skill) {
        listOfSkills.remove(skill);
    }

    public void setSkillActive(Skill skill) {
        listOfSkills.add(skill);
    }

    public ArrayList<Skill> getListOfSkills() {
        return listOfSkills;
    }

    public Skill getSkill(int n) {
        return listOfSkills.get(n);
    }

}
