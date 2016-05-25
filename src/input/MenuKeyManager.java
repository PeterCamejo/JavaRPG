package input;

import java.awt.event.KeyEvent;

/**
 * Created by The Alex on 5/24/2016.
 */
public class MenuKeyManager extends KeyManager {
    /* Attributes */
    public boolean up , down , select0 , select1;

    /* Constructor */
    public MenuKeyManager(){
        super();
    }

    /* Methods */
    public void tick(){
        up = keys[KeyEvent.VK_NUMPAD8];
        down = keys[KeyEvent.VK_NUMPAD5];
        select0 = keys[KeyEvent.VK_ENTER];
        select1 = keys[KeyEvent.VK_E];
    }
}
