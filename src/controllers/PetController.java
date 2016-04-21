package controllers;

import AI.AIController;
import AI.FSM;
import AI.FSMState;
import models.Entity.Avatar;
import models.Map.Map;
import models.Skill.Skill;
import utilities.Location.Location;

/**
 * Created by denzel on 4/16/16.
 */
public class PetController extends AIController {


    public Locomotion petLoco;
    private Pet pet;
    private double rand;
    long wait = 300;
    long lastTimer = System.currentTimeMillis();

    public PetController(Pet pet, Map map, Avatar avatar) {
        super(pet, map);
        this.pet = pet;
        pet.setOwnership(avatar);
        //movement controller
        petLoco = new Amphibious(pet, map);

        rand = Math.random();
    }

    public Skill getSpecificSkill(int number){
        return pet.getOccupation().getSpecificSkills().get(number);
    }

    @Override
    public void reset() {

    }

    @Override
    public void act() {

        //Have the entity
        Pet pet = (Pet) getEntity();

        //Get Avatars Location
        Location avatarLocation = pet.getAvatarLocation();


        long nowTime = System.currentTimeMillis();
//
//        if(pet.getAvatarLocation() != pet.getLocation()){
//
//            if(rand > 0.75){
//                System.out.println("Pet: " + pet.getLocation().getRow());
////                petLoco.move(Direction.South);
//            }
//            else if(rand > 0.1){
//                System.out.println("North Pet: " + pet.getLocation().getRow());
//                petLoco.move(Direction.North);
//            }
//        }
    }
}
