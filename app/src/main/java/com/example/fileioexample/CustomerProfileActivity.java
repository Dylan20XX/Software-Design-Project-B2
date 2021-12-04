package com.example.fileioexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fileioexample.account.CustomerAccount;
import com.example.fileioexample.login.LoginModel;
import com.example.fileioexample.utils.CurrentUser;
import com.example.fileioexample.utils.DatabaseUtils;
import com.example.fileioexample.utils.Popup;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import java.util.HashMap;

public class CustomerProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);

        setupCustomerProfileText();
    }

    //Set the text fields of the profile screen
    private void setupCustomerProfileText(){
        TextView usernameText = (TextView) findViewById(R.id.customerProfile_username);
        usernameText.setText(CurrentUser.username);
        TextView firstNameText = (TextView) findViewById(R.id.customerProfile_firstName);
        if(CurrentUser.customer.getFirstName() != null)
            firstNameText.setText(CurrentUser.customer.getFirstName());
        else
            firstNameText.setText("");
        TextView lastNameText = (TextView) findViewById(R.id.customerProfile_lastName);
        if(CurrentUser.customer.getLastName() != null)
            lastNameText.setText(CurrentUser.customer.getLastName());
        else
            lastNameText.setText("");
        TextView emailText = (TextView) findViewById(R.id.customerProfile_email);
        if(CurrentUser.customer.getEmail() != null)
            emailText.setText(CurrentUser.customer.getEmail());
        else
            emailText.setText("");
    }

    private void profileUpdated(){
        Popup.createNewAlertPopup("Profile Updated", this);
    }

    public void editCustomerProfile(View view){
        //Start the create owner account view
        Intent intent = new Intent(this, CustomerEditProfileActivity.class);
        startActivityForResult(intent, 0);
    }

    // Call Back method to get the Message from other Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        //Use request code to determine the outcome of the child
        //Result code of 1 indicates that an account was successfully created
        if(requestCode==0) {
            if(resultCode == 1){
                setupCustomerProfileText();
                profileUpdated();
            }
        }
    }

}