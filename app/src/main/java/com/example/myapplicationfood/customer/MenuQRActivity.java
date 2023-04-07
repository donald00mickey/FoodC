package com.example.myapplicationfood.customer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplicationfood.R;
import com.example.myapplicationfood.adapters.MenuItemListAdapter;
import com.example.myapplicationfood.models.MenuItemModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

public class MenuQRActivity extends AppCompatActivity {

    FloatingActionButton menu;
    FloatingActionButton qr;
    RecyclerView recyclerView;
    List<MenuItemModel> menuItemModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_qractivity);

        menu = findViewById(R.id.menu);
        recyclerView = findViewById(R.id.recyclerView);

        menuItemModels.add(new MenuItemModel("Dosa", "200", ""));
        menuItemModels.add(new MenuItemModel("Idli", "100", ""));
        menuItemModels.add(new MenuItemModel("Uttapam", "100", ""));
        menuItemModels.add(new MenuItemModel("Samosa", "30", ""));
        menuItemModels.add(new MenuItemModel("Kachori", "40", ""));
        menuItemModels.add(new MenuItemModel("Wada", "30", ""));
        menuItemModels.add(new MenuItemModel("Bhajiya", "20", ""));
        menuItemModels.add(new MenuItemModel("Sambhar wada", "40", ""));

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MenuItemListAdapter(menuItemModels));
        qr = findViewById(R.id.qr);

        menu.setOnClickListener(view -> {
            startActivity(new Intent(this, CartActivity.class));
        });

        qr.setOnClickListener(view -> {
            IntentIntegrator intentIntegrator = new IntentIntegrator(this);
            intentIntegrator.setPrompt("Scan a barcode or QR Code");
            intentIntegrator.setBarcodeImageEnabled(false);
            intentIntegrator.setOrientationLocked(true);
            intentIntegrator.initiateScan();
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
                Toast.makeText(this, intentResult.getContents(), Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, MenuQRActivity.class));
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}