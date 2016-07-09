package models.Stat;

public class Stat {
    /* Attributes */
    private int lives;
    private double strength;
    private double agility;
    private double intellect;
    private double stamina;
    private double experience;
    private double movement;

    private int level; //based off experience
    private double maxHealth; //based on level and hardiness;
    private double maxMana; //based on level and intellect;
    private double attackRating; //based on strength, and level;
    private double dodgeRating; //based on agility and level;


    private double expNeeded;   //experience needed to level up

    private double currentHealth;
    private double currentMana;

    //Equipment
    private double armorRating;
    private double weaponDamage;

    //Movement Privileges
    private Boolean groundMovement;
    private Boolean waterMovement;
    private Boolean airMovement;

    /* Constructor */
    public Stat(){
        lives = 1;
        strength = 0;
        agility = 0;
        intellect = 0;
        stamina = 0;
        experience = 0;
        movement = 3;
        armorRating = 0;
        weaponDamage = 0;
        level = 1;
        expNeeded = 100;
        groundMovement = true;
        waterMovement = airMovement = false;

        update();
        currentHealth = maxHealth;
        currentMana  = maxMana;
    }
    //Level 1. Meant for Avatar Creation
    public Stat( int lives , double strength , double agility , double intellect , double stamina , double movement , Boolean groundMovement , Boolean waterMovement){
        this.lives = lives;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.stamina = stamina;
        this.movement = movement;
        this.experience = 0;
        this.weaponDamage = 0;
        this.armorRating = 0;
        this.level = 1;
        this.experience = 0;
        this.expNeeded = 100;
        this.groundMovement = groundMovement;
        this.waterMovement = waterMovement;


        update();
        currentHealth = maxHealth;
        currentMana = maxMana;
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
        maxHealth = stamina + level * 3;

        //Calculate MaxMana
        maxMana = intellect + level * 3;

        //Calculate dodgeRating
        dodgeRating = agility + level * 3;

        //Calculate attackRating
        attackRating = weaponDamage + strength + level * 3;
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

    public void modifyStamina(double modifier){
        if(stamina + modifier > 0){
            stamina += modifier;
        }else{
            stamina = 0;
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

    //Current Health
    public void modifyHealth(double modifier){
        if(currentHealth + modifier < 0){
            currentHealth = 0;
        }else if(currentHealth + modifier > maxHealth){
            currentHealth = maxHealth;
        }else{
            currentHealth+=modifier;
        }
    }

    //Current Mana
    public void modifyMana(double modifier){
        if(currentMana + modifier < 0){
            currentMana = 0;
        }else if(currentMana + modifier > maxMana){
            currentMana = maxMana;
        }else{
            currentMana += modifier;
        }
    }

    public void modifyWeaponDamage(double modifier){
        if(weaponDamage + modifier > 0){
            weaponDamage += modifier;
        }else{
            weaponDamage = 0;
        }
    }

    public void modifyArmorRating(double modifier){
        if(armorRating + modifier > 0){
            armorRating += modifier;
        }else{
            armorRating = 0;
        }
    }

    public void modifyGroundMovement(Boolean bool){
        this.groundMovement = bool;
    }

    public void modifyWaterMovement(Boolean bool){
        this.waterMovement = bool;
    }

    public void modifyAirMovement(Boolean bool){
        this.airMovement = bool;
    }

    public void levelUp(){
        this.experience = this.expNeeded;
    }

    public int getLives(){ return this.lives;}
    public double getStrength(){ return this.strength;}
    public double getAgility(){ return this.agility;}
    public double getIntellect(){ return this.intellect;}
    public double getStamina(){ return this.stamina;}
    public double getExperience(){ return this.experience; }
    public double getMovement(){return this.movement;}
    public int getLevel(){ return this.level;}
    public double getMaxHealth(){ return this.maxHealth;}
    public double getMaxMana(){ return this.maxMana;}
    public double getAttackRating(){ return this.attackRating;}
    public double getDodgeRating(){ return this.dodgeRating;}
    public double getCurrentHealth(){ return this.currentHealth;}
    public double getCurrentMana(){ return this.currentMana;}
    public Boolean getGroundMovement(){ return this.groundMovement;}
    public Boolean getWaterMovement(){ return this.waterMovement;}
    public Boolean getAirMovement(){ return this.airMovement;}

}