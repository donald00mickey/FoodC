package com.example.myapplicationfood.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplicationfood.R;
import com.example.myapplicationfood.customer.ProceedToCheckoutActivity;

public class CartActivity extends AppCompatActivity {
    TextView protocheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        protocheck = findViewById(R.id.protocheck);
        protocheck.setOnClickListener(view -> {
            startActivity(new Intent(this, ProceedToCheckoutActivity.class));
        });
    }
}