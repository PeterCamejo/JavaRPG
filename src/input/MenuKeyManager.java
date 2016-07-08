package input;

import java.awt.event.KeyEvent;

/**
 * Created by The Alex on 5/24/2016.
 */
public class MenuKeyManager extends KeyManager {
    /* Attributes */
    public boolean up , down , select0 , select1 , back , left, right , drop;

    /* Constructor */
    public MenuKeyManager(){
        super();
    }

    /* Methods */
    public void tick(){
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        select0 = keys[KeyEvent.VK_ENTER];
        select1 = keys[KeyEvent.VK_E];
        back = keys[KeyEvent.VK_ESCAPE];
        right = keys[KeyEvent.VK_RIGHT];
        left = keys[KeyEvent.VK_LEFT];
        drop = keys[KeyEvent.VK_D];
    }
}
