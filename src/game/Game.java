package game;

import views.Display;

import java.util.DuplicateFormatFlagsException;

/**
 *
 */
public class Game implements Runnable{
    private Display display;
    int width, height;
    public String title;

    private Thread thread;
    private boolean running;


    public Game(String title , int width, int height){
        this.width =    width;
        this.height =   height;
        this.title = title;
        running = false;
    }

    public void init(){
        display = new Display(title, width, height);
    }

    private void tick(){

    }

    private void render(){

    }

    public void run(){
        init();

        while(running){
            tick();
            render();
        }

        stop();
    };
    public synchronized void start(){
        if(running){
            return; //do nothing
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running){
            return; //do nothing
        }
        running = false;
        try{
            thread.join();
        }catch(Exception e){
            e.printStackTrace();
        }
};
}
