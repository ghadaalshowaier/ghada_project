package com.Ghada_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class add2FB extends AppCompatActivity {
    EditText firstName,lastName,phoneNumber,emailAddress;
    Button insertDatabt;
DatabaseReference databaseReference;

ArrayList<Integer> getAllKey = new ArrayList<Integer>();

Boolean stopGetData = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_fb);

        firstName = (EditText) findViewById(R.id.addfirstName);
        lastName = (EditText) findViewById(R.id.addlastName);
        phoneNumber = (EditText) findViewById(R.id.addPhoneNumber);
        emailAddress = (EditText) findViewById(R.id.addemailAddress);

        insertDatabt = (Button) findViewById(R.id.addTofirebt);
    }

    public void addUserToFireBase(View view) {
        String firstName_add = firstName.getText().toString().trim();
        String lastName_add = lastName.getText().toString().trim();
        String phoneNumber_add = phoneNumber.getText().toString().trim();
        String emailAddress_add = emailAddress.getText().toString().trim();



        if (!TextUtils.isEmpty(firstName_add) &&!TextUtils.isEmpty(lastName_add) &&!TextUtils.isEmpty(phoneNumber_add)&&!TextUtils.isEmpty(emailAddress_add) ) {
       databaseReference = FirebaseDatabase.getInstance().getReference("users");

            Toast.makeText(add2FB.this, "Please Wait",
                    Toast.LENGTH_LONG).show();
            insertDatabt.setEnabled(false);

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    if (stopGetData == false) {
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            user newuser = postSnapshot.getValue(user.class);

                            int getKey = Integer.valueOf(postSnapshot.getKey());
                            getAllKey.add(getKey);

                        }

                        int getMaxValue = Collections.max(getAllKey);

                        Log.i("This is MaxKey", getMaxValue + "");
                        getMaxValue++;
                        String newKeyIncremnt = String.valueOf(getMaxValue);

                        Log.i("This is newKeyIncremnt", newKeyIncremnt + "");


                        Toast.makeText(add2FB.this, "users added successfully",
                                Toast.LENGTH_LONG).show();

                        databaseReference.child(newKeyIncremnt).child("firstName").setValue(firstName_add);
                        databaseReference.child(newKeyIncremnt).child("lastName").setValue(lastName_add);
                        databaseReference.child(newKeyIncremnt).child("phoneNumber").setValue(phoneNumber_add);
                        databaseReference.child(newKeyIncremnt).child("emailAddress").setValue(emailAddress_add);
                        databaseReference.child(newKeyIncremnt).child("userId").setValue(getMaxValue+1);
                        stopGetData = true;
                        finish();
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }
        else
        {
            Toast.makeText(add2FB.this, "Please enter all data", Toast.LENGTH_LONG).show();

        }

    }
}