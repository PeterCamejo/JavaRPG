package controllers;

import models.StateModel.AvatarCreationModel;
import models.StateModel.MainMenuModel;
import utilities.GameStateManager;
import utilities.KeyCommand.KeyCommand;
import utilities.State.State;
import views.AvatarCreationView;
import views.View;

import java.awt.event.KeyEvent;

/**
 * Created by denzel on 4/11/16.
 */
public class MainMenuViewController extends Controller {


    private MainMenuModel model;

    //constructor of the mainMenuController
    public MainMenuViewController(MainMenuModel model, GameStateManager gsm){
        super(gsm);
        this.model = model;
    }



    @Override
    public void loadKeyCommand() {

        keyMap.put(KeyEvent.VK_U, new KeyCommand(){
            @Override
            public void execute() {
                model.up();
            }
        });

        keyMap.put(KeyEvent.VK_J, new KeyCommand() {
            @Override
            public void execute() {
                model.down();
            }
        });

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
                if(model.getSelected() == MainMenuModel.MainMenuOption.Start){
                    avatarCreationStateTransition();
                }
            }
        });
    }

    private void avatarCreationStateTransition() {
        AvatarCreationModel model = new AvatarCreationModel();
        View view = new AvatarCreationView(500,500,gsm.getCurrentCanvas(),model);
        Controller controller = new AvatarCreationViewController(model, gsm);
        State state = new State(view, controller);
        gsm.changeState(state);
    }

    @Override
    public void updateModel() {

    }
}
