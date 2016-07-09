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
    private Point selected;
    private int selectedIndex;
    private Inventory inventory;
    private TakeableItem[][] items;
    private int rows;
    private int cols;

    private int inputBuffer;
    /* Constructors*/
    public InventoryState(){
        super();
    };

    public InventoryState(MenuKeyManager keyManager , PlayState playState){
        this.keyManager = keyManager;
        this.playState = playState;
        selected = new Point(0 , 0);
        inputBuffer = 0;
        rows = 3;
        cols = 5;
        selectedIndex = 0;

        init();
    }

    /* Methods*/
    private void init(){
        player = playState.getPlayer();
        inventory = player.getInventory();
        items = new TakeableItem[rows][cols];
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
                inventory.useItemByIndex(selectedIndex ,  player);
                refreshInventory();
            }
            if (keyManager.back) {
                GameStateManager.setState(playState);
            }
            if (keyManager.drop) {
                player.dropItem(inventory.getItemByIndex(selectedIndex) , selectedIndex);
                refreshInventory();
            }
            inputBuffer = 0;
        }
        inputBuffer++;
    }

    public void render(Graphics g) {
        int x = 100;
        int y = 100;

        //Background
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 800, 800);

        //Items
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (items[i][j] == null) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, 100, 100);
                } else {
                    g.drawImage(items[i][j].getImage(), x, y, null);
                }
                if (selected.x == i && selected.y == j) {
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
        int originalX = selected.x;
        int originalY = selected.y;
        int originalIndex = selectedIndex;

        switch(direction){
            case "north":
                selected.x--;
                selectedIndex-=cols;
                break;
            case"south":
                selected.x++;
                selectedIndex+=cols;
                break;
            case "east":
                selected.y++;
                selectedIndex++;
                break;
            case "west":
                selected.y--;
                selectedIndex--;
                break;
        }

        if(selected.y >= cols || selected.y < 0 ){
            selected.y = originalY;
        }
        if(selected.x >= rows || selected.x < 0){
            selected.x = originalX;
        }
        if(selectedIndex >= inventory.getSize() || selectedIndex < 0){
            selectedIndex = originalIndex;
        }
    }

    private void refreshInventory(){
        int index = 0;

        for(int i = 0; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                items[i][j] = inventory.getItemByIndex(index++);
            }
        }
    }

}
