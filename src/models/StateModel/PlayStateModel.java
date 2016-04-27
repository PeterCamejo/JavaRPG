package models.StateModel;


import AI.AIController;
import controllers.NPCController;
import controllers.PetController;
import models.AreaEffect.*;
import models.Entity.Avatar;
import models.Entity.Entity;
import models.Entity.NPC;
import models.Item.Armors.ChestArmor;
import models.Item.Armors.HeadArmor;
import models.Map.Map;
import models.Map.MapEditor.MapOperator;
import models.Occupation.Sneak;
import models.Occupation.Summoner;
import utilities.Direction.Direction;
import utilities.Location.Location;
import views.*;


import java.util.ArrayList;


/**
 * Created by jcvarela on 4/15/2016.
 */
public class PlayStateModel{

    private Location focus;
    private Entity avatar;
    private MapOperator mapOperator;
    private StatusView statusView;
    private ArrayList<AIController> entityController = new ArrayList<>();
    private Location startLocation;

    private Pet pet;

    public PlayStateModel(Entity avatar) {
        Assets.init();

        this.avatar = avatar;
        this.startLocation = new Location(44,0,0);

        mapOperator = new MapOperator(20,20,10);

        //TODO Place any model instantiation here
        Pet pet = new Pet(3,new Sneak());
        NPC npc = new NPC(3,new Summoner());
        Location l = new Location(47,0,0);

        Location l2 = new Location(48,3,0);
        LoseHealth lh = new LoseHealth(l,20);
        mapOperator.addNewAreaEffect(lh,l2);
        mapOperator.addDecalForTakeDamage(l2);

        Location l3 = new Location(48,0,0);
        InstantDeath id = new InstantDeath(l);
        mapOperator.addNewAreaEffect(id,l3);
        mapOperator.addDecalForInstantDeath(l3);

        Location from = new Location(48,2,0);
        Location to = new Location(36,0,4);
        Teleport tp = new Teleport(from, to, getMap());
        mapOperator.addNewAreaEffect(tp,from);
        mapOperator.addDecalForTeleport(from);

        Location l5 = new Location(48,5,0);
        LevelUp lu = new LevelUp(l5, 1);
        mapOperator.addNewAreaEffect(lu,l5);
        mapOperator.addDecalForLevelUp(l5);

        Location l6 = new Location(45,3,0);
        GainHealth gh = new GainHealth(l6,20);
        mapOperator.addNewAreaEffect(gh,l6);
        mapOperator.addDecalForGainHealth(l6);

        //Trap tp = new Trap(l); //not working yet


        // For observers
        mapOperator.addEntityObserver(avatar);
        mapOperator.addEntityObserver(pet);
        mapOperator.addEntityObserver(npc);

        statusView = new StatusView(avatar);

        focus  = new Location(0,0,0);

        //TODO Place any model instantiation here
        pet = new Pet(3,new Summoner());
        PetController petController = new PetController(pet,mapOperator.getMap(),(Avatar)avatar);
        entityController.add(petController);





        //NPC npc = new NPC(3,new Summoner());
        NPCController npcController = new NPCController(npc,mapOperator.getMap());
        entityController.add(npcController);

        mapOperator.addNewEntityAt(avatar, startLocation);
        mapOperator.addNewEntityAt(pet,new Location(43,5,0));
        mapOperator.addNewEntityAt(npc, new Location(44,4,0));

        mapOperator.addItemAt(new HeadArmor(),new Location(46,7,0));
        mapOperator.addItemAt(new ChestArmor(),new Location(44,9,0));

        //setDefaultFocus();
    }

    public void setDefaultFocus(){
        setFocus(avatar.getLocation());
    }
    public void setFocus(Location focus){
        this.focus = focus;
    }
    public Location getFocus(){return avatar.getLocation();}

    public Entity getAvatar(){return avatar;}
    public MapView getMapView() {
        return mapOperator.getMapView();
    }
    public Map getMap() {
        return mapOperator.getMap();
    }

    public StatusView getStatusView() {
        return statusView;
    }

//    //TODO:fast function, remove
    public void setFocusDirection(Direction dir){
       avatar.changeLocation(dir.getNextLocation(avatar.getLocation()));
        avatar.changeDirection(dir);
        //avatar.setAction(Action.Move);
    }

    //get the entity controllers
    public ArrayList<AIController> getEntityControllers(){
        return entityController;
    }

    public void update() {

    }
}
