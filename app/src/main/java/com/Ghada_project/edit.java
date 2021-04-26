package com.Ghada_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class edit extends AppCompatActivity {



    Button editbt,deletbt;
    EditText firstName,lastName,phoneNumber,emailAddress;

    fuser f;

    List<fuser> listuser ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        f = new fuser(this);


        listuser = f.getAllfavoriteUsers(edit.this);


        editbt = (Button) findViewById(R.id.editButton);
        deletbt = (Button) findViewById(R.id.deletButton);

        firstName = (EditText) findViewById(R.id.editfirstName);
        lastName = (EditText) findViewById(R.id.editlastName);
        phoneNumber = (EditText) findViewById(R.id.editPhoneNumber);
        emailAddress = (EditText) findViewById(R.id.editemailAddress);

        firstName.setText(viewfuser.SQLfirstName);
        lastName.setText(viewfuser.SQLlastName);
        phoneNumber.setText(viewfuser.SQLphoneNumber);
        emailAddress.setText(viewfuser.SQLemailAdress);


        editbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "user updated successfully in SQLite", Toast.LENGTH_SHORT).show();
                f.updateUser((new fuser(firstName.getText().toString(),lastName.getText().toString(),phoneNumber.getText().toString(),emailAddress.getText().toString(),edit.this)),viewfuser.SQLuserid);

                finish();

            }
        });

        deletbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getBaseContext(), "user deleted successfully in SQLite", Toast.LENGTH_SHORT).show();


                // delete one book
                f.deleteBook(listuser.get(viewfuser.SQLUserposition));
                finish();
            }
        });

    }


}