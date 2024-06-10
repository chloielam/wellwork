package org.hcmut.wellwork.viewmodel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.hcmut.wellwork.model.Database;
import org.hcmut.wellwork.view.DatabaseListener;


public class MainViewModel extends ViewModel implements DatabaseListener {
    public MutableLiveData<Integer> distanceData,humidityData,temperatureData;

    public MainViewModel(){
        super();
        distanceData = new MutableLiveData<>(0);
        humidityData = new MutableLiveData<>(0);
        temperatureData = new MutableLiveData<>(0);
        initData();
    }

    public MutableLiveData<Integer> getDistanceData(){
        return distanceData;
    }
    public MutableLiveData<Integer> getTemperatureData(){
        return temperatureData;
    }
    public MutableLiveData<Integer> getHumidityData(){
        return  humidityData;
    }

    public void onChangedData(Database.DataID dataID, int newData){
        switch (dataID){
            case Distance:
                distanceData.postValue(newData);
                break;
            case Humidity:
                humidityData.postValue(newData);
                break;
            case Temperature:
                temperatureData.postValue(newData);
                break;
        }


    }

    public void initData(){
        this.humidityData.postValue(Database.getData(Database.DataID.Humidity));
        this.temperatureData.postValue(Database.getData(Database.DataID.Temperature));
        this.distanceData.postValue(Database.getData(Database.DataID.Distance));
    }


}
