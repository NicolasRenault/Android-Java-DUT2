package com.example.myapplication.model.difficulty;

import com.example.myapplication.R;

public class DifficultyManager {

    private String difficulty;

    //0 = Facile / 1 = Normal / 2 = Difficile
    private int diff;

    /**
     * Constructor
     */
    public DifficultyManager(){
        difficulty = "Normal";
        diff = 1;
    }


    /**
     *
     * @return the int difficulty
     */
    public int getDiff(){
        return diff;
    }

    /**
     *
     * @return the difficulty
     */
    public String getDifficulty(){
        return difficulty;
    }

    /**
     * Increase the difficulty and update the difficulty string
     */
    public void addDiff() {
        diff++;
        updateDiff();
        updateDifficulty();
    }

    /**
     * decrease difficulty and update the difficulty string
     */
    public void removeDiff(){
        diff--;
        updateDiff();
        updateDifficulty();
    }

    /**
     * update the int difficulty
     */
    private void updateDiff(){
        if (diff < 0)
            diff = 0;
        diff = diff%3;

    }

    /**
     * update the string difficulty
     */
    private void updateDifficulty() {
        if (diff == 0) {
            difficulty = "Facile";
        }

        if (diff == 1) {
            difficulty = "Normal";
        }

        if(diff == 2){
            difficulty = "Difficile";
        }
    }

    /**
     * get the color link to the difficulty
     * @return color link to the difficulty
     */
    public int getColor() {
        if(diff == 0)
            return R.color.green;

        if(diff == 1)
            return R.color.orange;

        else
            return R.color.red;
    }

    /**
     *
     * @param diff is the int
     * @return string difficulty which depends of the int difficulty
     */
    public String getDifficultybyInt(int diff) {
        String difficulty = null;
        if (diff == 0) {
            difficulty = "Facile";
        }

        if (diff == 1) {
            difficulty = "Normal";
        }

        if(diff == 2){
            difficulty = "Difficile";
        }

        return difficulty;
    }
}
