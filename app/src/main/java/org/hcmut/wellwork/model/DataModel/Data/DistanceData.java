package org.hcmut.wellwork.model.DataModel.Data;


import org.hcmut.wellwork.model.Database;

class DistanceData extends AbstractData {
    public DistanceData(){
        super();
        this.dataID = Database.DataID.Distance;
    }
}