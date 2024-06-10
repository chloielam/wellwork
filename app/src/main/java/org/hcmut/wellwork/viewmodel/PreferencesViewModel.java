package org.hcmut.wellwork.viewmodel;

import java.sql.DatabaseMetaData;



import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.hcmut.wellwork.model.Database;


public class PreferencesViewModel extends ViewModel {
    MutableLiveData<Integer> humidLow;
    MutableLiveData<Integer> humidHigh;
    MutableLiveData<Integer> distanceLow;


    public PreferencesViewModel(){
        super();
        humidHigh = new MutableLiveData<>(0);
        humidLow = new MutableLiveData<>(0);
        distanceLow = new MutableLiveData<>(0);
    }

    public MutableLiveData<Integer> getHumidHigh() {
        if(humidHigh == null) Log.w("bindingcac","null");
        return humidHigh;
    }

    public MutableLiveData<Integer> getHumidLow(){
        return humidLow;
    }

    public MutableLiveData<Integer> getDistanceLow(){
        return distanceLow;
    }

    public void setHumidLow(Integer newData){
        humidLow.setValue(newData);
    }
    public void setHumidHigh(Integer newData){
        humidHigh.setValue(newData);
    }


    public void onAttach(){
        this.humidHigh.postValue(Database.getPreferenceData(Database.DataID.Humidity, Database.LowHigh.HIGH));
        this.humidLow.postValue(Database.getPreferenceData(Database.DataID.Humidity, Database.LowHigh.LOW));
        this.distanceLow.postValue(Database.getPreferenceData(Database.DataID.Distance, Database.LowHigh.LOW));

    }

    public void setPreferencesButton(){
        try{
            if(humidHigh.getValue() > humidLow.getValue()){
                Database.setPreferenceData(Database.DataID.Humidity, Database.LowHigh.LOW,humidLow.getValue());
                Database.setPreferenceData(Database.DataID.Humidity, Database.LowHigh.HIGH ,humidHigh.getValue());
                Database.setPreferenceData(Database.DataID.Distance, Database.LowHigh.LOW,distanceLow.getValue());
            }
        }
        catch (Exception e){
            return;
        }

    }
}
