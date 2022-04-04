package com.example.individuellid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button compassButton;
    Button accButton;

/**Kod från Android Studio**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compassButton = (Button) findViewById(R.id.button3);
        compassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compass(v);
            }
        });
        accButton = (Button) findViewById(R.id.button4);
        accButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accelerometer(v);
            }
        });
    }

    /** Called when the user taps the Compass button */
    public void compass(View view){
        Intent intent = new Intent(this, Compass.class);
        startActivity(intent);
    }

    /** Called when the user taps the Direction button */
    public void accelerometer(View view){
        Intent intent = new Intent(this, Accelerometer.class);
        startActivity(intent);
    }

}