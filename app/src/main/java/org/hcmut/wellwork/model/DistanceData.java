package org.hcmut.wellwork.model;


import android.media.MediaPlayer;
import android.util.Log;
import android.widget.TextView;

import org.hcmut.wellwork.view.MainActivity;


public class DistanceData {

    ////////////////////////////////
    //                            //
    //        Constructor         //
    //                            //
    ////////////////////////////////
        //private for Single_ton Object
        private DistanceData(){
            this.Data = 0;
            this.DistanceView = null;
        }



    ////////////////////////////////
    //                            //
    //     Object's attribute     //
    //                            //
    ////////////////////////////////

        private int Data;
        private TextView DistanceView;
        private MediaPlayer player;

    ////////////////////////////////
    //                            //
    //           Object           //
    //                            //
    ////////////////////////////////
    private static DistanceData Object = null;



    ////////////////////////////////
    //                            //
    //    SingleTon's methods     //
    //                            //
    ////////////////////////////////

        public static DistanceData getInstance(){
            if(Object == null){
                Object = new DistanceData();
            }
            return  Object;
        }

        public static int getData(){
            return getInstance().Data;
        }


        public static void setData(int NewData){
            DistanceData Instance = getInstance();
            getInstance().Data = NewData;
            if(Instance.DistanceView != null){
                Instance.DistanceView.setText(Integer.toString(NewData));
            }

            if(NewData < PreferencesData.getDistancePreference()){
                DistanceData.DistanceLowSound();
            }
        }


        //for view changing
        public static void setDistanceTextView(TextView view){
            getInstance().DistanceView = view;
        }

        public static void setMediaPlayer(MediaPlayer player){
            getInstance().player = player;
        }

        public static void DistanceLowSound(){
            synchronized (MainActivity.lock){
                getInstance().player.start();
                try{
                    Thread.sleep(5000);
                }
                catch (Exception e){

                }
            }
        }
}
