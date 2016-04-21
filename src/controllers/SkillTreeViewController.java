package controllers;


import models.StateModel.SkillTreeModel;
import models.StateModel.StatsModel;
import utilities.GameStateManager;
import utilities.KeyCommand.KeyCommand;
import utilities.State.State;
import views.StatsView;
import views.View;


import java.awt.event.KeyEvent;

public class SkillTreeViewController extends Controller {


    private SkillTreeModel model;

    //constructor of the mainMenuController
    public SkillTreeViewController(SkillTreeModel model, GameStateManager gsm){
        super(gsm);
        this.model = model;
    }




    @Override
    public void loadKeyCommand() {

        keyMap.put(KeyEvent.VK_UP, new KeyCommand(){
            @Override
            public void execute() {
                model.up();
            }
        });

        keyMap.put(KeyEvent.VK_DOWN, new KeyCommand() {
            @Override
            public void execute() {
                model.down();
            }
        });

        keyMap.put(KeyEvent.VK_ENTER, new KeyCommand() {
            @Override
            public void execute() {
                model.levelUp();
            }
        });

        keyMap.put(KeyEvent.VK_SHIFT, new KeyCommand() {
            @Override
            public void execute() {
                model.setActive();
                model.initLists();
            }
        });

        keyMap.put(KeyEvent.VK_T, new KeyCommand(){
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
        gsm.changeState(state);
    }

    @Override
    public void updateModel() {

    }
}
