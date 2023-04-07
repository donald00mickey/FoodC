package com.example.myapplicationfood.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationfood.R;
import com.example.myapplicationfood.models.MenuItemModel;

import java.util.List;

public class MenuItemListAdapter extends RecyclerView.Adapter<MenuItemListAdapter.ViewHolder> {
    List<MenuItemModel> menuItemModels;
    int a = 0;

    public MenuItemListAdapter(List<MenuItemModel> menuItemModels) {
        this.menuItemModels = menuItemModels;
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
        MenuItemModel menuItemModel = menuItemModels.get(position);
        holder.dish_tv.setText(menuItemModel.getName());
        holder.price_tv.setText(menuItemModel.getPrice());
        holder.plus.setOnClickListener(view -> {
            a = a + 1;
            holder.count.setText(String.valueOf(a));
        });
        holder.minus.setOnClickListener(view -> {
            if (a <= 0) {
                a = 0;
                Toast.makeText(view.getContext(), "Items cannot be less than ZERO", Toast.LENGTH_SHORT).show();
            } else {
                a = a - 1;
            }
            holder.count.setText(String.valueOf(a));
        });
    }

    @Override
    public int getItemCount() {
        return menuItemModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dish_tv;
        TextView price_tv, count;
        ImageView minus, plus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dish_tv = itemView.findViewById(R.id.dish_tv);
            price_tv = itemView.findViewById(R.id.price_tv);
            count = itemView.findViewById(R.id.count);
            minus = itemView.findViewById(R.id.minus);
            plus = itemView.findViewById(R.id.plus);
        }
    }
}
