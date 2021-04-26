package com.Ghada_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        Button bttn1 = (Button) findViewById(R.id.fireBaseApp);
        Button bttn2 = (Button) findViewById(R.id.SQLLiteApp);
        Button bttn3 = (Button) findViewById(R.id.WwatherApp);

        bttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(startPage.this, fb.class));
            }
        });

        bttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(startPage.this, sql.class));
            }
        });

        bttn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(startPage.this, searchWeather.class));
            }
        });
    }
}
