package com.example.myapplicationfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationfood.customer.MenuQRActivity;
import com.example.myapplicationfood.owner.AllOrderActivity;

public class LoginActivity extends AppCompatActivity {
    TextView textView;
    EditText username, password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(view -> {
            if (username.getText().toString().equals("mohnish")) {
                startActivity(new Intent(this, AllOrderActivity.class));
            }else {
                startActivity(new Intent(this, MenuQRActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}