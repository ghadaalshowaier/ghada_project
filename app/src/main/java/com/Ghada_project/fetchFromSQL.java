package com.Ghada_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class fetchFromSQL extends AppCompatActivity {

    LinearLayout linerallValue;
    TextView fristname,lastname,phoneNumber,emailaddress;
    EditText useridText;
    Button getFeatchbt;

    int[] FuserId;
    String[] FfirstName;
    String[] FlastName;
    String[] FphoneNumber;
    String[] FemailAddress;

    public static int FSQLuserid;
    public static String FSQLfirstName;
    public static String FSQLlastName;
    public static String FSQLphoneNumber;
    public static String FSQLemailAdress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_from_sql);

        linerallValue = (LinearLayout) findViewById(R.id.SQallValues);

        linerallValue.setVisibility(View.INVISIBLE);

        useridText = (EditText) findViewById(R.id.SQuseridSearch);
        getFeatchbt = (Button) findViewById(R.id.SQFeatchbt);
        fristname = (TextView) findViewById(R.id.SQffirstname);
        lastname = (TextView) findViewById(R.id.SQflastname);
        phoneNumber = (TextView) findViewById(R.id.SQfphonenumber);
        emailaddress = (TextView) findViewById(R.id.SQfemail);
    }
    public void SQgetuserActionSqlite(View view)
    {
        String userid = useridText.getText().toString().trim();

        if (!TextUtils.isEmpty(userid)) {




            fuser U=new fuser(this);
// 1
            // Construct the data source
            ArrayList<fuser> favoriteUserslist = U.getAllfavoriteUsers(this);
            FuserId = new int[favoriteUserslist.size()];
            FfirstName = new String[favoriteUserslist.size()];
            FlastName = new String[favoriteUserslist.size()];
            FphoneNumber = new String[favoriteUserslist.size()];
            FemailAddress = new String[favoriteUserslist.size()];


// 3
            for(int i = 0; i < favoriteUserslist.size(); i++){
                fuser U1 = favoriteUserslist.get(i);


                FSQLuserid =  U1.getId();
                String covertIdToString = String.valueOf(FSQLuserid);
                if (covertIdToString.equals(userid)) {

                    FSQLfirstName = U1.getFirstName();
                    FSQLlastName = U1.getLastName();
                    FSQLphoneNumber = U1.getPhoneNumber();
                    FSQLemailAdress = U1.getEmailAddress();
                    break;
                }


            }


            linerallValue.setVisibility(View.VISIBLE);

            fristname.setText("First name: "+FSQLfirstName);
            lastname.setText("Last name: "+FSQLlastName);
            phoneNumber.setText("Phone Number: "+FSQLphoneNumber);
            emailaddress.setText("Email Address: "+FSQLemailAdress);

        }
        else
        {


        }


    }


}