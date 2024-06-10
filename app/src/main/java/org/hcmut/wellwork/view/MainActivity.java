package org.hcmut.wellwork.view;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;




import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.hcmut.wellwork.model.*;
import org.hcmut.wellwork.R;


class MediaHolder{
    MediaPlayer[][] soundArray = new MediaPlayer[3][2];

    MediaHolder(Context context ){
        //distance data
        soundArray[0][0] = MediaPlayer.create(context, R.raw.distance_low);
        //humidity
        soundArray[1][0] = MediaPlayer.create(context, R.raw.humid_low);

        soundArray[1][1] = MediaPlayer.create(context, R.raw.humid_high);

        //temperature
        soundArray[2][0] = MediaPlayer.create(context, R.raw.temperature_low);
        soundArray[2][1]= MediaPlayer.create(context, R.raw.temperature_high);

    }

    public synchronized void  playSound(Database.DataID dataID, Database.LowHigh lowHigh){
        soundArray[dataID.ordinal()][lowHigh.ordinal()].start();
    }

}

public class MainActivity extends AppCompatActivity {

    static MQTTHelper mqttHelper;

    static MediaHolder mediaHolder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mediaHolder = new MediaHolder(this);


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


        startMQTT();

    }
    public void startMQTT(){

        //HumidityData.initialize(this);
        MainActivity.mqttHelper = new MQTTHelper(this);
    }


    public static void playSound(Database.DataID dataID, Database.LowHigh lowHigh){
        mediaHolder.playSound(dataID,lowHigh);
    }

}