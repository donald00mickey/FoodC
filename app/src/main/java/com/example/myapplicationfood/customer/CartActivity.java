package com.example.myapplicationfood.customer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplicationfood.R;
import com.example.myapplicationfood.adapters.CartAdapter;
import com.example.myapplicationfood.adapters.MenuItemListAdapter;
import com.example.myapplicationfood.customer.ProceedToCheckoutActivity;
import com.example.myapplicationfood.dao.CartModelDao;
import com.example.myapplicationfood.dao.RestaurantDishesDao;
import com.example.myapplicationfood.models.CartModel;
import com.example.myapplicationfood.models.MenuItemModel;
import com.example.myapplicationfood.models.RestaurantDishes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.shreyaspatil.EasyUpiPayment.EasyUpiPayment;
import com.shreyaspatil.EasyUpiPayment.listener.PaymentStatusListener;
import com.shreyaspatil.EasyUpiPayment.model.TransactionDetails;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CartActivity extends AppCompatActivity implements PaymentStatusListener {
    Button protocheck;
    RecyclerView recyclerView;
    TextView total_amount;
    int pure_total = 0;
    ArrayList<RestaurantDishes> cartDishesArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        protocheck = findViewById(R.id.protocheck);
        total_amount = findViewById(R.id.total_amount);
        recyclerView = findViewById(R.id.recyclerView3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        cartDishesArrayList = (ArrayList<RestaurantDishes>) intent.getSerializableExtra("cart_list");
        recyclerView.setAdapter(new CartAdapter(this, cartDishesArrayList));

        Toast.makeText(this, ""+cartDishesArrayList.size(), Toast.LENGTH_SHORT).show();
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss", Locale.getDefault());
        String transcId = df.format(c);

        for (RestaurantDishes restaurantDishes : cartDishesArrayList) {
            int count = Integer.parseInt(restaurantDishes.getCount());
            int price = Integer.parseInt(restaurantDishes.getPrice());
            int total = count * price;
            pure_total = pure_total + total;
        }
        total_amount.setText("Total : " + pure_total);

        protocheck.setOnClickListener(view -> {
            String amount = String.valueOf(Float.valueOf(pure_total));
            String upi = "apkajepiyush-1@okicici";
            String name = "Piyush Apkaje";
            String desc = "Restaurent bill payment";
            // on below line we are validating our text field.
                makePayment(amount, upi, name, desc, transcId);
        });


    }

    private void makePayment(String amount, String upi, String name, String desc, String transactionId) {
        // on below line we are calling an easy payment method and passing
        // all parameters to it such as upi id,name, description and others.
        final EasyUpiPayment easyUpiPayment = new EasyUpiPayment.Builder()
                .with(this)
                // on below line we are adding upi id.
                .setPayeeVpa(upi)
                // on below line we are setting name to which we are making payment.
                .setPayeeName(name)
                // on below line we are passing transaction id.
                .setTransactionId(transactionId)
                // on below line we are passing transaction ref id.
                .setTransactionRefId(transactionId)
                // on below line we are adding description to payment.
                .setDescription(desc)
                // on below line we are passing amount which is being paid.
                .setAmount(amount)
                // on below line we are calling a build method to build this ui.
                .build();
        // on below line we are calling a start
        // payment method to start a payment.
        easyUpiPayment.startPayment();
        // on below line we are calling a set payment
        // status listener method to call other payment methods.
        easyUpiPayment.setPaymentStatusListener(this);
    }

    @Override
    public void onTransactionCompleted(TransactionDetails transactionDetails) {
        // on below line we are getting details about transaction when completed.
        String transcDetails = transactionDetails.getStatus().toString() + "\n" + "Transaction ID : " + transactionDetails.getTransactionId();
//        transactionDetailsTV.setVisibility(View.VISIBLE);
//        // on below line we are setting details to our text view.
//        transactionDetailsTV.setText(transcDetails);
    }

    @Override
    public void onTransactionSuccess() {
        // this method is called when transaction is successful and we are displaying a toast message.
        Toast.makeText(this, "Transaction successfully completed..", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTransactionSubmitted() {
        // this method is called when transaction is done
        // but it may be successful or failure.
        Log.e("TAG", "TRANSACTION SUBMIT");
    }

    @Override
    public void onTransactionFailed() {
        // this method is called when transaction is failure.
        Toast.makeText(this, "Failed to complete transaction", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTransactionCancelled() {
        // this method is called when transaction is cancelled.
        Toast.makeText(this, "Transaction cancelled..", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAppNotFound() {
        // this method is called when the users device is not having any app installed for making payment.
        Toast.makeText(this, "No app found for making transaction..", Toast.LENGTH_SHORT).show();
    }
}