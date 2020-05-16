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
public class DeleteUserSO extends AbstractGenericSO {

    TransferObject transferObject;

    public boolean deleteUserSO(TransferObject transferObject) {
        this.transferObject = transferObject;
        return templateExecuteSO();
    }

    @Override
    public boolean executeSO() {
        transferObject.signal = false;
        User user = (User) databaseBroker.findRecord(transferObject.generalEntity);
        if (user != null) {
            if (databaseBroker.deleteRecord(transferObject.generalEntity)) {
                transferObject.message = "User delete successful!";
                transferObject.signal = true;
            } else {
                transferObject.message = "User cannot be deleted!";
            }
        } else {
            transferObject.message = "User delete not successful beacause user doesn't exist!";
        }
        return transferObject.signal;
    }

}
