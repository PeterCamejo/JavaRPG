package utilities;


import AI.AIController;
import Main.InputManager;
import controllers.Controller;
import controllers.NPCController;
import models.Entity.NPC;
import utilities.State.State;
import views.Canvas;
import views.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Responsibilities of GameStateManager is
 * keep a stack of states and check the current state for its view and controller
 */

public class GameStateManager {

    //Stack of states
    private Stack<State> stateStack;

    //List of NPCs
    ArrayList<AIController> currentNPCs = new ArrayList<>();

    public GameStateManager(){
        //initialize the stack of states
        stateStack = new Stack<>();
    }

    //Current View
    public View getCurrentView(){
        return stateStack.peek().getView();
    }

    //Current Controller
    public Controller getCurrentController(){
        return stateStack.peek().getController();
    }

    //change state
    public void changeState(State state){
        stateStack.add(state);
        //TODO: This should not be written like this
        //getCurrentView().getCanvas().setActiveView(state.getView());
        getCurrentCanvas().setActiveView(state.getView());
    }

    //remove state
    public void removeState(){
        stateStack.pop();
    }

    //update
    public void update(Canvas canvas){
        canvas.repaint();
    }

    public void updateModel() {

        int fps = 30;
        long timePerTick = 1000 / fps;

        long start;
        long elapsed;
        long wait;

        start = System.currentTimeMillis();


        elapsed = System.currentTimeMillis() - start;
        wait = timePerTick - elapsed;

        if(wait > 0 ) {
            getCurrentController().updateModel();
            for (int i = 0; i < currentNPCs.size(); i++) {
                currentNPCs.get(i).act();
            }
        }
    }

    public Canvas getCurrentCanvas() {
        return getCurrentView().getCanvas();
    }

    public void registerEntityController(AIController aiController){
        currentNPCs.add(aiController);
    }

}
