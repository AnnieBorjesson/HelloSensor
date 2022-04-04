package com.example.individuellid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Accelerometer extends AppCompatActivity implements SensorEventListener{
    SensorManager mSensorManager;
    Sensor mAccelerometer;
    private TextView outputX, outputY, outputZ, lutningX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**Koppla till acc-layouten**/
        setContentView(R.layout.activity_acc);
        /**Vit bakgrund**/
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        /**Koppla till layoutens id**/
        outputX = findViewById(R.id.AccX);
        outputY = findViewById(R.id.AccY);
        outputZ = findViewById(R.id.AccZ);
        lutningX =findViewById(R.id.textView6);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor mySensor = event.sensor;

        /**Avrundar med Math.round för att visa utan deciamler**/
        if(mySensor.getType() == Sensor.TYPE_ACCELEROMETER){
            outputX.setText(String.valueOf(Math.round(event.values[0])));
            outputY.setText(String.valueOf(Math.round(event.values[1])));
            outputZ.setText(String.valueOf(Math.round(event.values[2])));
        }
        if(outputX.equals(0) && outputY.equals(0)) {
            lutningX.setText("Rakt");
            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        }
        /**Om man lutar åt höger visas texten Höger, annars Vänster**/
        else if (event.values[0] < 0 ) {
            lutningX.setText("Höger");
            getWindow().getDecorView().setBackgroundColor(Color.BLUE);
        }
        else {
            lutningX.setText("Vänster");
            getWindow().getDecorView().setBackgroundColor(Color.RED);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}