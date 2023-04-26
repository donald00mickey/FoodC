package com.example.myapplicationfood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplicationfood.R;
import com.example.myapplicationfood.models.RestaurantDishes;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private Context context;
    ArrayList<RestaurantDishes> list;

    public CartAdapter(Context context, ArrayList<RestaurantDishes> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_cart_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RestaurantDishes restaurantDishes = list.get(position);
        holder.dish_tv.setText(restaurantDishes.getDish_name());
        holder.price_tv.setText(restaurantDishes.getPrice());
        holder.count.setText(restaurantDishes.getCount());
        Glide.with(holder.itemView.getContext()).load(restaurantDishes.getImage()).centerCrop().into(holder.dish_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dish_tv;
        TextView price_tv;
        TextView count;
        ImageView dish_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dish_tv = itemView.findViewById(R.id.dish_tv_cart);
            price_tv = itemView.findViewById(R.id.price_tv_cart);
            count = itemView.findViewById(R.id.count_cart);
            dish_img = itemView.findViewById(R.id.dish_img_cart);
        }
    }
}
