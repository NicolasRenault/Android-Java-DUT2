package com.example.myapplication.model;

import android.content.Context;

import com.example.myapplication.model.metier.controler.BallControler;
import com.example.myapplication.model.metier.controler.CanonControler;
import com.example.myapplication.model.metier.controler.SensorControler;
import com.example.myapplication.model.metier.game_entity.GameEntity;
import com.example.myapplication.model.interfaces.OnGameRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private CanonControler canonControler;
    private BallControler ballControler;
    private SensorControler sensorController;
    private OnGameRefreshListener gameRefreshListener;
    private List<GameEntity> entityList;
    private int i = 0;

    private boolean running = true;
    private int FPS = 16;

    public GameManager(Context context, OnGameRefreshListener gameRefreshListener)  {
        canonControler = new CanonControler(context.getResources().getDisplayMetrics().widthPixels, context.getResources().getDisplayMetrics().heightPixels);
        ballControler = new BallControler(context.getResources().getDisplayMetrics().widthPixels, context.getResources().getDisplayMetrics().heightPixels, canonControler.getCanon());
        sensorController = new SensorControler(context, canonControler);
        this.gameRefreshListener = gameRefreshListener;
        entityList = new ArrayList<>();
    }

    /**
     * GameLoop used to control all Entity Controller
     */
    private Thread gameLoop = new Thread() {
        @Override
        public void run() {
            while(true) {
                while (running) {
                    long start = System.currentTimeMillis();

                    sensorController.setOn(true);
                    ballControler.moveBalls();

                    long end = System.currentTimeMillis();
                    if (FPS > (end - start)) {
                        try {
                            sleep((end - start));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    gameRefreshListener.onGameRefresh();
                    sensorController.setOn(false);
                }
            }
        }
    };

    public List<GameEntity> getEntityList() {
        return entityList;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * Call the ballController to create a new Ball and add it to entityList
     */
    public void throwBall() {
        if (running) {
            entityList.add(ballControler.throwBall());
        }
    }

    private void fillList() {
        entityList.add(canonControler.getCanon());
    }

    private void start() {
        fillList();
        setRunning(true);
        canonControler.setRun(true);
        if (i == 0) {
            gameLoop.start();
            i++;
        }
    }

    private void stop() {
        setRunning(false);
        canonControler.setRun(false);
    }

    public void resume(){
        sensorController.setListener();
        start();
    }

    public void pause(){
        sensorController.unsetListener();
        stop();
    }

}
