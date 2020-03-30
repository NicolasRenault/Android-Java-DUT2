package com.example.myapplication.view;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.model.interfaces.OnGameRefreshListener;
import com.example.myapplication.model.GameManager;


public class PlayActivity extends AppCompatActivity implements OnGameRefreshListener {

    private GameManager gameManager;
    private GameView gameView;
    private boolean run = false;
    private Button buttonStart;
    private TextView textInstruction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        gameView = findViewById(R.id.gameView);
        gameManager = new GameManager(getApplicationContext(),  this);
        gameView.setList(gameManager.getEntityList());
        buttonStart =  findViewById(R.id.buttonStart);
        textInstruction = findViewById(R.id.textInstruction);
    }

    /**
     *
     * Used to throw ball
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            gameManager.throwBall();
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameManager.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gameManager.pause();
    }

    public int getHeightScreen(){
        return this.getResources().getDisplayMetrics().heightPixels;
    }

    public int getWidthScreen(){
        return this.getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    public void onGameRefresh() {
        gameView.invalidate();
    }

    /**
     * Control the button Start and Pause
     * @param view
     */
    public void handleStart(View view) {

        if (!run){
            gameManager.resume();
            buttonStart.setText(R.string.pause);
            textInstruction.setText("");
            run = true;
        }

        else {
            gameManager.pause();
            buttonStart.setText(R.string.start);
            textInstruction.setText(R.string.instruction);
            run = false;
        }
    }
}
