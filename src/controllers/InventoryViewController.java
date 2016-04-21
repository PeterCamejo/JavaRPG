package controllers;

import models.Inventory.Inventory;
import models.Item.ConsumableItem;
import models.StateModel.InventoryViewModel;
import models.StateModel.MainMenuModel;
import utilities.GameStateManager;
import utilities.KeyCommand.KeyCommand;
import utilities.State.State;
import views.View;

import java.awt.event.KeyEvent;

/**
 * Implemented by Peter Camejo
 */
public class InventoryViewController extends Controller{

    private InventoryViewModel model;

    public InventoryViewController(GameStateManager gsm , InventoryViewModel model){
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

        keyMap.put(KeyEvent.VK_LEFT, new KeyCommand() {
            @Override
            public void execute() {
                model.left();
            }
        });

        keyMap.put(KeyEvent.VK_RIGHT, new KeyCommand(){
            @Override
            public void execute() {
                model.right();
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
            public void execute(){model.select(); }
        });

        keyMap.put(KeyEvent.VK_ESCAPE, new KeyCommand() {
            @Override
            public void execute() {
                gameStateTransition();
            }
        });
        keyMap.put(KeyEvent.VK_I, new KeyCommand() {
            @Override
            public void execute() {
                gameStateTransition();
            }
        });
        keyMap.put(KeyEvent.VK_D, new KeyCommand() {
            @Override
            public void execute() {
                model.dropItem();
            }
        });
    }

    @Override
    public void handleInput(KeyEvent e) {
        super.handleInput(e);
    }

    @Override
    public void updateModel() {
        this.model.update();
    }

    public void gameStateTransition(){
        gsm.removeState();
        View view = gsm.getCurrentView();
        Controller controller = gsm.getCurrentController();
        State state = new State(view, controller);
        gsm.changeState(state);
        System.out.println("Does this work");
    }
}
