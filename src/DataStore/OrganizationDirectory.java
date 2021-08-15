/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

import Organization.Organization;
import java.util.List;

/**
 *
 * @author Ankur Bywar
 */
public class OrganizationDirectory {
    GenericDirectory<Integer, Organization> directory;
    
    public OrganizationDirectory() {
        directory = new GenericDirectory<>();
    }
    
    public void addOrganization(Organization organization) {
        directory.add(organization.getOrganizationId(), organization);
    }
    
    public Organization getOrganization(int id) {
        return directory.get(id);
    }
    
    public List<Organization> getAllOrganization() {
        return directory.getAllValues();
    }
}
