package controllers;

import AI.AIController;
import models.Entity.Entity;
import models.Entity.NPC;
import models.Map.Map;
import utilities.Location.Location;

/**
 * Created by denzel on 4/17/16.
 */
public class NPCController extends AIController{

    public NPCController(NPC npc,Map map){
        super(npc,map);
    }

    @Override
    public void reset() {

    }

    @Override
    public void act() {

        //Have the entity
        NPC npc = (NPC)getEntity();

        if(npc.getCurrentState() == Entity.States.WANDER){
            npc.setLocation(new Location(0,1,0));
        }else{
            System.out.println("wtf am I doing");
        }
    }
}
