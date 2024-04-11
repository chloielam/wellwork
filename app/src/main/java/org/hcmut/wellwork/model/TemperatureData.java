package org.hcmut.wellwork.model;

import android.media.MediaPlayer;
import android.util.Log;
import android.widget.TextView;

import org.hcmut.wellwork.view.MainActivity;

public class TemperatureData {
    ////////////////////////////////
    //                            //
    //        Constructor         //
    //                            //
    ////////////////////////////////
        //private for Single_ton Object

        private TemperatureData(){
            this.Data = 0;
            this.TemperatureView = null;
        }
    ////////////////////////////////
    //                            //
    //     Object's attribute     //
    //                            //
    ////////////////////////////////
        private int Data;
        private TextView TemperatureView;
        private MediaPlayer Temperature_Low;
        private MediaPlayer Temperature_High;

    ////////////////////////////////
    //                            //
    //           Object           //
    //                            //
    ////////////////////////////////
    private static TemperatureData Object = null;



    ////////////////////////////////
    //                            //
    //    SingleTon's methods     //
    //                            //
    ////////////////////////////////

    public static TemperatureData getInstance(){
        if(Object == null){
            Object = new TemperatureData();
        }
        return  Object;
    }

    public static int getData(){
        return getInstance().Data;
    }

    public static void setData(int NewData){
        TemperatureData Instance = getInstance();
        Instance.Data = NewData;
        if(Instance.TemperatureView != null){
            Instance.TemperatureView.setText(NewData + "°C");
        }

        if(NewData < PreferencesData.getTemperaturePreference_Low()){
            play_low();
        }
        if(NewData > PreferencesData.getTemperaturePreference_High()){
            play_high();
        }
    }


    public static void setTemperatureTextView(TextView view){
        getInstance().TemperatureView = view;
    }

    public static void setMedia_player(MediaPlayer Temp_high, MediaPlayer Temp_low){
        getInstance().Temperature_High = Temp_high;
        getInstance().Temperature_Low = Temp_low;
    }

    public static void play_low(){
        synchronized (MainActivity.lock){
            getInstance().Temperature_Low.start();
            try{
                Thread.sleep(4000);
            }
            catch (Exception e){

            }
        }

    }

    public static void play_high(){
        synchronized (MainActivity.lock){
            getInstance().Temperature_High.start();
            try{
                Thread.sleep(3000);
            }
            catch (Exception e){

            }
        }
    }



}
