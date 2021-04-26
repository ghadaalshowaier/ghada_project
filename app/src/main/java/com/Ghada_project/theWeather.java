package com.Ghada_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class theWeather extends AppCompatActivity {



ImageView WeatherImageValue;
TextView RcityName,description,temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_weather);
        RcityName = (TextView) findViewById(R.id.RcityName);
        description = (TextView) findViewById(R.id.iddescription);
temp = (TextView) findViewById(R.id.idtemp) ;

        RcityName.setText(searchWeather.mCityName);
        description.setText(searchWeather.mDescription);
        int roundedValue = (int) Math.rint(searchWeather.mTemp);

        temp.setText("Temperature :- "+roundedValue);
        int getImageName = updateWeatherIcon(searchWeather.mCondition);

    WeatherImageValue.setImageResource(getImageName);


    }

    private static int updateWeatherIcon(int condition) {

        if (condition >= 0 && condition < 300) {
            return  R.drawable.tstorm1;

        } else if (condition >= 300 && condition < 500) {
            return  R.drawable.light_rain;

        } else if (condition >= 500 && condition < 600) {
            return  R.drawable.shower3;

        } else if (condition >= 600 && condition <= 700) {
            return  R.drawable.snow;

        } else if (condition >= 701 && condition <= 771) {
            return  R.drawable.fog;

        } else if (condition >= 772 && condition < 800) {
            return  R.drawable.tstorm1;

        } else if (condition == 800) {

            return  R.drawable.sunny;

        } else if (condition >= 801 && condition <= 804) {
            return  R.drawable.cloudy;

        } else if (condition >= 900 && condition <= 902) {
            return  R.drawable.tstorm3;

        } else if (condition == 903) {
            return  R.drawable.snow5;

        } else if (condition == 904) {
            return  R.drawable.sunny;

        } else if (condition >= 905 && condition <= 1000) {
            return  R.drawable.tstorm3;

        }

        return R.drawable.none;
    }
}