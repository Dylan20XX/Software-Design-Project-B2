package com.example.fileioexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fileioexample.store.Order;
import com.example.fileioexample.store.Product;
import android.view.View;

import java.util.ArrayList;

public class CustOrderAdapter extends RecyclerView.Adapter<CustOrderAdapter.CustOrderViewHolder> {
    Context context;
    ArrayList<CustOrder> Order;

    public CustOrderAdapter(Context context, ArrayList<CustOrder> Order){
        this.context = context;
        this.Order = Order;
    }

    @NonNull
    @Override
    public CustOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cust_order_layout,parent,false);
        return new CustOrderViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustOrderViewHolder holder, int position) {
        CustOrder o = Order.get(position);
        holder.OrderInfo.setText(o.toString());
        holder.Orderstatus.setText("Order fulfilled: "+o.getFulfilled());
    }

    @Override
    public int getItemCount() {
        return Order.size();
    }

    public static class CustOrderViewHolder extends RecyclerView.ViewHolder{
        TextView OrderInfo;
        TextView Orderstatus;
        public CustOrderViewHolder(@NonNull View itemView){
            super(itemView);
            OrderInfo = itemView.findViewById(R.id. OrderInfo);
            Orderstatus = itemView.findViewById(R.id.Orderstatus);

        }
    }
}