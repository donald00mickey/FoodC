package com.example.myapplicationfood.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationfood.R;
import com.example.myapplicationfood.models.OrderModel;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    List<OrderModel> orderModelList;

    public OrderAdapter(List<OrderModel> orderModelList) {
        this.orderModelList = orderModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_table_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderModel orderModel = orderModelList.get(position);
        holder.order_no.setText(orderModel.getOrder_no());
        holder.status.setText(orderModel.getStatus());
        holder.table_no.setText(orderModel.getTable_no());
        holder.price.setText(orderModel.getPrice());
    }

    @Override
    public int getItemCount() {
        return orderModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView order_no, status, table_no, price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            order_no = itemView.findViewById(R.id.order_no);
            status = itemView.findViewById(R.id.status);
            table_no = itemView.findViewById(R.id.table_no);
            price = itemView.findViewById(R.id.price);
        }
    }
}
