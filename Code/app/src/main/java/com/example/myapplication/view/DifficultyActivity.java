package com.example.myapplication.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;
import com.example.myapplication.model.difficulty.DifficultyFragment;
import com.example.myapplication.model.difficulty.DifficultyManager;

public class DifficultyActivity extends AppCompatActivity {

    private DifficultyFragment newFragment;
    private DifficultyManager difficultyManager;
    private Button buttonrnext;
    private Button buttonback;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        init();



    }

    /**
     * create fragment
     */
    private void init() {
        buttonrnext = findViewById(R.id.buttonnext);
        buttonback = findViewById(R.id.buttonback);

        newFragment = new DifficultyFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        difficultyManager = new DifficultyManager();


        transaction.add(R.id.fragmentd, newFragment);


        transaction.commit();
    }

    /**
     *Change text and color of the fragment, that depend of the difficulty
     */
    public void handleNextButton(View view) {

        if (difficultyManager.getDiff() < 2) {
            difficultyManager.addDiff();
            newFragment.setText(difficultyManager.getDifficulty());
            newFragment.setColor(difficultyManager.getColor());
        }

        if(difficultyManager.getDiff() == 2)
            buttonrnext.setVisibility(View.INVISIBLE);

        if (difficultyManager.getDiff() == 1)
            buttonback.setVisibility(View.VISIBLE);


    }

    /**
     *Change text and color of the fragment, that depend of the difficulty
     */
    public void handleBackButton(View view) {

        if (difficultyManager.getDiff() > 0) {
            difficultyManager.removeDiff();
            newFragment.setText(difficultyManager.getDifficulty());
            newFragment.setColor(difficultyManager.getColor());

        }

        if(difficultyManager.getDiff() == 0)
            buttonback.setVisibility(View.INVISIBLE);

        if (difficultyManager.getDiff() == 1)
            buttonrnext.setVisibility(View.VISIBLE);


    }


}
