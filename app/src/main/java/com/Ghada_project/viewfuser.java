package com.Ghada_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class viewfuser extends AppCompatActivity {

    ListView userlist;
    int[] userId;
    String[] firstName;
    String[] lastName;
    String[] phoneNumber;
    String[] emailAddress;
    public static int SQLUserposition;
    public static int SQLuserid;
    public static String SQLfirstName;
    public static String SQLlastName;
    public static String SQLphoneNumber;
    public static String SQLemailAdress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfuser);

        userlist = (ListView) findViewById(R.id.userFavoriteid);

        fuser U=new fuser(this);
// 1
        ArrayList<fuser> favoriteUserslist = U.getAllfavoriteUsers(this);
        userId = new int[favoriteUserslist.size()];
        firstName = new String[favoriteUserslist.size()];
        lastName = new String[favoriteUserslist.size()];
        phoneNumber = new String[favoriteUserslist.size()];
        emailAddress = new String[favoriteUserslist.size()];


// 3
        for(int i = 0; i < favoriteUserslist.size(); i++){
            fuser U1 = favoriteUserslist.get(i);


            userId[i] =  U1.getId();
            firstName[i] = U1.getFirstName();
            lastName[i] = U1.getLastName();
            phoneNumber[i] = U1.getPhoneNumber();
            emailAddress[i] = U1.getEmailAddress();



        }

        customAdabterActivity theCustomAdabter = new customAdabterActivity();
        userlist.setAdapter(theCustomAdabter);



        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                SQLUserposition = position;
                SQLuserid = userId[position];

                SQLfirstName = firstName[position];

                SQLlastName =  lastName[position];


                SQLphoneNumber = phoneNumber[position];

                SQLemailAdress = emailAddress[position];
                Log.i("SQLITEuserId",SQLuserid+"");


                finish();
                Intent goEdit = new Intent(viewfuser.this,edit.class);
                startActivity(goEdit);
            }
        });


    }



    class customAdabterActivity extends BaseAdapter {

        @Override
        public int getCount() {
            return firstName.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public customAdabterActivity() {
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.activity_user, null);
            TextView firstNametext = (TextView) view.findViewById(R.id.firstName);
            TextView lastNametext = (TextView) view.findViewById(R.id.lastName);
            TextView phoneNumbertext = (TextView) view.findViewById(R.id.phoneNumber);
            TextView emailAddressText = (TextView) view.findViewById(R.id.emailAddress);


            firstNametext.setText("First Name: "+firstName[position]);
            lastNametext.setText("Last Name: "+lastName[position]);
            phoneNumbertext.setText("Phone Number: "+phoneNumber[position]);
            emailAddressText.setText("Email Address: "+emailAddress[position]);



            return view;
        }
    }


}