package models.StateModel;

/**
 * Created by Andy on 4/16/2016.
 */
public class PauseMenuModel {

    public enum PauseMenuOption{
        Start("Save Game"),
        NewGame("Load Game"),
        ControllerSetting("Controller Settings"),
        Exit("Exit Game");

        private String name;

        PauseMenuOption(String name){
            this.name = name;
        }

        public static PauseMenuOption getPrev(PauseMenuOption selected){
            int pos = selected.ordinal();
            if(pos == 0){
                return  PauseMenuOption.values()[PauseMenuOption.values().length -1];
            }
            return  PauseMenuOption.values()[pos -1];
        }
        public static  PauseMenuOption getAfter(PauseMenuOption selected){

            int pos = selected.ordinal();
            if(pos ==  PauseMenuOption.values().length-1){
                return  PauseMenuOption.values()[0];
            }
            return  PauseMenuOption.values()[pos + 1];
        }


        @Override
        public String toString(){
            return name;
        }

    }

    private PauseMenuOption selected;

    public PauseMenuModel(){
        selected = PauseMenuOption.Start;
    }


    public PauseMenuOption getSelected(){
        return selected;
    }


    public void up(){
        selected = PauseMenuOption.getPrev(selected);
    }

    public void down(){
        selected = PauseMenuOption.getAfter(selected);
    }

}
