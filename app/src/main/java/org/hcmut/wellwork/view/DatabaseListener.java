package org.hcmut.wellwork.view;

import org.hcmut.wellwork.model.Database;

public interface DatabaseListener {
    public void onChangedData(Database.DataID dataID, int newData);
}
