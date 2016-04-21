package models.StateModel;


import models.Occupation.Occupation;
import models.Skill.Skill;

import java.util.ArrayList;


public class SkillTreeModel{

    private ArrayList<Skill> basicSkills;
    private ArrayList<Skill> specificSkills;
    private ArrayList<Skill> activeSkills;
    private Skill tmpSkill;

    private int currentPoint;
    private int currentActive;
    private int size;
    private Occupation occupation;

    public SkillTreeModel(Occupation occupation){
        this.occupation = occupation;
        currentPoint = 0;
        currentActive = -1;
        basicSkills = new ArrayList<>();
        specificSkills = new ArrayList<>();
        activeSkills = new ArrayList<>();
        tmpSkill = null;
        initLists();
        size = basicSkills.size() + specificSkills.size();
    }

    public void initLists() {

        basicSkills = occupation.getBasicSkill();
        specificSkills = occupation.getSpecificSkills();
        activeSkills = occupation.getActiveSkills();
    }

    public void up() {
        if (currentActive == -1) {
            currentPoint--;
            if (currentPoint < 0) {
                currentPoint = size - 1;
            }
        }
        else {
            currentActive--;
            if (currentActive < 0) {
                currentActive = 3;
            }
        }
    }

    public void down() {
        if (currentActive == -1) {
            currentPoint++;
            if (currentPoint == size) {
                currentPoint = 0;
            }
        }
        else {
            currentActive++;
            if (currentActive == 4) {
                currentActive = 0;
            }
        }
    }

    public int getCurrentPoint() {
        return currentPoint;
    }

    public int getCurrentActive() {
        return currentActive;
    }

    public void levelUp() {
        if (currentActive == -1) {
            if (occupation.getSkillPoints() > 0) {
                getSkill(currentPoint).levelUpSkill();
                occupation.useSkillPoint();
                initLists();
            }
        }
    }

    public String getSkillPoints() {
        return Integer.toString(occupation.getSkillPoints());
    }

    private String getBasicSkillName(int n) {
        return basicSkills.get(n).getName();
    }

    private String getBasicSkillLevel(int n) {
        return Integer.toString(basicSkills.get(n).getLevel());
    }

    private String getBasicString(int n) {
        return getBasicSkillName(n) + ": " + getBasicSkillLevel(n);
    }


    private String getSpecificSkillName(int n) {
        return specificSkills.get(n).getName();
    }

    private String getSpecificSkillLevel(int n) {
        return Integer.toString(specificSkills.get(n).getLevel());
    }

    private String getSpecificString(int n) {
        return getSpecificSkillName(n) + ": " + getSpecificSkillLevel(n);
    }

    public String getSkillString(int n) {
        if (n < 3) {
            return getBasicString(n);
        }
        else {
            n = n - 3;
            return getSpecificString(n);
        }
    }

    private Skill getSkill(int n) {
        if (n < 3) {
            return basicSkills.get(n);
        }
        else {
            n = n - 3;
            return specificSkills.get(n);
        }
    }


    public int getListSize() {
        return size;
    }

    public String getActiveSkill(int n) {
        return activeSkills.get(n).getName();
    }

    public void setActive() {
        if (currentActive == -1) {
            tmpSkill = getSkill(currentPoint);
            currentPoint = -1;
            currentActive = 0;
        }
        else {
            Skill skilltoRemove = activeSkills.get(currentActive);
            if (!activeSkills.contains(tmpSkill)) {
                occupation.replaceActiveSkill(skilltoRemove, tmpSkill);
            }
            currentPoint = 0;
            currentActive = -1;
        }
    }

}
