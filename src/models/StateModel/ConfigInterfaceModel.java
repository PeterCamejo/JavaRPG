package models.StateModel;

import models.Entity.Avatar;
import models.Entity.Entity;
import models.Stat.Stat;
import models.StatContainer.StatContainer;
import utilities.KeyCommand.KeyCommand;
import utilities.State.State;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ConfigInterfaceModel{


    private int currentPoint;
    private int size;
    private Avatar avatar;

    public ConfigInterfaceModel(Avatar avatar){
        this.avatar = avatar;
        currentPoint = 0;
        size = 10;
    }

    public String getKey(int n) {
        Iterator<Map.Entry<Integer, KeyCommand>> iter = avatar.getKeyMap().entrySet().iterator();
        for (int i = 0; i < n; ++i) {
            iter.next();
        }
        return iter.next().getValue().toString();
    }

    public int getCurrentPoint() {
        return currentPoint;
    }

    public int getSize() {
        return size;
    }

    public void up() {
        currentPoint++;
    }

    public void down() {
        currentPoint--;
    }
}
