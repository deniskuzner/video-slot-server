/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import SO.CreateUserSO;
import SO.DeleteUserSO;
import SO.GetUsersSO;
import SO.LoginSO;
import SO.UpdateUserSO;
import Transfer.TransferObject;

/**
 *
 * @author User
 */
public class Controller {

    private static Controller instance;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public TransferObject login(TransferObject transferObject) throws Exception {
        new LoginSO().loginSO(transferObject);
        return transferObject;
    }

    public TransferObject createUser(TransferObject transferObject) {
        new CreateUserSO().createUserSO(transferObject);
        return transferObject;
    }
    
    public TransferObject updateUser(TransferObject transferObject) {
        new UpdateUserSO().updateUserSO(transferObject);
        return transferObject;
    }
    
    public TransferObject deleteUser(TransferObject transferObject) {
        new DeleteUserSO().deleteUserSO(transferObject);
        return transferObject;
    }

    public TransferObject getUsers(TransferObject transferObject) {
        new GetUsersSO().getUsersSO(transferObject);
        return transferObject;
    }

}
