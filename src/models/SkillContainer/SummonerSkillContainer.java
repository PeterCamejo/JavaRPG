package models.SkillContainer;
import models.Skill.SummonerSkill.*;
import models.Skill.Skill;

public class SummonerSkillContainer extends SkillContainer {

    public SummonerSkillContainer() {
        initializeBasicSkills();
        initializeBasicSkillsToAdd();
    }


    //this creates new skills for each basic skill and adds to list
    private void initializeBasicSkills() {
        Skill bane = new Bane();
        Skill boon = new Boon();
        Skill enchantment = new Enchantment();
        Skill staff = new Staff();

        addSkillToList(bane);
        addSkillToList(boon);
        addSkillToList(enchantment);
        addSkillToList(staff);
    }


    //this is to add skills that can be available to the avatars if they pick them up
    private void initializeBasicSkillsToAdd() {

    }
}
