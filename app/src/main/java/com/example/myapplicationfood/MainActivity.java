package com.example.myapplicationfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        Runnable runnable = () -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        };
        handler.postDelayed(runnable, 3000);

    }
}