package org.hcmut.wellwork.model.DataModel.PreferenceData;

import org.hcmut.wellwork.model.Database.LowHigh;
import static org.hcmut.wellwork.model.Database.LowHigh.HIGH;
import static org.hcmut.wellwork.model.Database.LowHigh.LOW;
class PreferenceDataHolder {


    ////////////////////////////////////////
    //    PreferenceData: Low and High    //
    ////////////////////////////////////////

    private final int[] preferenceDatas = new int[2];


    ////////////////////////////////////////
    //              Get, Set              //
    ////////////////////////////////////////

    public int getDataPreference(LowHigh a) {
        return this.preferenceDatas[a.ordinal()];
    }

    public void setDataPreference(LowHigh b, int newDataPreference) {
        this.preferenceDatas[b.ordinal()] = newDataPreference;
    }

    public PreferenceDataHolder(int preferenceDataLow, int preferenceDataHigh) {
        preferenceDatas[LOW.ordinal()] = preferenceDataLow;
        preferenceDatas[HIGH.ordinal()] = preferenceDataHigh;
    }
}
