package org.hcmut.wellwork.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.hcmut.wellwork.model.*;
import org.hcmut.wellwork.R;
import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startMQTT();
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
    }
    public void startMQTT(){

        //HumidityData.initialize(this);
//        MQTTHelper mqttHelper = new MQTTHelper(this);
//        String temp = "50" + "°C";
//        String humid = "34" + "%";
//        String dist = "30";
//
//        // Get references to your TextViews
//        TextView temp_text = findViewById(R.id.tempval);
//        TextView humid_text = findViewById(R.id.humidval);
//        TextView dist_text = findViewById(R.id.distval);
//
//        // Set the text for each TextView
//        temp_text.setText(temp);
//        humid_text.setText(humid);
//        dist_text.setText(dist);
    }


}