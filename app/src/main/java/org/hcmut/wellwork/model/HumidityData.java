package org.hcmut.wellwork.model;

import android.content.Context;
import android.util.Log;

public class HumidityData  extends  PreferencesData{
    public static PreferencesData getInstance(){
        if(HumidityData.Object == null){
            HumidityData.Object = new HumidityData();
        }
        return DistanceData.Object;
    }

}
