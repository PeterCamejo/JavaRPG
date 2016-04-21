package models.StateModel;

import models.Entity.Entity;
import models.Stat.Stat;
import models.StatContainer.StatContainer;
import utilities.State.State;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by jcvarela on 4/12/2016.
 */
public class StatsModel{


    private String title;
    private Entity entity;
    private StatContainer statContainer;
    private ArrayList<String> nameList;
    private ArrayList<Integer> valueList;
    private int currentPoint;

    public StatsModel(StatContainer statContainer){
        title = "STATS";
        currentPoint = 0;
        this.statContainer = statContainer;
        nameList = new ArrayList<>();
        valueList = new ArrayList<>();
        initList();
    }

    private void initList() {
        Iterator<Map.Entry<String,Stat>> iter = statContainer.getMap().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, Stat> currentStat = iter.next();
            nameList.add(currentStat.getKey());
            valueList.add((int) currentStat.getValue().value());
        }
    }

    private String getStatName(int n) {
        return nameList.get(n);
    }

    private String getStatValue(int n) {
        return Integer.toString((int) (valueList.get(n)));
    }

    public String getString(int n) {
        return getStatName(n) + ": " + getStatValue(n);
    }

}
