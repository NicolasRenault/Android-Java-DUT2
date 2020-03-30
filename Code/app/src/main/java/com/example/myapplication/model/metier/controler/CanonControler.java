package com.example.myapplication.model.metier.controler;


import com.example.myapplication.model.metier.game_entity.Canon;


public class CanonControler {

    private Canon canon;
    private int width;
    private int height;
    private boolean run = false;



    public CanonControler(int width, int height) {
        this.width = width;
        this.height = height;
        canon = new Canon(0, height-300);
    }

    public void moveCanon(float value) {

        if (isRun()) {

            if (canon.getX() - value < 0 || canon.getX() - value > (width)) {
                canon.setX(canon.getX());
            }
            else{
                canon.setX((int) (canon.getX() - 2 * value));
            }
        }
    }

    private boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public Canon getCanon() {
        return canon;
    }
}
