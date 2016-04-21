package controllers;

import models.Entity.Avatar;
import models.Entity.Entity;
import models.Occupation.Smasher;
import models.Occupation.Sneak;
import models.Occupation.Summoner;
import models.Stat.Stat;
import models.StateModel.AvatarCreationModel;
import models.StateModel.PlayStateModel;
import utilities.GameStateManager;
import utilities.KeyCommand.KeyCommand;
import utilities.State.State;
import views.PlayStateView;

import java.awt.event.KeyEvent;

/**
 * Created by clayhausen on 4/16/16.
 */
public class AvatarCreationViewController extends Controller {


    private AvatarCreationModel model;

    //Constructor of the AvatarCreationController
    public AvatarCreationViewController(AvatarCreationModel model, GameStateManager gsm){
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

        keyMap.put(KeyEvent.VK_ENTER, new KeyCommand() {
            @Override
            public void execute() {
                if(model.getSelected() == AvatarCreationModel.AvatarCreationMenu.SMASHER){
                    Avatar newAvatar = new Avatar(1, new Smasher());
                    playStateTransition(newAvatar);
                }
                if(model.getSelected() == AvatarCreationModel.AvatarCreationMenu.SNEAK){
                    Avatar newAvatar = new Avatar(1, new Sneak());
                    playStateTransition(newAvatar);
                }
                if(model.getSelected() == AvatarCreationModel.AvatarCreationMenu.SUMMONER){
                    Avatar newAvatar = new Avatar(1, new Summoner());
                    playStateTransition(newAvatar);
                }
            }
        });
    }

    // TODO change to appropriate state transition
    private void playStateTransition(Avatar avatar) {
        PlayStateModel model = new PlayStateModel(avatar);
        PlayStateView view = new PlayStateView(500,500,gsm.getCurrentView().getCanvas(),model);
        PlayStateController controller = new PlayStateController(model,gsm, avatar);
        State playState = new State(view,controller);
        gsm.changeState(playState);
    }

    @Override
    public void updateModel() {

    }
}
