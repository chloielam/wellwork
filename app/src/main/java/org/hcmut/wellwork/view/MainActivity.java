package org.hcmut.wellwork.view;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import android.util.Log;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.hcmut.wellwork.model.*;
import org.hcmut.wellwork.R;


public class MainActivity extends AppCompatActivity {

    public static final Object lock = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navView = findViewById(R.id.nav_view);


        navView.setSelectedItemId(R.id.navigation_home);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();

        navView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_info:
                    // Handle other menu items if needed
                    break;
                case R.id.navigation_home:
                    // Handle other menu items if needed
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new HomeFragment())
                            .commit();
                    return true;
                case R.id.navigation_settings:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new PreferencesFragment())
                            .commit();
                    return true;
            }
            return true;
        });


        initMediaPLayer();
        startMQTT();
    }
    public void startMQTT(){

        //HumidityData.initialize(this);
        MQTTHelper mqttHelper = new MQTTHelper(this);
    }
    public void initMediaPLayer(){

        MediaPlayer Distance_low =MediaPlayer.create(this,R.raw.distance_low);

        DistanceData.setMediaPlayer(Distance_low);

        MediaPlayer Humid_low = MediaPlayer.create(this,R.raw.humid_low);

        MediaPlayer Humid_high =MediaPlayer.create(this,R.raw.humid_high);

        HumidityData.setHumidSound(Humid_low,Humid_high);


        MediaPlayer Temperature_low = MediaPlayer.create(this,R.raw.temperature_low);
        MediaPlayer Temperature_high = MediaPlayer.create(this,R.raw.temperature_high);

        TemperatureData.setMedia_player(Temperature_high,Temperature_low);


    }

}