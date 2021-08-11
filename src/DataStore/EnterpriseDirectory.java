/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

import Enterprise.Enterprise;
import Personnel.Person;
import java.util.List;

/**
 *
 * @author Ankur Bywar
 */
public class EnterpriseDirectory {
    GenericDirectory<Integer, Enterprise> directory;
    
    public EnterpriseDirectory() {
        directory = new GenericDirectory<>();
    }
    
    public void addEnterprise(Enterprise enterprise) {
        directory.add(enterprise.getEnterpriseId(), enterprise);
    }
    
    public Enterprise getEnterprise(int id) {
        return directory.get(id);
    }
    
    public List<Enterprise> getAllEnterprise() {
        return directory.getAllValues();
    }
}