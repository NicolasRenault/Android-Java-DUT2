package com.example.myapplication.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.model.metier.game_entity.Ball;
import com.example.myapplication.model.metier.game_entity.Canon;
import com.example.myapplication.model.metier.game_entity.GameEntity;

import java.util.List;


public class GameView extends View {

    private List<GameEntity> entityList;
    private Paint paint = new Paint();
    private Bitmap bitmapCanon;
    private Bitmap bitmapBall;


    public GameView(Context context) {
        super(context);
        init();
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setList(List<GameEntity> entityList) {
        this.entityList = entityList;
    }

    /**
     * At initiation create 2 bitmap for each Entity
     */
    private void init() {
        bitmapCanon = BitmapFactory.decodeResource(getResources(), R.drawable.canon);
        bitmapBall = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
    }

    /**
     * For each entity in entityList, draw with the good bitmap
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        for (GameEntity entity: entityList) {
            if (entity instanceof Canon) {
                canvas.drawBitmap(bitmapCanon, entity.getX(), entity.getY(), paint);
            }
            else if (entity instanceof Ball) {
                canvas.drawBitmap(bitmapBall, entity.getX(), entity.getY(), paint);
            }
        }

    }
}
