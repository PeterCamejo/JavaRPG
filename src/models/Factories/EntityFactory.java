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
        }

        return avatar;
    }

    public static Avatar getStartingWarriorAvatar(String name){
        Stat stats = new Stat(5 , 10 , 5 , 5 , 10 , 3 , true, false);
        Avatar avatar = new Avatar(name , "Warrior" , stats);
        avatar.setLocation(new Location(0 , 0 ));
        return avatar;
    }
}
