package org.hcmut.wellwork.model;
import org.hcmut.wellwork.model.DataModel.Data.AbstractData;
import org.hcmut.wellwork.model.DataModel.PreferenceData.PreferencesData;
import org.hcmut.wellwork.view.DatabaseListener;

public class Database {

    ////////////////////////////////
    //                            //
    //        Enumerations        //
    //                            //
    ////////////////////////////////
        public enum LowHigh{
            LOW,HIGH
        }
        public enum DataID{
            Distance,Humidity,Temperature;
        }


    ////////////////////////////////
    //                            //
    //           Datas            //
    //                            //
    ////////////////////////////////
        final AbstractData[] dataHolder = new AbstractData[3];

        PreferencesData preferencesData;

    ////////////////////////////////
    //                            //
    //          Get, Set          //
    //                            //
    ////////////////////////////////
        public static int getData (DataID dataID){

            if(getInstance() == null) return 0;

            return getInstance().dataHolder[dataID.ordinal()].getData();
        }

        public static void setData(DataID dataID,String newData){
            if(getInstance() == null) return;
            getInstance().dataHolder[dataID.ordinal()].setData(newData);

            if(getInstance().listener!=null){
                getInstance().listener.onChangedData(dataID,(int) Float.parseFloat(newData));
            }
        }

        public static int getPreferenceData(DataID dataID, LowHigh lowHigh){
            return getInstance().preferencesData.getDataPreference(dataID,lowHigh);
        }

        public static void setPreferenceData(DataID dataID, LowHigh lowHigh, int newDataPreference){
            if(getInstance() == null) return;
            getInstance().preferencesData.setDataPreference(dataID,lowHigh,newDataPreference);
        }


    ////////////////////////////////
    //                            //
    //        Constructor         //
    //                            //
    ////////////////////////////////
        Database(){
            this.dataHolder[DataID.Distance.ordinal()] = AbstractData.createDistanceData();
            this.dataHolder[DataID.Humidity.ordinal()] = AbstractData.createHumidityData();
            this.dataHolder[DataID.Temperature.ordinal()] = AbstractData.createTemperatureData();
            this.preferencesData = new PreferencesData();
        }


    ////////////////////////////////
    //                            //
    //         SingleTon          //
    //                            //
    ////////////////////////////////
        private static Database instance;
        private static Database getInstance(){
            if(instance == null){
                instance = new Database();
            }
            return instance;
        }

    ////////////////////////////////
    //                            //
    //          Listener          //
    //                            //
    ////////////////////////////////

        DatabaseListener listener;

        public static void setListener(DatabaseListener listener){
            getInstance().listener =listener;
        }
        public static void eraseListener(){
            getInstance().listener = null;
        }
}
