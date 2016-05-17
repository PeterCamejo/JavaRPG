package models.States;

import views.Assets;

import java.awt.*;

/**
 *
 */
public class PlayState extends State {
    /* Constructors*/
    public PlayState(){
        super();
    }

    /* Methods */
    public void tick(){}
    public void render(Graphics g){
        g.drawImage(Assets.chestArmor , 50 , 50 ,null);
    }
}
