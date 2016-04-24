package models.Stat;

public abstract class Stat {
    /* Attributes */
    private int lives;
    private double strength;
    private double agility;
    private double intellect;
    private double hardiness;
    private double experience;
    private double movement;

    private double level; //based off experience
    private double maxHealth; //based on level and hardiness;
    private double maxMana; //based on level and intellect;
    private double attackRating; //based on strength, and level;
    private double dodgeRating; //based on agility and level;


    private double expNeeded;   //experience needed to level up

    private double currentHealth;
    private double currentMana;

    /* Constructor */
    public Stat(){
        lives = 0;
        strength = 0;
        agility = 0;
        intellect = 0;
        hardiness = 0;
        experience = 0;
        movement = 0;
        level = 1;
        expNeeded = 100;

        update();
        currentHealth = maxHealth;
        currentMana  = maxMana;
    }

    /* Methods */
    public void update(){
        //Calculate level
        if(experience >= expNeeded){
            experience -= expNeeded;
            expNeeded += (expNeeded/3);
            level++;
        }

        //Calculate MaxHealth
        maxHealth = hardiness + level * 3;

        //Calculate MaxMana
        maxMana = intellect + level * 3;

        //Calculate dodgeRating
        dodgeRating = agility + level * 3;

        //Calculate attackRating
        attackRating = strength + level * 3;
    }

    public void modifyLives(int modifier){
        if(lives + modifier > 0){
            lives += modifier;
        }else{
            lives = 0;
        }
    }

    public void modifyStrength(double modifier){
        if(strength + modifier > 0){
            strength+=modifier;
        }else{
            strength = 0;
        }
    }

    public void modifyAgility(double modifier){
        if(agility + modifier > 0 ){
            agility += modifier;
        }else{
            agility = 0;
        }
    }

    public void modifyIntellect(double modifier){
        if(intellect + modifier > 0){
            intellect += modifier;
        }else{
            intellect = 0;
        }
    }

    public void modifyHardiness(double modifier){
        if(intellect + modifier > 0){
            hardiness += modifier;
        }else{
            hardiness = 0;
        }
    }

    public void modifyExperience(double modifier){
        if(experience + modifier > 0){
            experience += modifier;
        }else{
            experience = 0;
        }
    }

    public void modifyMovement(double modifier){
        if(movement + modifier > 0){
            movement += modifier;
        }else{
            movement = 0;
        }
    }
}