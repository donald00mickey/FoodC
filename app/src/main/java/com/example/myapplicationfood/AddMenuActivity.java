package com.example.myapplicationfood;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationfood.models.RestaurantDishes;

public class AddMenuActivity extends AppCompatActivity {
    EditText dish, price;
    Button addDish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);

        dish = findViewById(R.id.dish);
        price = findViewById(R.id.price);
        addDish = findViewById(R.id.add_dish);
        addDish.setOnClickListener(view -> add_menu(dish.getText().toString(), price.getText().toString(), ""));
    }

    public void add_menu(String dish_name, String price, String image) {
        RestaurantDishesDao restaurantDishesDao = new RestaurantDishesDao();
        RestaurantDishes employee = new RestaurantDishes(dish_name, price, image);
        restaurantDishesDao.add(employee).addOnSuccessListener(succ -> {
            Toast.makeText(this, "Record Inserted", Toast.LENGTH_SHORT).show();
        }).addOnFailureListener(fail -> {
            Toast.makeText(this, "" + fail.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }
}