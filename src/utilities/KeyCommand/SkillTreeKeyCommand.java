package utilities.KeyCommand;
import controllers.Controller;
import controllers.SkillTreeViewController;
import models.Entity.Entity;
import models.StateModel.SkillTreeModel;
import utilities.GameStateManager;
import utilities.State.State;
import views.SkillTreeView;
import views.View;

/**
 * Created by clayhausen on 4/13/16.
 */

/** Responsibilities: checks for obstacles preventing Entity unit,
 *  then tells its Entity to move, passing it the Terrain it's moving to.
 */
public class SkillTreeKeyCommand implements KeyCommand {

    private Entity entity;
    private GameStateManager gsm;

    public SkillTreeKeyCommand(Entity entity, GameStateManager gsm) {
        this.entity = entity;
        this.gsm = gsm;
    }

    @Override
    public void execute() {
        SkillTreeModel model = new SkillTreeModel(entity.getOccupation());
        View view = new SkillTreeView(500,500,gsm.getCurrentView().getCanvas(),model, null);
        Controller controller = new SkillTreeViewController(model, gsm);
        State state = new State(view, controller);
        gsm.changeState(state);
    }

}
