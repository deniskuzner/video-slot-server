/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import Transfer.TransferObject;

/**
 *
 * @author User
 */
public class CreateUserSO extends AbstractGenericSO {

    TransferObject transferObject;

    public boolean createUserSO(TransferObject transferObject) {
        this.transferObject = transferObject;
        return templateExecuteSO();
    }

    @Override
    public boolean executeSO() {
        if (databaseBroker.insertRecord(transferObject.generalEntity)) {
            transferObject.message = "Registration successful!";
            transferObject.signal = true;
            return true;
        }
        transferObject.message = "Registration not successful!";
        transferObject.signal = false;
        return false;
    }

}
