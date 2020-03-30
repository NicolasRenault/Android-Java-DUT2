package com.example.myapplication.view;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {

    private ImageView imageViewCanon;
    private TextView sensorValue;
    private Sensor sensor;
    private SensorManager sensorManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        init();

    }

    /**
     *create accelerometer sensor
     */
    private void init(){
        imageViewCanon = findViewById(R.id.imageviewaccelerometer);
        sensorValue = findViewById(R.id.textViewSensorValue);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    /**
     * start the sensor on this activity
     */
    @Override
    protected void onPostResume() {
        super.onPostResume();
        sensorManager.registerListener(this, sensor, 20);
    }

    /**
     * stop the censor
     */
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    /**
     * update the value of the imageView
     * @param event is used to get the values of the sensor
     */
    @Override
    public void onSensorChanged(SensorEvent event) {

        sensorValue.setText(String.valueOf(event.values[0]));
        imageViewCanon.setX(imageViewCanon.getX() - event.values[0]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
