package utilities.KeyCommand;
import controllers.ConfigInterfaceViewController;
import controllers.Controller;
import controllers.SkillTreeViewController;
import models.Entity.Avatar;
import models.Entity.Entity;
import models.StateModel.ConfigInterfaceModel;
import models.StateModel.SkillTreeModel;
import utilities.GameStateManager;
import utilities.State.State;
import views.ConfigInterfaceView;
import views.SkillTreeView;
import views.View;


public class ConfigKeyCommand implements KeyCommand {

    private GameStateManager gsm;
    private Avatar avatar;

    public ConfigKeyCommand(GameStateManager gsm, Avatar avatar) {
        this.gsm = gsm;
        this.avatar = avatar;
    }


    @Override
    public void execute() {
        ConfigInterfaceModel model = new ConfigInterfaceModel(avatar);
        View view = new ConfigInterfaceView(500,500,gsm.getCurrentView().getCanvas(),model, null);
        Controller controller = new ConfigInterfaceViewController(model, gsm);
        State state = new State(view, controller);
        gsm.changeState(state);
    }

}
