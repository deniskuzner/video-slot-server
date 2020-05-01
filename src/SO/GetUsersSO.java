/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import Domain.GeneralEntity;
import Domain.User;
import Transfer.TransferObject;
import java.util.List;

/**
 *
 * @author User
 */
public class GetUsersSO extends AbstractGenericSO {

    TransferObject transferObject;

    public boolean getUsersSO(TransferObject transferObject) {
        this.transferObject = transferObject;
        return templateExecuteSO();
    }

    @Override
    public boolean executeSO() {
        List<GeneralEntity> result = databaseBroker.findRecord(new User(), "");
        transferObject.list = result;
        return true;
    }

}
