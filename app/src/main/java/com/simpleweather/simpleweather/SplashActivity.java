package com.simpleweather.simpleweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        for(int i=0; i<100000; i+=2){
            i--;
        }
        startActivity(intent);
        finish();
    }
}