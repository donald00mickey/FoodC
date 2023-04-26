package com.example.myapplicationfood.adapters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplicationfood.R;
import com.example.myapplicationfood.models.CartModel;
import com.example.myapplicationfood.models.RestaurantDishes;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MenuItemListAdapter extends RecyclerView.Adapter<MenuItemListAdapter.ViewHolder> {
    private Context context;
    ArrayList<RestaurantDishes> list = new ArrayList<>();


    public MenuItemListAdapter(Context context) {
        this.context = context;
    }

    public void setItems(ArrayList<RestaurantDishes> emp) {
        list.addAll(emp);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_menu_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RestaurantDishes restaurantDishes = list.get(position);
        holder.dish_tv.setText(restaurantDishes.getDish_name());
        holder.price_tv.setText(restaurantDishes.getPrice());
        Glide.with(holder.itemView.getContext()).load(restaurantDishes.getImage()).centerCrop().into(holder.dish_img);
        AtomicInteger a = new AtomicInteger();
        holder.plus.setOnClickListener(view -> {
            a.set(a.get() + 1);
            holder.count.setText(String.valueOf(a.get()));
            restaurantDishes.setCount(String.valueOf(a.get()));
        });
        holder.minus.setOnClickListener(view -> {
            if (a.get() <= 0) {
                a.set(0);
                Toast.makeText(view.getContext(), "Items cannot be less than ZERO", Toast.LENGTH_SHORT).show();
            } else {
                a.set(a.get() - 1);
            }

            restaurantDishes.setCount(String.valueOf(a.get()));
            holder.count.setText(String.valueOf(a.get()));
        });
        holder.count.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                restaurantDishes.setCount(holder.count.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dish_tv;
        TextView price_tv;
        EditText count;
        ImageView minus, plus, dish_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dish_tv = itemView.findViewById(R.id.dish_tv);
            price_tv = itemView.findViewById(R.id.price_tv);
            count = itemView.findViewById(R.id.count);
            minus = itemView.findViewById(R.id.minus);
            plus = itemView.findViewById(R.id.plus);
            dish_img = itemView.findViewById(R.id.dish_img);
        }
    }
}
