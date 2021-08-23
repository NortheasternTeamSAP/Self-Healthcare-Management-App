/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

import Enterprise.Enterprise;
import Enterprise.EnterpriseType;
import Personnel.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ankur Bywar
 */
public class EnterpriseDirectory {
    GenericDirectory<Long, Enterprise> directory;
    
    public EnterpriseDirectory() {
        directory = new GenericDirectory<>();
    }
    
    public void addEnterprise(Enterprise enterprise) {
        directory.add(enterprise.getEnterpriseId(), enterprise);
    }
    
    public Enterprise getEnterprise(long id) {
        return directory.get(id);
    }
    
    public List<Enterprise> getAllEnterprise() {
        return directory.getAllValues();
    }
    
    public List<Enterprise> getAllValidEnterprise() {
        List<Enterprise> selectedEnterprise = new ArrayList<>();
        for (Enterprise enterprise : getAllEnterprise()) {
            if (enterprise.getEnterpriseType().equals(EnterpriseType.HEALTH_MANAGEMENT_APP)) {
                continue;
            }
            selectedEnterprise.add(enterprise);
        }
        return selectedEnterprise;
    }
    
    public List<Enterprise> getEnterpriseByType(EnterpriseType type) {
        List<Enterprise> selectedEnterprise = new ArrayList<>();
        for (Enterprise enterprise : getAllEnterprise()) {
            if (enterprise.getEnterpriseType().equals(type)) {
                selectedEnterprise.add(enterprise);
            }
        }
        return selectedEnterprise;
    }
}
