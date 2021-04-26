package com.Ghada_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class sql extends AppCompatActivity {

    DatabaseReference databaseReference;
    fuser favoriteUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        favoriteUser = new fuser(this);

    }

    public void gofetchSusersqlite(View view)
    {
        Intent intent = new Intent(sql.this,fetchFromSQL.class);
        startActivity(intent);
    }

    public void getAllUsersqlite(View view)
    {
        Intent intent = new Intent(sql.this,viewfuser.class);
        startActivity(intent);

    }


    public void addValuesFromFireTosqlaction(View view) {


        view.setEnabled(false);

        getDataFromFireBaseAndInserttoSqlite();
        Toast.makeText(getBaseContext(), "Please wait", Toast.LENGTH_SHORT).show();

    }

    public void getDataFromFireBaseAndInserttoSqlite()
    {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    user newuser = postSnapshot.getValue(user.class);
                    favoriteUser.addFavoriteUser((new fuser(newuser.getFirstName(),newuser.getLastName(),newuser.getPhoneNumber(),newuser.getEmailAddress(),sql.this)));


                }


                Toast.makeText(getBaseContext(), "all users added to Sqlite successfully", Toast.LENGTH_SHORT).show();






            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}