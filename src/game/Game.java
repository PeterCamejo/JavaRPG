package game;

import views.Assets;
import views.Display;

import java.awt.*;
import java.awt.font.GraphicAttribute;
import java.awt.image.BufferStrategy;

/**
 *
 */
public class Game implements Runnable{
    /* Attributes */
    private Display display;
    int width, height;
    public String title;

    private Thread thread;
    private boolean running;

    private BufferStrategy bufferStrategy;
    private Graphics g;

    //Test
    int x = 0;

    /* Constructor */
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
        //Test
        x++;
    }

    private void render(){
        bufferStrategy = display.getCanvasBufferStrategy();
        if(bufferStrategy == null){
            display.createCanvasBufferStrategy(3);
            return;
        }

        g = bufferStrategy.getDrawGraphics();
        g.clearRect(0 , 0 , width , height);


        g.setColor(Color.CYAN);
        g.fillRect(x , 40 , 50 , 50);



        bufferStrategy.show();
        g.dispose();



    }

    public void run(){
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps ; // 1sec / fps
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime)/ timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                //System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
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