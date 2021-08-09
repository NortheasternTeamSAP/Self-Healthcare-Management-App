/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem;

import DataStore.CredentialsManager;
import DataStore.GlobalUserDirectory;
import Dietitian.DietitianDirectory;
import Patient.Patient;
import Personnel.Person;
import Personnel.PersonDetails;
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
    DietitianDirectory dietitianDirectory;
    
    
    public EcoSystem() {
        credentialsManager = new CredentialsManager();
        globalUserDirectory = new GlobalUserDirectory(credentialsManager);
        dietitianDirectory=new DietitianDirectory();
        
        // create new system admin user
        UserAccount sysAdminUserAccount = new UserAccount("sysadmin", "sysadmin");
        Person sysAdmin = new SystemAdmin(null, null, null, null, null, sysAdminUserAccount);
        globalUserDirectory.createNewUser(sysAdmin);
    }

    public DietitianDirectory getDietitianDirectory() {
        return dietitianDirectory;
    }
    
    void example() {
        // How to get a user from globalUserDirectory
        Person person = globalUserDirectory.get("sysadmin");
        switch (person.getRole()) {
            case SYSTEM_ADMIN:
                SystemAdmin sysadmin = (SystemAdmin) person;
                // go to system admin workflow
                break;
            case PATIENT:
                Patient patient = (Patient) person;
                // go to patient workflow
                break;
            default:
                ;
        }
    }
    
}
