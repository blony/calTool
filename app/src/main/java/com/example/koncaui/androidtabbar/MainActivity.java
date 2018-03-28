package com.example.koncaui.androidtabbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //去除标题栏
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent1 = new Intent(MainActivity.this,RadioGroupTabActivity.class);
                startActivity(intent1);
                MainActivity.this.finish();
            }
        };
        timer.schedule(timerTask,1000*2);

    }

}
