package models.States;

import models.Buff.StaminaBuff;

import java.awt.*;

/**
 * Created by The Alex on 5/16/2016.
 */
public abstract class State {

    /* Constructors */
    public State(){
    }

    /* Methods */
    public abstract void tick();
    public abstract void render(Graphics g);
}
