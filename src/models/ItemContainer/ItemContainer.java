package models.ItemContainer;

import models.Item.TakeableItem;

/*
* Implemented by Peter Camejo
*/

public interface ItemContainer {
    /* Attributes */
    int DEFAULT_SIZE = 15;

    /* Methods */
    void addItem(TakeableItem item);
    TakeableItem removeItem(int id);
    TakeableItem removeItemByIndex(int index);
    TakeableItem getItemByIndex(int index);


}