package utilities.KeyCommand;
import controllers.Controller;
import controllers.PlayStateController;
import controllers.StatsViewController;
import models.Entity.Entity;
import models.Map.Map;
import models.Signal.SkillSignal.RadialSkill.RadialPlanarSkillSignal;
import models.Signal.SkillSignal.RadialSkill.RadialSkill;
import models.Signal.SkillSignal.RadialSkill.RadialSphericalSkillSignal;
import models.Skill.Skill;
import models.Skill.SummonerSkill.Bane;
import models.StateModel.PlayStateModel;
import models.StateModel.StatsModel;
import utilities.GameStateManager;
import utilities.State.State;
import views.PlayStateView;
import views.StatsView;
import views.View;

/**
 * Created by clayhausen on 4/13/16.
 */

/** Responsibilities: checks for obstacles preventing Entity unit,
 *  then tells its Entity to move, passing it the Terrain it's moving to.
 */
public class StatsKeyCommand implements KeyCommand {

    private Entity entity;
    private GameStateManager gsm;

    public StatsKeyCommand(Entity entity, GameStateManager gsm) {
        this.entity = entity;
        this.gsm = gsm;
    }


    @Override
    public void execute() {
        StatsModel model = new StatsModel(entity.getStatContainer());
        View view = new StatsView(500,500,gsm.getCurrentCanvas(),model, null);
        Controller controller = new StatsViewController(model, gsm);
        State state = new State(view, controller);
        gsm.changeState(state);
    }

}
