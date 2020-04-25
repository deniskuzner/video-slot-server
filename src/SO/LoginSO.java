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
public class LoginSO extends AbstractGenericSO {

    TransferObject transferObject;
    User user;

    public boolean loginSO(TransferObject transferObject) {
        this.transferObject = transferObject;
        this.user = (User) transferObject.generalEntity;
        return templateExecuteSO();  
    }

    @Override
    public boolean executeSO() {
        List<GeneralEntity> result = databaseBroker.findRecord(user, "WHERE username = '" + user.getUsername()
                + "' and password='" + user.getPassword() + "'");
        if (result.size() > 0) {
            transferObject.message = "Login successful!";
            transferObject.generalEntity = result.get(0);
            transferObject.signal = true;
        } else {
            transferObject.message = "Login not successful!";
            transferObject.signal = false;
        }
        return true;
    }

}
