package com.example.fileioexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Current.Current_Order;
import Current.Current_Owner;

public class OwnerOrdersList extends AppCompatActivity implements OwnerOrdersListAdapter.OnOrderListener {

    private RecyclerView recyclerView;
    OwnerOrdersListAdapter adapter;
    DatabaseReference ref;
    private List<OrderObj> orderObjList = new ArrayList<>();
    //String ownerName = Current_Owner.getOwnerUsername();
    String ownerName = "owner1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_orders_list);


        ref = FirebaseDatabase.getInstance().getReference("/stores/"+ownerName+"/orderList/");
        recyclerView = findViewById(R.id.ordersList_recycler);

        // displays the recyclerview linearly(vertical)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                orderObjList.clear();
                for (DataSnapshot dataSnapshot1 : snapshot.getChildren()) {
                    OrderObj orderObj = dataSnapshot1.getValue(OrderObj.class);
                    orderObjList.add(orderObj);
                }
                adapter = new OwnerOrdersListAdapter(OwnerOrdersList.this, orderObjList, OwnerOrdersList.this::onOrdersClick);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onOrdersClick(int position) {
        //updates the static variables so the correct order details of the correct order are opened
        Current_Order.setOrderToken(orderObjList.get(position).getOrderId());
        Current_Order.setOwner(ownerName);
        Current_Order.setCustomer(orderObjList.get(position).getCustomerUsername());

        Intent intent = new Intent(this, Order_Details.class);
        //Intent intent = new Intent(this, ListStores.class);
        startActivity(intent);

    }

}