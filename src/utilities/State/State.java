package utilities.State;

import controllers.Controller;
import views.View;

/**
 * Created by denzel on 4/11/16.
 */
//The state object couples the View and Controller
public class State {

    protected Controller controller;
    protected View view;

    public State(View view, Controller controller){
        this.controller = controller;
        this.view = view;

    }

    //getters
    public View getView(){
        return view;
    }

    public Controller getController(){
        return controller;
    }
}
