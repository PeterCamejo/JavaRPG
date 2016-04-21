package models.Equipment;

import com.sun.xml.internal.ws.message.MimeAttachmentSet;
import models.ArmorContainer.ArmorContainer;
import models.Item.Armors.*;
import models.Item.Weapons.Weapon;


/**
 *  Implemented by Peter Camejo
 */
public class Equipment implements ArmorContainer{
    /* Attributes */
    Armor[] armor;
    Weapon equippedWeapon;

    /* Constructors */
    public Equipment(){
        armor = new Armor[MAX_CONTAINER_SIZE];
        equippedWeapon = null;
        init();
    }

    /* Methods */
    public void init(){
        for(int i = 0 ; i < MAX_CONTAINER_SIZE ; i++){
            armor[i] = null;
        }
    }

    /*******************  HEAD  ************************/
    public void addHead(HeadArmor headArmor){
        if(armor[HEAD_SLOT] != null){
            System.out.println(" Equip Failed: Head slot is full");
            return;
        }

        armor[HEAD_SLOT] = headArmor;
    }

    public HeadArmor removeHead(){
        HeadArmor tempArmor = (HeadArmor) armor[HEAD_SLOT];
        armor[HEAD_SLOT] = null;
        return tempArmor;
    }

    public Boolean hasHead(){
        if(armor[HEAD_SLOT] == null){
            return false;
        }
        return true;
    }

    public HeadArmor getHead(){
        return (HeadArmor) armor[HEAD_SLOT];
    }

    /******************** CHEST ***********************/
    public void addChest(ChestArmor chestArmor){
        if(armor[CHEST_SLOT] != null){
            System.out.println("Equip failed : Chest slot is full");
            return;
        }

        armor[CHEST_SLOT] = chestArmor;
    }

    public ChestArmor removeChest(){
        ChestArmor tempArmor = (ChestArmor) armor[CHEST_SLOT];
        armor[CHEST_SLOT] = null;
        return tempArmor;
    }

    public Boolean hasChest(){
        if(armor[CHEST_SLOT] == null){
            return false;
        }
        return true;
    }

    public ChestArmor getChest(){
        return (ChestArmor) armor[CHEST_SLOT];

    }

    /***************** LEGS ************************/
    public void addLegs(LegArmor legArmor){
        if(armor[LEG_SLOT] != null) {
            System.out.println("Equip Failed : Leg slot is full");
            return;
        }
        armor[LEG_SLOT] = legArmor;
    }

    public LegArmor removeLegs(){
        LegArmor tempArmor = (LegArmor) armor[LEG_SLOT];
        armor[LEG_SLOT] = null;
        return tempArmor;
    }

    public Boolean hasLegs(){
        if(armor[LEG_SLOT] == null){
            return false;
        }
        return true;
    }

    public LegArmor getLegs(){
        return (LegArmor) armor[LEG_SLOT];
    }

    /*************** GLOVES **************/
    public void addGloves(GloveArmor gloveArmor){
        if(armor[GLOVE_SLOT] != null){
            System.out.println("Equip Failed: Glove slot is full.");
            return;
        }

        armor[GLOVE_SLOT] = gloveArmor;
    }

    public GloveArmor removeGloves(){
        GloveArmor tempArmor = (GloveArmor) armor[GLOVE_SLOT];
        armor[GLOVE_SLOT] = null;
        return tempArmor;
    }

    public Boolean hasGloves(){
        if(armor[GLOVE_SLOT] == null){
            return false;
        }
        return true;
    }

    public GloveArmor getGloves(){
        return (GloveArmor)armor[GLOVE_SLOT];
    }

    /**************** BOOTS ***************/
    public void addBoots(BootArmor bootArmor){
        if(armor[BOOT_SLOT] != null){
            System.out.println("Equip Failed: Boot slot is full.");
            return;
        }

        armor[BOOT_SLOT] = bootArmor;
    }

    public BootArmor removeBoots(){
        BootArmor tempArmor = (BootArmor) armor[BOOT_SLOT];
        armor[BOOT_SLOT] = null;
        return tempArmor;
    }

    public Boolean hasBoots(){
        if(armor[BOOT_SLOT] == null){
            return false;
        }

        return true;
    }

    public BootArmor getBoots(){
        return (BootArmor) armor[BOOT_SLOT];
    }

    /***************** TRINKET ********************/
    public void addTrinket(Trinket trinket){
        if(armor[TRINKET_SLOT] != null){
            System.out.println("Equip failed: Trinket Slot full");
            return;
        }

        armor[TRINKET_SLOT] = trinket;
    }

    public Trinket removeTrinket(){
        Trinket tempArmor = (Trinket) armor[TRINKET_SLOT];
        armor[TRINKET_SLOT] = null;
        return tempArmor;
    }

    public Boolean hasTrinket(){
        if(armor[TRINKET_SLOT] == null){
            return false;
        }
        return true;
    }

    public Trinket getTrinket(){
        return (Trinket) armor[TRINKET_SLOT];
    }

    /****************** WEAPON **************/
    public Weapon getWeapon(){
        return this.equippedWeapon;
    }

    public void setEquippedWeapon(Weapon weapon){
        this.equippedWeapon = weapon;
        return;
    }
}