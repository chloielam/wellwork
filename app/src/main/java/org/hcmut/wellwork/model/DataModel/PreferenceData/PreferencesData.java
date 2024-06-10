package org.hcmut.wellwork.model.DataModel.PreferenceData;



import static org.hcmut.wellwork.model.Database.LowHigh;
import org.hcmut.wellwork.model.Database.DataID;


public class PreferencesData {

    //////////////////////////////
    //     Preference Datas     //
    //////////////////////////////

        private final PreferenceDataHolder[] preferenceDatas = new PreferenceDataHolder[3];

    //////////////////////////////
    //         Get, Set         //
    //////////////////////////////

        public int getDataPreference(DataID a, LowHigh b){
            return preferenceDatas[a.ordinal()].getDataPreference(b);
        }

        public void setDataPreference(DataID a, LowHigh b, int newDataPreference){
            preferenceDatas[a.ordinal()].setDataPreference(b,newDataPreference);
        }
    ////////////////////////////////
    //        Constructor         //
    ////////////////////////////////

        public PreferencesData(){
            //distance
            this.preferenceDatas[DataID.Distance.ordinal()] = new PreferenceDataHolder(0,200);
            //humid
            this.preferenceDatas[DataID.Humidity.ordinal()] = new PreferenceDataHolder(0,100);
            //temperature
            this.preferenceDatas[DataID.Temperature.ordinal()] = new PreferenceDataHolder(16,32);
        }

}
