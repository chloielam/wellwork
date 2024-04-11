package org.hcmut.wellwork.model;

public class PreferencesData {

    ////////////////////////////////
    //                            //
    //        Constructor         //
    //                            //
    ////////////////////////////////
        //private for Single_ton Object

        private PreferencesData(){
            this.DistancePreference = 50;

            this.HumidPreference_Low = 30;
            this.HumidPreference_High = 60;

            this.TemperaturePreference_Low = 20;
            this.TemperaturePreference_High = 30;
        }
    ////////////////////////////////
    //                            //
    //     Object's attribute     //
    //                            //
    ////////////////////////////////

        private int DistancePreference;
        private int HumidPreference_Low;
        private  int HumidPreference_High;
        private  int TemperaturePreference_Low;
        private  int TemperaturePreference_High;

    ////////////////////////////////
    //                            //
    //           Object           //
    //                            //
    ////////////////////////////////

        private static PreferencesData Object;

    ////////////////////////////////
    //                            //
    //    SingleTon's methods     //
    //                            //
    ////////////////////////////////

        public static PreferencesData getInstance(){
            if(Object == null){
                Object = new PreferencesData();
            }
            return Object;
        }

        public static int getDistancePreference(){
            return getInstance().DistancePreference;
        }

        public static void setDistancePreference(int NewDistancePreference){
            getInstance().DistancePreference = NewDistancePreference;
        }

        public static int  getHumidPreference_Low(){
            return getInstance().HumidPreference_Low;
        }

        public static void setHumidPreference_Low(int NewHumidPreference_Low){
            getInstance().HumidPreference_Low = NewHumidPreference_Low;
        }

        public static int getHumidPreference_High(){
            return getInstance().HumidPreference_High;
        }


        public static void setHumidPreference_High(int NewHumidPreference_High){
            getInstance().HumidPreference_High = NewHumidPreference_High;
        }


        public static int getTemperaturePreference_Low(){
            return getInstance().TemperaturePreference_Low;
        }

        public static void setTemperaturePreference_Low(int NewTemperaturePreference_Low){
            getInstance().TemperaturePreference_Low = NewTemperaturePreference_Low;
        }

        public static int getTemperaturePreference_High(){
            return getInstance().TemperaturePreference_High;
        }
        public static void setTemperaturePreference_High(int NewTemperaturePreference_High){
            getInstance().TemperaturePreference_High = NewTemperaturePreference_High;
        }




}
