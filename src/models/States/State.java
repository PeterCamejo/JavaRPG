package models.States;

import input.KeyManager;
import models.Buff.StaminaBuff;

import java.awt.*;

/**
 * Created by The Alex on 5/16/2016.
 */
public abstract class State {
    /* Attributes */
    protected int width , height;
    /* Constructors */
    public State(){
        width = 800;
        height = 800;
    }

    /* Methods */
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract KeyManager getKeyManager();
}
