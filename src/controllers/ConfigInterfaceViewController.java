package controllers;


import models.StateModel.ConfigInterfaceModel;
import models.StateModel.StatsModel;
import utilities.GameStateManager;
import utilities.KeyCommand.KeyCommand;
import utilities.State.State;
import views.StatsView;
import views.View;


import java.awt.event.KeyEvent;



public class ConfigInterfaceViewController extends Controller {


    private ConfigInterfaceModel model;
    private int currentPoint;

    public ConfigInterfaceViewController(ConfigInterfaceModel model, GameStateManager gsm){
        super(gsm);
        this.model = model;
        currentPoint = 0;
    }




    @Override
    public void loadKeyCommand() {

        keyMap.put(KeyEvent.VK_P, new KeyCommand(){
            @Override
            public void execute() {
                statsStateTransition();
            }
        });
        keyMap.put(KeyEvent.VK_UP, new KeyCommand(){
            @Override
            public void execute() {
                model.down();
            }
        });

        keyMap.put(KeyEvent.VK_DOWN, new KeyCommand() {
            @Override
            public void execute() {
                model.up();
            }
        });

        keyMap.put(KeyEvent.VK_ENTER, new KeyCommand() {
            @Override
            public void execute() {

            }
        });

    }

    private void statsStateTransition() {
        gsm.removeState();
        View view = gsm.getCurrentView();
        Controller controller = gsm.getCurrentController();
        State state = new State(view, controller);
        gsm.changeState(state);
    }

    @Override
    public void updateModel() {

    }
}
