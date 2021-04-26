package com.Ghada_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class fb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);
    }

    public void goInserUser(View view) {
        Intent intent = new Intent(fb.this, add2FB.class);
        startActivity(intent);

    }

    public void getAllUser(View view) {
        Intent intent = new Intent(fb.this,MainActivity.class);
        startActivity(intent);
    }


    public void gofetchSuser(View view) {
        Intent intent = new Intent(fb.this, fetchFromFB.class);
        startActivity(intent);


    }
}