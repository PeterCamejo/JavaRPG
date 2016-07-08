package models.States;

import input.KeyManager;
import input.MenuKeyManager;
import models.Entity.Avatar;
import models.Inventory.Inventory;
import models.Item.Item;
import models.Item.TakeableItem;

import java.awt.*;

/**
 * Created by The Alex on 7/7/2016.
 */
public class InventoryState extends State {
    /* Attributes */
    private MenuKeyManager keyManager;
    private PlayState playState;
    private Avatar player;
    private int selected;
    private Inventory inventory;
    private TakeableItem[] items;

    private int inputBuffer;
    /* Constructors*/
    public InventoryState(){
        super();
    };

    public InventoryState(MenuKeyManager keyManager , PlayState playState){
        this.keyManager = keyManager;
        this.playState = playState;
        selected = 0;
        inputBuffer = 0;

        init();
    }

    /* Methods*/
    private void init(){
        player = playState.getPlayer();
        inventory = player.getInventory();
        items = new TakeableItem[inventory.getSize()];
        refreshInventory();
    }

    public void tick() {
        keyManager.tick();
        if (inputBuffer == 3) {
            if (keyManager.up) {
                moveSelected("north");
            }
            if (keyManager.down) {
                moveSelected("south");
            }
            if (keyManager.right) {
                moveSelected("east");
            }
            if (keyManager.left) {
                moveSelected("west");
            }
            if (keyManager.select0 || keyManager.select1) {
                inventory.useItemByIndex(selected, player);
            }
            if (keyManager.back) {
                GameStateManager.setState(playState);
            }
            if (keyManager.drop) {
                player.dropItem(inventory.getItemByIndex(selected));
            }
            inputBuffer = 0;
        }
        inputBuffer++;
    }

    public void render(Graphics g) {
        int x = 100;
        int y = 100;
        int itemCount = 0;

        //Background
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 800, 800);

        //Items
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (inventory.getItemByIndex(itemCount) == null) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, 100, 100);
                } else {
                    g.drawImage(inventory.getItemImageByIndex(i), x, y, null);
                }
                if (selected == itemCount++) {
                    g.setColor(Color.red);
                    g.drawRect(x - 3, y - 3, 106, 106);
                }
                x += 125;
            }
            x = 100;
            y += 125;
        }
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    private void moveSelected(String direction){
        int originalSelected = selected;

        switch(direction){
            case "north":
                selected -= 5;
                break;
            case"south":
                selected += 5;
                break;
            case "east":
                selected ++;
                break;
            case "west":
                selected --;
                break;
        }

        if(selected >= inventory.getSize() || selected < 0){
            selected = originalSelected;
        }
    }

    private void refreshInventory(){
        for(int i = 0 ; i < inventory.getSize(); i++){
            items[i] = inventory.getItemByIndex(i);
        }
    }
}
