package com.example.myapplicationfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplicationfood.customer.MenuQRActivity;
import com.example.myapplicationfood.models.UserDetails;

public class RegisterationActivity extends AppCompatActivity {

    EditText username, password;
    Button registrationButton;
    RadioButton radioButton;
    String designation = "customer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        registrationButton = findViewById(R.id.registrationButton);
        radioButton = findViewById(R.id.radioButton);

        if (radioButton.isChecked()) {
            designation = "owner";
        } else {
            designation = "customer";
        }

        registrationButton.setOnClickListener(view -> {
            UserDetailsDao daoEmployee = new UserDetailsDao();
            UserDetails employee = new UserDetails(username.getText().toString(), password.getText().toString(), designation);
            daoEmployee.add(employee).addOnSuccessListener(success -> {
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
            }).addOnFailureListener(failure -> {
                Toast.makeText(this, "Registration failed" + failure.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
    }
}