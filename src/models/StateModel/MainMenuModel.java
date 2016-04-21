package models.StateModel;

import utilities.State.State;

/**
 * Created by jcvarela on 4/12/2016.
 */
public class MainMenuModel{

    public enum MainMenuOption{
        Start("Create Game"),
        NewGame("Load Game"),
        Exit("Exit Game");

        private String name;

        MainMenuOption(String name){
            this.name = name;
        }

        public static MainMenuOption getPrev(MainMenuOption selected){
            int pos = selected.ordinal();
            if(pos == 0){
                return MainMenuOption.values()[MainMenuOption.values().length -1];
            }
            return MainMenuOption.values()[pos -1];
        }
        public static MainMenuOption getAfter(MainMenuOption selected){

            int pos = selected.ordinal();
            if(pos == MainMenuOption.values().length-1){
                return MainMenuOption.values()[0];
            }
            return MainMenuOption.values()[pos + 1];
        }


        @Override
        public String toString(){
            return name;
        }

    }

    private MainMenuOption selected;

    public MainMenuModel(){
        selected = MainMenuOption.Start;
    }


    public MainMenuOption getSelected(){
        return selected;
    }


    public void up(){
        selected = MainMenuOption.getPrev(selected);
    }

    public void down(){
        selected = MainMenuOption.getAfter(selected);
    }

}
