package com.example.myapplicationfood.customer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplicationfood.R;
import com.example.myapplicationfood.adapters.MenuItemListAdapter;
import com.example.myapplicationfood.customer.ProceedToCheckoutActivity;
import com.example.myapplicationfood.dao.CartModelDao;
import com.example.myapplicationfood.dao.RestaurantDishesDao;
import com.example.myapplicationfood.models.CartModel;
import com.example.myapplicationfood.models.MenuItemModel;
import com.example.myapplicationfood.models.RestaurantDishes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    Button protocheck;
    RecyclerView recyclerView;
    List<MenuItemModel> menuItemModels = new ArrayList<>();
    CartModelDao cartModelDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        protocheck = findViewById(R.id.protocheck);
        recyclerView = findViewById(R.id.recyclerView3);

        menuItemModels.add(new MenuItemModel("Dosa", "200", ""));
        menuItemModels.add(new MenuItemModel("Idli", "100", ""));
        menuItemModels.add(new MenuItemModel("Uttapam", "100", ""));
        menuItemModels.add(new MenuItemModel("Samosa", "30", ""));

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new MenuItemListAdapter(menuItemModels));

        protocheck.setOnClickListener(view -> {
            startActivity(new Intent(this, ProceedToCheckoutActivity.class));
        });

    }
}