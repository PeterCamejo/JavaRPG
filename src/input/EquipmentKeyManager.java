package input;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.event.KeyEvent;

/**
 * Created by The Alex on 7/9/2016.
 */
public class EquipmentKeyManager extends KeyManager {
    /* Attributes */
    public boolean north, south, east, west , escape, back,  unequip , inspect;

    /* Constructor */
    public EquipmentKeyManager(){
        super();
    }

    /* Methods */
    public void tick(){
        north = keys[KeyEvent.VK_UP];
        south = keys[KeyEvent.VK_DOWN];
        east = keys[KeyEvent.VK_RIGHT];
        west = keys[KeyEvent.VK_LEFT];
        inspect = keys[KeyEvent.VK_I];
        escape = keys[KeyEvent.VK_ESCAPE];
        back = keys[KeyEvent.VK_E];
        unequip = keys[KeyEvent.VK_ENTER];
    }
}
