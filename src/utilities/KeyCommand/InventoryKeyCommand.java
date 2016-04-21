package utilities.KeyCommand;

import controllers.Controller;
import controllers.InventoryViewController;
import models.Entity.Entity;
import models.StateModel.InventoryViewModel;
import utilities.GameStateManager;
import utilities.State.State;
import models.Map.Map;

import views.InventoryView;
import views.View;

/**
 * Implemented by Peter Camejo
 */
public class InventoryKeyCommand implements KeyCommand{

        private GameStateManager gsm;
        private Entity entity;
        private Map map;
        public InventoryKeyCommand(GameStateManager gsm , Entity entity,Map map){
            this.gsm = gsm;
            this.entity = entity;
            this.map = map;
        }

        @Override
        public void execute(){
            InventoryViewModel model = new InventoryViewModel(this.entity,map);
            View view = new InventoryView(500 , 500 , gsm.getCurrentCanvas() , model);
            Controller controller = new InventoryViewController(gsm,model);
            State state = new State(view,controller);
            gsm.changeState(state);
        }
}

