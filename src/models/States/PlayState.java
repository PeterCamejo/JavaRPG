package models.States;

import models.Entity.Avatar;
import views.Assets;

import java.awt.*;

/**
 *
 */
public class PlayState extends State {
    /* Attributes */
    private Avatar player;

    /* Constructors*/
    public PlayState(){
        super();
    }

    /* Methods */
    public void tick(){
        player.tick();
    }
    public void render(Graphics g){
        player.render(g);
    }
}
