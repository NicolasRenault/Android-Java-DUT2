package com.example.myapplication.model.metier.controler;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import com.example.myapplication.model.metier.controler.CanonControler;


public class SensorControler implements SensorEventListener {

    private android.hardware.SensorManager sensorManager;
    private Sensor sensor;
    private CanonControler canonControler;
    private boolean on = false;

    public SensorControler(Context context, CanonControler canonControler){
        this.canonControler = canonControler;
        sensorManager = (android.hardware.SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensor = setSensor();
    }

    /**
     * This method select a type of Sensor depending on the phone device
     * @return Sensor
     */
    private Sensor setSensor() {
        Sensor tmp;
        tmp = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (tmp == null) {
            tmp = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
            //TODO message d'alert

            if (tmp == null) {
                tmp = sensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);
                //TODO message d'alert
            }
        }
        return tmp;
    }

    /**
     * On every sensor value change, if isOn is true, move the Canon
     * @param event
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (isOn()) {
            float value = event.values[0];
            canonControler.moveCanon(changeSensorValueByType(value));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void setListener() {
        sensorManager.registerListener(this, sensor, android.hardware.SensorManager.SENSOR_DELAY_GAME);
    }

    public void unsetListener() {
        sensorManager.unregisterListener(this);
    }

    /**
     * Convert the value return by the Sensor according to his type
     * @param value
     * @return float
     */
    private float changeSensorValueByType(float value) {
        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            return value;
        }
        else if (sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
            return -(value*10);
        }
        else if (sensor.getType() == Sensor.TYPE_GAME_ROTATION_VECTOR) {
            return value*10;
        }
        else return value;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

}
