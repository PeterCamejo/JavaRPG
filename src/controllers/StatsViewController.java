package controllers;


import models.StateModel.StatsModel;
import utilities.GameStateManager;
import utilities.KeyCommand.KeyCommand;
import utilities.State.State;
import views.StatsView;
import views.View;


import java.awt.event.KeyEvent;



public class StatsViewController extends Controller {


    private StatsModel model;
    private int currentPoint;

    //constructor of the mainMenuController
    public StatsViewController(StatsModel model, GameStateManager gsm){
        super(gsm);
        this.model = model;
        currentPoint = 0;
    }


    @Override
    public void loadKeyCommand() {
        keyMap.put(KeyEvent.VK_K, new KeyCommand(){
            @Override
            public void execute() {
                statsStateTransition();
            }
        });

    }

    private void statsStateTransition() {
        gsm.removeState();

        View view = gsm.getCurrentView();
        Controller controller = gsm.getCurrentController();
        State state = new State(view, controller);
        gsm.removeState();

        gsm.changeState(state);
    }

    @Override
    public void updateModel() {

    }
}
