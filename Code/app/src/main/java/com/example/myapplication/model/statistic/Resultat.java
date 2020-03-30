package com.example.myapplication.model.statistic;

import java.io.Serializable;

public class Resultat implements Serializable{

    private int score;
    private int difficulty;

    /**
     * Construcot
     * @param score score of the game
     * @param difficulty difficulty of the game
     */
    public Resultat(int score, int difficulty) {
        this.score = score;
        this.difficulty = difficulty;
    }

    /**
     * let this in public, it is used on Adaptateur
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @return difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }
}
