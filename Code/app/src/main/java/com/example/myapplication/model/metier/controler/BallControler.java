package com.example.myapplication.model.metier.controler;

import android.util.Log;

import com.example.myapplication.model.metier.game_entity.Ball;
import com.example.myapplication.model.metier.game_entity.Canon;
import com.example.myapplication.model.metier.game_entity.GameEntity;

import java.util.ArrayList;
import java.util.List;

public class BallControler {


    private List<Ball> ballList = new ArrayList<Ball>();
    private List<Ball> moveList = new ArrayList<Ball>();
    private int width;
    private int height;
    private Canon canon;
    private int MAXBALL = 30;


    public BallControler(int width, int height, Canon canon) {
        this.width = width;
        this.height = height;
        this.canon = canon;
    }

    /**
     * Move all the ball in the ballList
     * Also use a temporary array to avoid conflict
     */
    public void moveBalls() {
        if (ballList == null) createBall();
        moveList.addAll(ballList);
        for (Ball ball : moveList) {
            if (ball != null) {
                Log.d("Nico", "moveBalls: "+ball.getY()+" height : "+ -height);
                if (ball.getY() < -height) {
                    ball.setY(canon.getY()-10);
                    ball.setX((int) (canon.getX()+77d));
                }
                ball.setY(ball.getY()-1);
            }
        }
        moveList.clear();
    }

    /**
     * Create and add a new ball to the ballList
     * @return Ball
     */
    private Ball createBall() {
        Ball ball = new Ball((int) (canon.getX()+77d), canon.getY()-10);
        ballList.add(ball);
        return ball;
    }

    /**
     * This method is a buffer that avoid to create to much Ball
     * @return GameEntity
     */
    public GameEntity throwBall() {
        if (ballList.size() < MAXBALL) {
            return createBall();
        }
        return null;
    }
}
