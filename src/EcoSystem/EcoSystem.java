/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem;

import DataStore.CredentialsManager;
import DataStore.GlobalUserDirectory;
import Personnel.Person;
import Personnel.Role;
import Personnel.SystemAdmin;
import Personnel.UserAccount;
import java.time.LocalDate;

/**
 *
 * @author Sravya
 */
public class EcoSystem {
    
    GlobalUserDirectory globalUserDirectory;
    CredentialsManager credentialsManager;
    
    
    public EcoSystem() {
        credentialsManager = new CredentialsManager();
        globalUserDirectory = new GlobalUserDirectory(credentialsManager);
        
        // create new system admin user
        UserAccount sysAdminUserAccount = new UserAccount("sysadmin", "sysadmin");
        Person sysAdmin = new SystemAdmin(null, null, null, null, null, sysAdminUserAccount);
        globalUserDirectory.createNewUser(sysAdmin);
    }
    
}
