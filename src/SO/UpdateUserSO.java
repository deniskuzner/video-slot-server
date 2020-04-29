/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import Domain.User;
import Transfer.TransferObject;

/**
 *
 * @author User
 */
public class UpdateUserSO extends AbstractGenericSO {
    
    TransferObject transferObject;
    
    public boolean updateUserSO(TransferObject transferObject) {
        this.transferObject = transferObject;
        return templateExecuteSO();
    }

    @Override
    public boolean executeSO() {
        if (databaseBroker.updateRecord(transferObject.generalEntity)) {
            transferObject.message = "User update successful!";
            transferObject.signal = true;
            return true;
        }
        transferObject.message = "User update not successful!";
        transferObject.signal = false;
        return false;
    }

}
