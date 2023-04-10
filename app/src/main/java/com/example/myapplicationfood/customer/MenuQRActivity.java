package com.example.myapplicationfood.customer;

import static android.view.View.INVISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationfood.R;
import com.example.myapplicationfood.adapters.MenuItemListAdapter;
import com.example.myapplicationfood.dao.RestaurantDishesDao;
import com.example.myapplicationfood.models.CartModel;
import com.example.myapplicationfood.models.MenuItemModel;
import com.example.myapplicationfood.models.RestaurantDishes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

public class MenuQRActivity extends AppCompatActivity {

    FloatingActionButton menu;
    ArrayList<CartModel> cartModels = new ArrayList<>();
    FloatingActionButton qr;
    RecyclerView recyclerView;
    List<MenuItemModel> menuItemModels = new ArrayList<>();
    RestaurantDishesDao daoEmployee;
    MenuItemListAdapter adapter;
    ArrayList<RestaurantDishes> employees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_qractivity);

        qr = findViewById(R.id.qr);
        menu = findViewById(R.id.menu);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MenuItemListAdapter(this);
        recyclerView.setAdapter(adapter);
        setuprv();

        qr.setOnClickListener(view -> {
            IntentIntegrator intentIntegrator = new IntentIntegrator(this);
            intentIntegrator.setPrompt("Scan a barcode or QR Code");
            intentIntegrator.setBarcodeImageEnabled(false);
            intentIntegrator.setOrientationLocked(true);
            intentIntegrator.initiateScan();
        });
    }

    private void setuprv() {
        daoEmployee = new RestaurantDishesDao();
        daoEmployee.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    RestaurantDishes employee = dataSnapshot.getValue(RestaurantDishes.class);
                    employees.add(employee);
                }
                adapter.setItems(employees);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(getBaseContext(), "Cancelled", Toast.LENGTH_SHORT).show();
            } else {
                recyclerView.setVisibility(INVISIBLE);
                Toast.makeText(this, intentResult.getContents(), Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, MenuQRActivity.class));
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}