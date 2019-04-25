package com.smartti.finer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.app.adprogressbarlib.AdCircleProgress;

public class MainActivity extends AppCompatActivity {

    private AdCircleProgress _progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _progressBar = findViewById(R.id.progressSplash);

        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();
    }

    private void doWork() {

        for (int p = 0; p <= 100; p++) {
            try {
                Thread.sleep(20);
                _progressBar.setAdProgress(p);
            }catch (Exception e) {
                e.printStackTrace();
                Log.d("Error: ", e.getMessage());
            }
        }

    }

    private void startApp() {
        Intent intent = new Intent(this, GetStarted.class);
        startActivity(intent);
    }
}
