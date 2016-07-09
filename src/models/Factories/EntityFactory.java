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
    public static Avatar getStartingSmasherAvatar(String name){
        Stat stats = new Stat(5 , 10 , 5 , 5 , 10 , 3 , true, false);
        Avatar avatar = new Avatar(name , "Smasher" , stats);
        avatar.setLocation(new Location(0 , 0 ));
        return avatar;
    }
}
