package models.Entity;


import models.Occupation.*;
import models.StatContainer.*;
import models.Inventory.*;

import javax.swing.*;
import java.awt.*;

public class NPC extends Entity {
    //
    public NPC(int level, Occupation occupation) {
        setName("NPC");
//        setDirection(models.Direction.South);
        setOccupation(occupation);
        setStats(new NPCStats(occupationModifier(), level));
        setInventory(new Inventory(12));
        setCurrentState(States.WANDER);
        //setEquipment(new models.Equipment());
    }

    @Override
    public Image getImage() {
        Image image = new ImageIcon("res/twoHand.png").getImage();
        return image;
    }
}
