package models.Entity;


import controllers.Amphibious;
import controllers.Arial;
import controllers.Locomotion;

import controllers.Terrestrial;
import models.Equipment.Equipment;
import models.Occupation.*;
import models.StatContainer.*;
import models.Inventory.*;
import utilities.Direction.Direction;
import utilities.KeyCommand.KeyCommand;
import utilities.KeyCommand.MovementKeyCommand;
import utilities.KeyCommand.SkillKeyCommand;
import utilities.Location.Location;
import models.Map.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Set;

public class Avatar extends Entity {
    //
    private HashMap<Integer,KeyCommand> keyMap;

    public Avatar(int level, Occupation occupation) {
        setName("Avatar");
        setLocation(new Location(0,0,0));
        setDirection(utilities.Direction.Direction.South);
        setOccupation(occupation);
        setStats(new AvatarStats(occupationModifier(), level));
        setInventory(new Inventory(25));
        setCurrentState(States.ATTACK);
        setEquipment(new Equipment());
    }

    public Image getImage(){
        Image image = new ImageIcon("res/fireball.png").getImage();
        return image;
    }

    public void setKeyCommand(Map map){

        keyMap = new HashMap<>();
        Locomotion locomotion = new Terrestrial(this, map);
        // Movement
        KeyCommand moveNorth = new MovementKeyCommand(map, this, Direction.North, locomotion);
        keyMap.put(KeyEvent.VK_8, moveNorth);

        KeyCommand moveNorthWest = new MovementKeyCommand(map, this, Direction.NorthWest, locomotion);
        keyMap.put(KeyEvent.VK_7, moveNorthWest);

        KeyCommand moveSouthWest = new MovementKeyCommand(map, this, Direction.SouthWest, locomotion);
        keyMap.put(KeyEvent.VK_1, moveSouthWest);

        KeyCommand moveSouth = new MovementKeyCommand(map, this, Direction.South, locomotion);
        keyMap.put(KeyEvent.VK_2, moveSouth);

        KeyCommand moveSouthEast = new MovementKeyCommand(map, this, Direction.SouthEast, locomotion);
        keyMap.put(KeyEvent.VK_3, moveSouthEast);

        KeyCommand moveNorthEast = new MovementKeyCommand(map, this, Direction.NorthEast, locomotion);
        keyMap.put(KeyEvent.VK_9, moveNorthEast);

        KeyCommand moveUp = new MovementKeyCommand(map, this, Direction.Up, locomotion);
        keyMap.put(KeyEvent.VK_SPACE, moveUp);

        KeyCommand moveDown = new MovementKeyCommand(map, this, Direction.Down, locomotion);
        keyMap.put(KeyEvent.VK_ENTER, moveDown);

        moveNorthWest = new MovementKeyCommand(map, this, Direction.NorthWest, locomotion);
        keyMap.put(KeyEvent.VK_Q, moveNorthWest);

        moveSouthWest = new MovementKeyCommand(map, this, Direction.SouthWest, locomotion);
        keyMap.put(KeyEvent.VK_A, moveSouthWest);

        moveSouth = new MovementKeyCommand(map, this, Direction.South, locomotion);
        keyMap.put(KeyEvent.VK_S, moveSouth);

        moveSouthEast = new MovementKeyCommand(map, this, Direction.SouthEast, locomotion);
        keyMap.put(KeyEvent.VK_D, moveSouthEast);

        moveNorthEast = new MovementKeyCommand(map, this, Direction.NorthEast, locomotion);
        keyMap.put(KeyEvent.VK_E, moveNorthEast);

        moveNorth = new MovementKeyCommand(map, this, Direction.North, locomotion);
        keyMap.put(KeyEvent.VK_W, moveNorth);

        KeyCommand skill1 = new SkillKeyCommand(map, this, 0);
        keyMap.put(KeyEvent.VK_1, skill1);

        KeyCommand skill2 = new SkillKeyCommand(map, this, 1);
        keyMap.put(KeyEvent.VK_2, skill2);

        KeyCommand skill3 = new SkillKeyCommand(map, this, 2);
        keyMap.put(KeyEvent.VK_3, skill3);

        KeyCommand skill4 = new SkillKeyCommand(map, this, 3);
        keyMap.put(KeyEvent.VK_4, skill4);
    }

    public HashMap<Integer,KeyCommand> getKeyMap(){
        return keyMap;
    }
    public Set<Integer> getKeys(){
        return keyMap.keySet();
    }
}
