package com.example.myapplicationfood.owner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplicationfood.AddMenuActivity;
import com.example.myapplicationfood.R;
import com.example.myapplicationfood.adapters.OrderAdapter;
import com.example.myapplicationfood.models.OrderModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AllOrderActivity extends AppCompatActivity {
    TextView order_detail;
    RecyclerView recyclerView;
    FloatingActionButton add_menu;
    List<OrderModel> orderModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_order);

        recyclerView = findViewById(R.id.recyclerView2);
        add_menu = findViewById(R.id.add_menu);

        add_menu.setOnClickListener(view -> startActivity(new Intent(this, AddMenuActivity.class)));

        orderModelList.add(new OrderModel("403012", "pending", "01", "200"));
        orderModelList.add(new OrderModel("403013", "completed", "02", "510"));
        orderModelList.add(new OrderModel("403014", "in-progress", "03", "210"));
        orderModelList.add(new OrderModel("403015", "pending", "04", "260"));
        orderModelList.add(new OrderModel("403016", "completed", "05", "500"));
        orderModelList.add(new OrderModel("403017", "in-progress", "06", "400"));

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new OrderAdapter(orderModelList));

    }
}