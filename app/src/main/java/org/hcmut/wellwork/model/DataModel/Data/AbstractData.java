package org.hcmut.wellwork.model.DataModel.Data;

import org.hcmut.wellwork.model.Database;
import org.hcmut.wellwork.view.MainActivity;

public class AbstractData {

    ////////////////////////////////
    //      Data Identifier       //
    ////////////////////////////////
        Database.DataID dataID;

    ////////////////////////////////
    //            Data            //
    ////////////////////////////////

        private int data;


    ////////////////////////////////
    //      Get, Set method       //
    ////////////////////////////////

        public void setData(String newData) {
            this.data = (int) Float.parseFloat(newData);
            //check Data
            checkData();
        }
        public int getData(){
            return this.data;
        }


    ////////////////////////////////
    //        Check Limit         //
    ////////////////////////////////

        void checkData(){
            if(data < Database.getPreferenceData(dataID,Database.LowHigh.LOW)) playSound(true);
            else if(data > Database.getPreferenceData(dataID,Database.LowHigh.HIGH)) playSound(false);
        }

        void playSound(boolean isLow){
            Database.LowHigh lowHigh = (isLow)?Database.LowHigh.LOW:Database.LowHigh.HIGH;
            MainActivity.playSound(dataID,lowHigh);
        }

    ////////////////////////////////
    //        Constructor         //
    ////////////////////////////////
        public AbstractData(){
            this.data = 0;
        }

    //////////////////////////////////
    //Factory static method for Data//
    //////////////////////////////////

        public static AbstractData createDistanceData(){
            return new DistanceData();
        }

        public static AbstractData createHumidityData(){
            return new HumidityData();
        }

        public static AbstractData createTemperatureData(){
            return new TemperatureData();
        }
}
