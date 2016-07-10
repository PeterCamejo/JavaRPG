package models.Factories;

import models.Entity.Avatar;
import models.Location;
import models.Stat.Stat;

/**
 * Created by The Alex on 4/23/2016.
 */
public class EntityFactory {
    /* IDs */


    /* Methods */
    //Avatars
    public static Avatar getStartingAvatar(String name, String occupation){
        Avatar avatar = new Avatar();

        switch(occupation){
            case "Warrior":
                avatar =  getStartingWarriorAvatar(name);
                break;
            case "Mage":
                avatar = getStartingMageAvatar(name);
                break;
            case "Rogue":
                avatar = getStartingRogueAvatar(name);
                break;
        }

        return avatar;
    }

    public static Avatar getStartingWarriorAvatar(String name){
        Stat stats = new Stat(5 , 10 , 5 , 5 , 10 , 3 , true, false);
        Avatar avatar = new Avatar(name , "Warrior" , stats);
        avatar.setLocation(new Location(0 , 0 ));
        return avatar;
    }

    public static Avatar getStartingMageAvatar(String name){
        Stat stats = new Stat( 5 , 5 , 5, 15 , 5 , 3 , true , true);
        Avatar avatar = new Avatar(name , "Mage" , stats);
        avatar.setLocation(new Location(0, 0));
        return avatar;
    }

    public static Avatar getStartingRogueAvatar(String name){
        Stat stats = new Stat(5 , 5 , 15 , 5 , 5 , 5 , true , false);
        Avatar avatar = new Avatar(name , "Rogue" , stats);
        avatar.setLocation(new Location(0 , 0));
        return avatar;
    }
}
