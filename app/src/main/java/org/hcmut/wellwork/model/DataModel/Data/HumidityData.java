package org.hcmut.wellwork.model.DataModel.Data;

import org.hcmut.wellwork.model.Database;

class HumidityData extends AbstractData{
    public HumidityData(){
        super();
        this.dataID = Database.DataID.Humidity;
    }
}


