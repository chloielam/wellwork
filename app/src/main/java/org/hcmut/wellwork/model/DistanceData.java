package org.hcmut.wellwork.model;

import android.content.Context;
import android.util.Log;


public class DistanceData  extends  PreferencesData{

    public static PreferencesData getInstance(){
        if(DistanceData.Object == null){
            DistanceData.Object = new DistanceData();
        }
        return DistanceData.Object;
    }

}
