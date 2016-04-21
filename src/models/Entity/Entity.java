package models.Entity;


import models.Action.Action;
import models.Skill.Skill;
import utilities.Direction.Direction;
import models.Occupation.*;
import models.StatContainer.*;
import models.Item.*;


import java.awt.*;
import java.util.Map;
import java.util.Observable;

import models.Inventory.*;
import models.Equipment.Equipment;
import utilities.Location.Location;

public abstract class Entity extends Observable implements Action {

    protected String name;
    protected Location location;
    protected Direction direction;
    protected Occupation occupation;
    protected StatContainer stats;
    protected Inventory inventory;
    protected Equipment equipment;
    private States state;

    public enum States{
        WANDER,
        ATTACK
    }

    /*
        Methods used in constructors
     */
    //
    public void setName(String name) {this.name = name;}
    public void setLocation(Location location) {this.location = location;
        }
    public void setDirection(Direction direction) {this.direction = direction;}
    public void setOccupation(Occupation occupation) {this.occupation = occupation;}
    public void setStats(StatContainer stats) {this.stats = stats;}
    public void setInventory(Inventory inventory) {this.inventory = inventory;}
    public void setEquipment(Equipment equipment){this.equipment = equipment;}

    //state functions
    public States getCurrentState(){ return state;}
    public void setCurrentState(States state){
        this.state = state;
    }

    //protected void setEquipment(models.Equipment equipment) {this.equipment = equipment;)

    /*
        Action << interface >> implementation
     */
    //
    public void useSkill(Entity entity) {}
    public void useItem(Entity entity) {}
    public void attack() {}
    public void talk() {}

    /*
        models.Entity specific functionality
     */
    //
    public String name() {return this.name;}
    public void print() {
        System.out.println(name() + ": " + statName("LEVEL") + " " + (int)statValue("LEVEL") + " " + occupationName());
    }

    /*
        Location specific functionality
     */
    //
    public Location getLocation() { return this.location; }
    public void changeLocation(Location location) { this.location = location; }

    /*
        models.Direction specific functionality
     */
    //
    public Direction getDirection() {return this.direction;}
    public void changeDirection(Direction direction) {this.direction = direction;}

    /*
        models.models.Occupation specific functionality
     */
    //
    public String occupationName() {return this.occupation.name();}
    protected Map<String, Double> occupationModifier() {return this.occupation.occupationModifier();}

    public Occupation getOccupation() {
        return occupation;
    }

    /*
        models.StatContainer specific functionality
     */
    //
    public void modifyStats(Map<String, Double> stat_to_modify) {
        this.stats.modifyStats(stat_to_modify);
        // for observable
        setChanged();
        notifyObservers();
    }
    public void levelUp() {
        this.stats.levelUp();
        occupation.addSkillPoints();
    }
    public double statValue(String stat_to_get) {return this.stats.value(stat_to_get);}
    public String statName(String stat_to_get) {return this.stats.name(stat_to_get);}
    public void printStats(String stat_to_print) {this.stats.print(stat_to_print);}
    public void printStats() {this.stats.print();}
    public double getLevel(){ return this.stats.value("LEVEL");}
    public StatContainer getStatContainer() {
        return stats;
    }

    /*
          models.Equipment specific functionality
       */
    //
    public void equip(EquipableItem item) {
        item.equip(this, equipment , inventory);
    }
    public void unequip(EquipableItem item) {
        if(item == null){
            return;
        }
        item.unequip(this, equipment , inventory);
    }

    public Equipment getEquipment(){
        return this.equipment;
    }

    /*
        models.Inventory specific functionality
     */
    //
    public void addItem(TakeableItem item) {

        System.out.println("added item");
        inventory.addItem(item);
    }
    public void moveItem(Item item) {}
    public void dropItem(Item item) {
        inventory.removeItem(item.getId());
        //Place item on tile at this getLocation.
    }
    public void destroyItem(int id){
        inventory.removeItem(id);
    }
    public void useItem(TakeableItem item){
        if(item == null){
            return;
        }
        item.use(this);
    }

    public Inventory getInventory(){
        return this.inventory;
    }


    //skills
    public Skill getActiveSkill(int n) {
        return occupation.getActiveSkill(n);
    }


    public void levelUpIfReady() {
        double currXP = statValue("CURRENT_EXPERIENCE");
        double maxXP = statValue("EXPERIENCE");
        if (currXP >= maxXP) {
            levelUp();
        }
    }


    //Every entity is in charge of getting its own image
    public abstract Image getImage();

    public double getLives() {
        return this.stats.value("CURRENT_LIVES");
    }

}
