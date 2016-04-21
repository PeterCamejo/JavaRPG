package models.StateModel;

/**
 * Created by denzel on 4/16/16.
 */
public class AvatarCreationModel {

    public enum AvatarCreationMenu{
        SMASHER("Smasher"),
        SUMMONER("Summoner"),
        SNEAK("Sneak");

        private String name;

        AvatarCreationMenu(String name){
            this.name = name;
        }

        public static AvatarCreationMenu getPrev(AvatarCreationMenu selected){
            int pos = selected.ordinal();
            if(pos == 0){
                return AvatarCreationMenu.values()[AvatarCreationMenu.values().length -1];
            }
            return AvatarCreationMenu.values()[pos -1];
        }
        public static AvatarCreationMenu getAfter(AvatarCreationMenu selected){

            int pos = selected.ordinal();
            if(pos == AvatarCreationMenu.values().length-1){
                return AvatarCreationMenu.values()[0];
            }
            return AvatarCreationMenu.values()[pos + 1];
        }


        @Override
        public String toString(){
            return name;
        }

    }

    private AvatarCreationMenu selected;

    public AvatarCreationModel(){
        selected = AvatarCreationMenu.SMASHER;
    }


    public AvatarCreationMenu getSelected(){
        return selected;
    }


    public void up(){
        selected = AvatarCreationMenu.getPrev(selected);
    }

    public void down(){
        selected = AvatarCreationMenu.getAfter(selected);
    }
}
