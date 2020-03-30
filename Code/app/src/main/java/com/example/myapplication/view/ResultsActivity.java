package com.example.myapplication.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.model.difficulty.DifficultyManager;
import com.example.myapplication.model.statistic.Stats;
import com.example.myapplication.data.serializable.SerializableResultat;
import com.example.myapplication.model.statistic.Adaptateur;

public class ResultsActivity extends AppCompatActivity {

    private Stats stats;
    private SerializableResultat ser;
    private TextView textView;
    private int diff;
    private String difficulty;
    private DifficultyManager difficultyManager;

    /**
     *
     * Create the activity link to the layout activity_results
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        init();

    }

    /**
     * serialize stats when this activity is closed
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();

        ser.writeObject(stats);
        Log.d("MAXIME", "SERIALIZATION");
    }

    /**
     *
     * Results or deserialize
     * set the adapter on the listView of results
     *Enable the user to select a score and see the difficulty of this score with the setOnItemClickListener
     */
    private void init() {
        final ListView listView = findViewById(R.id.listview);
        textView = findViewById(R.id.textviewDifficulty);
        difficultyManager = new DifficultyManager();

        //stats = StubResultat.chargerStats();

        ser = new SerializableResultat(this);
        stats = (Stats) ser.readObject();
        Log.d("MAXIME", "DESERIALIZATION");

        final Adaptateur adaptateur = new Adaptateur(this, android.R.layout.simple_list_item_1, stats.getStats());


        listView.setAdapter(adaptateur);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                diff = adaptateur.getItem(position).getDifficulty();
                difficulty = difficultyManager.getDifficultybyInt(diff);

                textView.setText(difficulty);


            }
        });

    }
}
