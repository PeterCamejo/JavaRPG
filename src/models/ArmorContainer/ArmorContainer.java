package models.ArmorContainer;

import models.Item.Armors.*;

/**
 * Implemented by Peter Camejo
 *
 * ARMOR SLOTS :
 *  index  0  = HEAD
 *  index  1  = CHEST
 *  index  2  = LEGS
 *  index  3  = GLOVES
 *  index  4  = BOOTS
 *  index  5  = TRINKET
 */
public interface ArmorContainer {
    /* Attributes */
    int MAX_CONTAINER_SIZE = 6;
    int HEAD_SLOT = 0;
    int CHEST_SLOT = 1;
    int LEG_SLOT = 2;
    int GLOVE_SLOT = 3;
    int BOOT_SLOT = 4;
    int TRINKET_SLOT = 5;

    /* Methods */
    public void addHead(HeadArmor headArmor);
    public HeadArmor removeHead();
    public Boolean hasHead();
    public HeadArmor getHead();

    public void addChest(ChestArmor chestArmor);
    public ChestArmor removeChest();
    public Boolean hasChest();
    public ChestArmor getChest();

    public void addLegs(LegArmor legArmor);
    public LegArmor removeLegs();
    public Boolean hasLegs();
    public LegArmor getLegs();

    public void addGloves(GloveArmor gloveArmor);
    public GloveArmor removeGloves();
    public Boolean hasGloves();
    public GloveArmor getGloves();

    public void addBoots(BootArmor bootArmor);
    public BootArmor removeBoots();
    public Boolean hasBoots();
    public BootArmor getBoots();

    public void addTrinket(Trinket trinket);
    public Trinket removeTrinket();
    public Boolean hasTrinket();
    public Trinket getTrinket();


}