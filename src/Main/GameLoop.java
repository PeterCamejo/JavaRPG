//package Main;
//
//
//import controllers.MainMenuViewController;
//import models.StateModel.MainMenuModel;
//import utilities.GameStateManager;
//import utilities.State.State;
//import views.Canvas;
//import views.MainMenuView;
//
//import javax.swing.*;
//import java.awt.image.BufferedImage;
//
///**
// * Created by denzel on 4/11/16.
// */
//
//
////The Game Loop
//public class GameLoop implements Runnable{
//
//
//
//    private final int FPS = 30;
//    private final int TIME_PER_TICK = 1000/FPS;
//    private long timePerTick;
//    private boolean isRunning = true;
//
//
//    public GameLoop(){
//
//
//        initFrame();
//        gameFrame.add(canvas);
//        gameFrame.pack();
//
//
//
//
//    }
//
//    public void initFrame(){
//        gameFrame = new RunGame();
//        gameFrame.setTitle("WTF Game");
//        gameFrame.setLocationRelativeTo(null);
//        gameFrame.setVisible(true);
//        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//    @Override
//    public void run() {
//        int fps = 30;
//        timePerTick = 1000 / fps;
//
//        long start;
//        long elapsed;
//        long wait;
//
//        while(isRunning){
//
//            start = System.currentTimeMillis();
//
//            update();
//            render();
//
//            elapsed = System.currentTimeMillis() - start;
//            wait = timePerTick - elapsed;
//
//            if(wait > 0 ){
//                try{
//                    Thread.sleep(wait);
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    //update
//    public void update(){
//        gsm.update();
//    }
//
//    //render
//    public void render(){
//        gsm.render(canvas);
//    }
//}
