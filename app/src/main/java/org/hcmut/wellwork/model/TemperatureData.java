package org.hcmut.wellwork.model;

public class TemperatureData extends PreferencesData{
    public static PreferencesData getInstance(){
        if(TemperatureData.Object == null){
            TemperatureData.Object = new TemperatureData();
        }
        return DistanceData.Object;
    }
}
