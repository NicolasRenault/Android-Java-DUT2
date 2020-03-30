package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.example.myapplication.R;


public class MainActivity extends AppCompatActivity {


    /**
     *
     * Create the activity link to activity_main
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * Start PlayActivity
     */
    public void handlePlayButton(View view) {
        Intent intent = new Intent(this,PlayActivity.class);
        startActivity(intent);
    }

    /**
     *
     * Start ResultsActivity
     */
    public void handleResultsButton(View view) {
        Intent intent = new Intent(this,ResultsActivity.class);
        startActivity(intent);
    }

    /**
     *
     * Start DifficultyActivity
     */
    public void handleDifficultyButton(View view){
        Intent intent = new Intent(this,DifficultyActivity.class);
        startActivity(intent);
    }

    /**
     *
     * Start AccelerometerActivity
     */
    public void handleAccelerometreButton(View view){
        Intent intent = new Intent(this,AccelerometerActivity.class);
        startActivity(intent);
    }


}
