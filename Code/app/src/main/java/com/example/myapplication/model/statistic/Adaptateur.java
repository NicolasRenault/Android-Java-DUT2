package com.example.myapplication.model.statistic;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.myapplication.model.statistic.Resultat;

import java.util.List;

public class Adaptateur extends ArrayAdapter<Resultat> {

    private Context context;

    /**
     *Constructor
     * @param context of ResultsActivity
     * @param resource type of list
     * @param objects list of the results
     */
    public Adaptateur(@NonNull Context context, int resource, @NonNull List<Resultat> objects) {
        super(context, resource, objects);
        this.context = context;

    }

    /**
     *
     * @param position position on the list
     * @return the textView score which is the score of the player
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        super.getView(position, convertView, parent);

        TextView score = new TextView(parent.getContext());
        score.setText(String.valueOf(getItem(position).getScore()));

        return score;


    }
}


