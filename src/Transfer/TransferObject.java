/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transfer;

import Domain.GeneralEntity;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author User
 */
public class TransferObject implements Serializable {

    public GeneralEntity generalEntity;
    public List<GeneralEntity> list;
    public String operation;
    public String message;
    public boolean signal;

    public <T extends GeneralEntity> List<T> castGeneralList(Class<T> subclass) {
        return list.stream().map(g -> (T) g).collect(Collectors.toList());
    }
}
