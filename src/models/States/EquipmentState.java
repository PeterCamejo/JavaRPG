package models.States;

import input.EquipmentKeyManager;
import input.KeyManager;
import models.Entity.Avatar;
import models.Equipment.Equipment;
import models.Item.EquipableItem;


import java.awt.*;

/**
 * Created by The Alex on 7/9/2016.
 */
public class EquipmentState extends State {
    /* Attributes */
    private EquipmentKeyManager keyManager;
    private PlayState playState;
    private Avatar player;
    private int selectedIndex;
    private Equipment equipment;
    private int equipmentSize;
    private EquipableItem[] items;

    private int inputBuffer;

    /* Constructor */
    public EquipmentState(){
        super();
    };

    public EquipmentState(PlayState playState){
        keyManager = new EquipmentKeyManager();
        this.playState = playState;
        inputBuffer = 0;
        selectedIndex = 0;

        init();
    }

    /* Methods */
    private void init(){
        player = playState.getPlayer();
        equipment = player.getEquipment();
        equipmentSize = equipment.getSize();
        items = new EquipableItem[equipmentSize];
        refreshEquipment();
    }

    public void tick() {
        keyManager.tick();
        if (inputBuffer == 3) {
            if (keyManager.north) {
                moveSelected("north");
            }
            if (keyManager.south) {
                moveSelected("south");
            }
            if (keyManager.east) {
                moveSelected("east");
            }
            if (keyManager.west) {
                moveSelected("west");
            }
            if (keyManager.unequip) {
                if(items[selectedIndex] != null){
                    items[selectedIndex].unequip(player, player.getEquipment(), player.getInventory());
                }
                refreshEquipment();
            }
            if (keyManager.back || keyManager.escape) {
                GameStateManager.setState(playState);
            }
            if (keyManager.inspect) {
                refreshEquipment();
            }
            inputBuffer = 0;
        }
        inputBuffer++;
    }

    public void render(Graphics g) {
        //Background
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 800, 800);

        //Items
        g.setColor(Color.BLACK);
        if(items[0] == null){
            g.fillRect(350 , 200 , 100 , 100);
        }else{
            g.drawImage(items[0].getImage() , 350 ,150 , null);
        }

        if(items[1] == null){
            g.fillRect(350 ,350, 100 , 100);
        }else{
            g.drawImage(items[1].getImage() , 350 ,350 , null);
        }

        if(items[2] == null){
            g.fillRect( 350 ,500  , 100 , 100);
        }else{
            g.drawImage(items[2].getImage() , 350 ,500 , null);
        }

        if(items[3] == null){
            g.fillRect(200 ,350 , 100 , 100);
        }else{
            g.drawImage(items[3].getImage() , 200 ,350 , null);
        }

        if(items[4] == null){
            g.fillRect(350 ,650 , 100 , 100);
        }else{
            g.drawImage(items[4].getImage() , 350 ,650 , null);
        }

        if(items[5] == null){
            g.fillRect(500 ,500 , 100 , 100);
        }else{
            g.drawImage(items[5].getImage() , 500 ,500 , null);
        }

        if(items[6] == null){
            g.fillRect( 500 ,350 , 100 , 100);
        }else{
            g.drawImage(items[6].getImage() , 500 ,350 , null);
        }

        //Draw Selected
        g.setColor(Color.red);
        switch(selectedIndex){
            case 0:
                g.drawRect(347 , 197 , 106 , 106);
                break;
            case 1:
                g.drawRect(347 ,347, 106 , 106);
                break;
            case 2:
                g.drawRect( 347 ,497  , 106 , 106);
                break;
            case 3:
                g.drawRect(197 ,347 , 106 , 106);
                break;
            case 4:
                g.drawRect(347 ,647 , 106 , 106);
                break;
            case 5:
                g.drawRect(497 ,497 , 106 , 106);
                break;
            case 6:
                g.drawRect( 497 ,347 , 106 , 106);
                break;
        }

    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    private void moveSelected(String direction){
        switch(direction){
            case "north":
                if(selectedIndex == 2 || selectedIndex == 1){ selectedIndex--;break;}
                if(selectedIndex == 5){ selectedIndex++;break;}
                if(selectedIndex == 4){ selectedIndex = 2;break;}
                break;
            case"south":
                if(selectedIndex == 0 || selectedIndex == 1){ selectedIndex++;break;}
                if(selectedIndex == 6){ selectedIndex--;break;}
                if(selectedIndex == 2){selectedIndex = 4;break;}
                break;
            case "east":
                if(selectedIndex == 3){ selectedIndex = 1;break;}
                if(selectedIndex == 1){ selectedIndex = 6;break;}
                if(selectedIndex == 2){ selectedIndex = 5;break;}
                break;
            case "west":
                if(selectedIndex == 6){ selectedIndex = 1;break;}
                if(selectedIndex == 1){ selectedIndex = 3;break;}
                if(selectedIndex == 5){ selectedIndex = 2;break;}
                break;
        }
    }

    private void refreshEquipment(){
        items[0] = equipment.getHead();
        items[1] = equipment.getChest();
        items[2] = equipment.getLegs();
        items[3] = equipment.getGloves();
        items[4] = equipment.getBoots();
        items[5] = equipment.getTrinket();
        items[6] = equipment.getWeapon();

    }
}
