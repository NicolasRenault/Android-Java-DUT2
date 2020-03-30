package com.example.myapplication.model.metier.game_entity;

public class GameEntity {
    private int X, Y;

    public GameEntity(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }
}
