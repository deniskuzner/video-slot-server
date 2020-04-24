/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transfer;

import Domain.GeneralEntity;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class TransferObject implements Serializable {

    public GeneralEntity generalEntity;
    public String operation;
    public String message;
    public boolean signal;

}
