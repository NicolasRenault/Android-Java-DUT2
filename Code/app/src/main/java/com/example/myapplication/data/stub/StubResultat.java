package com.example.myapplication.data.stub;

import com.example.myapplication.model.interfaces.SerializableObject;
import com.example.myapplication.model.statistic.Resultat;
import com.example.myapplication.model.statistic.Stats;

public class StubResultat implements SerializableObject {

    /**
     *
     * NotImplementedMethod
     */
    @Override
    public void writeObject(Object o) {

    }

    /**
     *
     * @return a Stats with a list not empty
     */
    @Override
    public Object readObject() {
        Stats stats = new Stats();

        stats.ajouterResultat(new Resultat(30, 0));
        stats.ajouterResultat(new Resultat(100, 0));
        stats.ajouterResultat(new Resultat(200, 2));
        stats.ajouterResultat(new Resultat(0, 2));
        stats.ajouterResultat(new Resultat(1000, 1));
        stats.ajouterResultat(new Resultat(50, 0));
        stats.ajouterResultat(new Resultat(63, 1));


        return stats;
    }
}
