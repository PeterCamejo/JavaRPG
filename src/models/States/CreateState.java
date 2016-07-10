package models.States;

import input.KeyManager;
import input.MenuKeyManager;
import input.PlayKeyManager;
import models.Entity.Avatar;
import models.Factories.EntityFactory;
import models.Map.Map;
import models.Movement;

import java.awt.*;

/**
 * Created by The Alex on 7/9/2016.
 */
public class CreateState extends State {
    /* Attributes */
    private String[] classes;
    private MenuKeyManager keyManager;
    private int index;
    private int inputBuffer;

    /* Constructors*/
    public CreateState(){
        super();
        keyManager = new MenuKeyManager();
        classes = new String[3];
        classes[0] = "Warrior";
        classes[1] = "Mage";
        classes[2] = "Rogue";
    }


    /* Methods */
    public void tick(){
        keyManager.tick();
        if(inputBuffer++ == 3) {
            if (keyManager.up) {
                if (index - 1 >= 0) {
                    index--;
                }
            }
            if (keyManager.down) {
                if (index + 1 < classes.length) {
                    index++;
                }
            }

            if (keyManager.select0 || keyManager.select1) {
                GameStateManager.setState(new PlayState(EntityFactory.getStartingAvatar(classes[index], classes[index])));
            }
            inputBuffer = 0;
        }



    }

    public void render(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(0 , 0 , width , height);

        for(int i = 0; i < classes.length; ++i) {
            g.setFont(new Font("Arial", Font.PLAIN, 128));
            FontMetrics fm = g.getFontMetrics();
            int totalWidth = (fm.stringWidth(classes[i]));
            int x = (width - totalWidth) / 2;
            int y = (height / 2) - 100 + 100 * i;
            if(i == index){
                g.setColor(new Color(149, 165, 166, 175));
                g.fillRect(x, y - fm.getHeight() + (fm.getHeight() / 4), totalWidth, fm.getHeight() );
                g.setColor(new Color(243, 156, 18));
            }else {
                g.setColor(new Color(231, 76, 60));
                if(i == 3) {
                    g.setColor(new Color(0, 0, 0));
                }

            }
            g.drawString(classes[i], x, y);
        }


    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

}
