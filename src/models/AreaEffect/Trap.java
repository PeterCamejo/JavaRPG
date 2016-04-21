package models.AreaEffect;

import models.Entity.Entity;
import utilities.Location.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Andy on 4/14/2016.
 */
public class Trap extends AreaEffect {

    private boolean active;
    private double test;
    private Timer timer = new Timer();
    public Trap(Location l){
        loc = l;
        active = true;
    }
    public void execute(Entity e){
        trap(e);
    }

    private void trap(Entity e){
        if(active) {
            //double previous = e.statValue("Movement");

            Map<String, Double> statChange = new HashMap<>();
            Map<String, Double> statChange2 = new HashMap<>();
            statChange.put("MOVEMENT", -100.0);
            //statChange2.put("MOVEMENT",100.0);
            e.modifyStats(statChange);
            System.out.println("This is before forceToWait()");
            forceToWait();              //this should cause it to wait 5 seconds before executing this
            //System.out.println("This is after forceToWait()");
            //System.out.println("test:"+test);
            //statChange2.put("MOVEMENT",test);
            e.modifyStats(statChange2);

        }

        //disable();
    }

    private double changeStat(){
       // Map<String, Double> statChange = new HashMap<>();
        //statChange.put("MOVEMENT",100.0);
        //e.modifyStats(statChange);
        return 100.0;

    }

    public synchronized void forceToWait() {
        this.timer.cancel(); //this will cancel the current task. if there is no active task, nothing happens
        this.timer = new Timer();

        TimerTask action = new TimerTask() {
            public void run() {
                disable(); //as you said in the comments: abc is a static method
                changeStat();
                test = 100;
            }


        };

        this.timer.schedule(action, 2000); //this starts the task
    }



    private void disable(){
        active = false;
        System.out.println("Is disabled biiiitch");
    }
}
