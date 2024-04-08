package org.hcmut.wellwork.model;

public class PreferencesData {

    protected static PreferencesData Object = null;

    private int data;
    public PreferencesData(){
        data = 0;
    }



    public int getData(){
        return data;
    }

    public void setData(int a){
        this.data = a;
    }




}
