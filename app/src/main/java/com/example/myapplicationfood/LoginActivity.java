package com.example.myapplicationfood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationfood.customer.MenuQRActivity;
import com.example.myapplicationfood.dao.RestaurantDishesDao;
import com.example.myapplicationfood.dao.UserDetailsDao;
import com.example.myapplicationfood.dao.UserRegistrationDao;
import com.example.myapplicationfood.models.RestaurantDishes;
import com.example.myapplicationfood.models.UserDetails;
import com.example.myapplicationfood.owner.AllOrderActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    TextView textView, register;
    EditText username, password;
    Button loginButton;
    UserDetailsDao daoEmployee;
    ArrayList<UserDetails> employees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        register = findViewById(R.id.register);
        setuprv();
        loginButton.setOnClickListener(view -> {
            if (!username.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                for (int i = 0; i < employees.size(); i++) {
                    if (username.getText().toString().equals(employees.get(i).getUser_name())) {
                        if (password.getText().toString().equals(employees.get(i).getUser_pass())) {
                            if (employees.get(i).getUser_designation().equals("customer")) {
                                startActivity(new Intent(this, MenuQRActivity.class));
                            } else {
                                startActivity(new Intent(this, AllOrderActivity.class));
                            }
                            Toast.makeText(this, "login successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "invalid password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            }
        });
        register.setOnClickListener(view -> startActivity(new Intent(this, RegisterationActivity.class)));
    }

    private void setuprv() {
        daoEmployee = new UserDetailsDao();
        daoEmployee.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    UserDetails employee = dataSnapshot.getValue(UserDetails.class);
                    employees.add(employee);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}