package com.example.myapplication.model.statistic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stats implements Serializable {

    private ArrayList<Resultat> stats;

    /**
     * Constructor
     */
    public Stats(){
        stats = new ArrayList<>();
    }

    /**
     * add a result on the list stats
     * @param r is a results
     */
    public void ajouterResultat(Resultat r){
        stats.add(r);

    }

    /**
     *
     * @return the list stats, but the unmodifiable version
     */
    public List<Resultat> getStats(){
        return Collections.unmodifiableList(stats);
    }



}
