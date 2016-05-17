package models.States;

import java.awt.*;

/**
 * Created by The Alex on 5/16/2016.
 */
public class GameStateManager {
    /* Attributes */
    private static State currentState = null;

    /* Methods */
    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }

    public static void tickCurrentState(){
        currentState.tick();
    }

    public static void renderCurrentState(Graphics g){
        currentState.render(g);
    }
}
