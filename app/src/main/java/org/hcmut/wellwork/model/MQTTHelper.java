package org.hcmut.wellwork.model;

import android.content.Context;

import android.util.Log;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MQTTHelper {
    public MqttAndroidClient mqttAndroidClient;


    ////////////////////////////////
    //                            //
    //     Connection detail      //
    //                            //
    ////////////////////////////////

        //list of feeds
        public final String[] arrayTopics = {"nhoxtin15/feeds/distance","nhoxtin15/feeds/humidity","nhoxtin15/feeds/temperature"};
        //Client Id
            //This can be any thing
        final String clientId = "123756";
        final String username = "nhoxtin15";
        final String password ="";
        final String serverUri = "tcp://io.adafruit.com:1883";

    public MQTTHelper(Context context){
        mqttAndroidClient = new MqttAndroidClient(context, serverUri, clientId);
        mqttAndroidClient.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean b, String s) {
                Log.w("mqtt", s);
            }

            @Override
            public void connectionLost(Throwable throwable) {
                Log.w("mqtt","cac");
            }

            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
                ////////////////////////////////
                //                            //
                //   When received message    //
                //                            //
                ////////////////////////////////


                Log.w("mqtt",mqttMessage.toString());
                if(topic.contains("distance")){
                    //set distance
                    Database.setData(Database.DataID.Distance,mqttMessage.toString());
                }
                else if (topic.contains("humidity")) {
                    //set humidity
                    Database.setData(Database.DataID.Humidity,mqttMessage.toString());
                }
                else if(topic.contains("temperature")) {
                    //set temerature
                    Database.setData(Database.DataID.Temperature,mqttMessage.toString());
                }
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

            }
        });
        connect();
    }

    public void setCallback(MqttCallbackExtended callback) {
        mqttAndroidClient.setCallback(callback);
    }

    private void connect(){
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setAutomaticReconnect(true);
        mqttConnectOptions.setCleanSession(false);
        mqttConnectOptions.setUserName(username);
        mqttConnectOptions.setPassword(password.toCharArray());

        try {

            mqttAndroidClient.connect(mqttConnectOptions, null, new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {

                    DisconnectedBufferOptions disconnectedBufferOptions = new DisconnectedBufferOptions();
                    disconnectedBufferOptions.setBufferEnabled(true);
                    disconnectedBufferOptions.setBufferSize(100);
                    disconnectedBufferOptions.setPersistBuffer(false);
                    disconnectedBufferOptions.setDeleteOldestMessages(false);
                    mqttAndroidClient.setBufferOpts(disconnectedBufferOptions);
                    subscribeToTopic();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.w("Mqtt", "Failed to connect to: " + serverUri + exception.toString());
                }
            });


        } catch (MqttException ex){
            ex.printStackTrace();
        }
    }

    private void subscribeToTopic() {
        for(int i = 0; i < arrayTopics.length; i++) {
            try {
                mqttAndroidClient.subscribe(arrayTopics[i], 0, null, new IMqttActionListener() {
                    @Override
                    public void onSuccess(IMqttToken asyncActionToken) {
                        Log.d("TEST", "Subscribed!");
                    }

                    @Override
                    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                        Log.d("TEST",exception.toString());
                        Log.d("TEST", "Subscribed fail!");
                    }
                });


            } catch (MqttException ex) {
                System.out.println("Exceptionst subscribing");
                ex.printStackTrace();
            }
        }
    }

}