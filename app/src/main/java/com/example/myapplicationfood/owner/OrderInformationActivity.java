package com.example.myapplicationfood.owner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplicationfood.R;
import com.example.myapplicationfood.adapters.MenuItemListAdapter;
import com.example.myapplicationfood.models.MenuItemModel;

import java.util.ArrayList;
import java.util.List;

public class OrderInformationActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<MenuItemModel> menuItemModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_information);

        recyclerView = findViewById(R.id.recyclerView4);

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

    }
}