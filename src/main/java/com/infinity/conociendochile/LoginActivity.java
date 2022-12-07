package com.infinity.conociendochile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;


import com.infinity.conociendochile.R;

public class LoginActivity extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    int vuelo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (sensor == null)
            finish();

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float x = sensorEvent.values[0];
                System.out.println("valor giro" + x);
                if (x < -5 && vuelo == 0) {
                    vuelo++;
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                } else if (x > 5 && vuelo == 1) {
                    vuelo++;
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                }

                if (vuelo == 2) {
                    sound();
                    vuelo=0;
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        start();
    }

    private void sound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.vueloavion);
        mediaPlayer.start();
    }

    private void start() {
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void stop() {
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        super.onResume();
    }

    public void Login (View view){
        Intent Login = new Intent(this, Principal_Activity.class);
        startActivity(Login);
    }

    public void Contacto (View view){
        Intent Contacto = new Intent(this, MainActivityL.class);
        startActivity(Contacto);
    }


}