package controllers;


import models.Entity.Entity;
import models.Skill.Skill;

import java.util.ArrayList;

public class StatusViewController {

    private Entity avatar;

    private String health;
    private String mana;
    private String lives;

    private String skill1;
    private String skill2;
    private String skill3;
    private String skill4;

    public StatusViewController(Entity avatar) {
        initVariables(avatar);
    }

    public void initVariables(Entity avatar) {
        this.avatar = avatar;

        health = Integer.toString((int) (avatar.getStatContainer().value("CURRENT_LIFE")));
        mana = Integer.toString((int) (avatar.getStatContainer().value("CURRENT_MANA")));
        lives = Integer.toString((int) (avatar.getStatContainer().value("CURRENT_LIVES")));

        ArrayList<Skill> list = avatar.getOccupation().getActiveSkills();
        skill1 = list.get(0).getName();
        skill2 = list.get(1).getName();
        skill3 = list.get(2).getName();
        skill4 = list.get(3).getName();
    }

    public void updateVariables() {
        initVariables(avatar);
    }


    public String getStatsString() {
        return "Health:" + health + " Mana:" + mana + " Lives:" + lives;
    }

    public String getSkillsString() {
        return "1:" + skill1 + " 2:" + skill2 + " 3:" + skill3 + " 4:" + skill4;
    }
}
