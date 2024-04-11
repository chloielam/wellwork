package org.hcmut.wellwork.model;


import android.media.MediaPlayer;
import android.util.Log;
import android.widget.TextView;

import org.hcmut.wellwork.view.MainActivity;

public class HumidityData {
    ////////////////////////////////
    //                            //
    //        Constructor         //
    //                            //
    ////////////////////////////////
        //private for Single_ton Object
    private HumidityData(){
        this.Data = 16;
        this.HumidView = null;
    }


    ////////////////////////////////
    //                            //
    //     Object's attribute     //
    //                            //
    ////////////////////////////////

    private int Data;
    private TextView HumidView;
    private MediaPlayer HumidLowSound;
    private MediaPlayer HumidHighSound;


    ////////////////////////////////
    //                            //
    //           Object           //
    //                            //
    ////////////////////////////////
        private static HumidityData Object = null;


    ////////////////////////////////
    //                            //
    //    SingleTon's methods     //
    //                            //
    ////////////////////////////////

        public static HumidityData getInstance(){
            if(Object == null){
                Object = new HumidityData();
            }
            return Object;
        }


        public static int getData(){
            return getInstance().Data;
        }

        public static void setData(int NewData){
            HumidityData Instance = getInstance();
            Instance.Data = NewData;
            if(Instance.HumidView != null){
                Instance.HumidView.setText(NewData +"%");
            }

            if(NewData < PreferencesData.getHumidPreference_Low()) play_low();
            if(NewData > PreferencesData.getHumidPreference_High()) play_high();
        }

        public static void setHumidTextView(TextView view){
            getInstance().HumidView = view;
        }

        public static void setHumidSound(MediaPlayer low, MediaPlayer high){
            getInstance().HumidLowSound = low;
            getInstance().HumidHighSound = high;
        }

        public static void play_low(){
            synchronized (MainActivity.lock){
                getInstance().HumidLowSound.start();
                try{
                    Thread.sleep(2000);
                }
                catch (Exception e){

                }
            }
        }
        public static void play_high(){
            synchronized (MainActivity.lock){
                getInstance().HumidHighSound.start();
                try{
                    Thread.sleep(2000);
                }
                catch (Exception e){

                }
            }
        }
}
