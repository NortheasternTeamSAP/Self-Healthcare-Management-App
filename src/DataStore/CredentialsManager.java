/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

import Personnel.UserAccount;
import DataStore.GenericDirectory;
import Utils.ConsoleLogger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ankur Bywar
 * 
 * A data store containing username/password for all users(roles)
 * in the system. This will be used to validate user credentials
 * during login.
 */
public class CredentialsManager {
    
    GenericDirectory<String, UserAccount> directory;
    ConsoleLogger log = ConsoleLogger.getLogger();
    
    public CredentialsManager() {
        directory = new GenericDirectory<>();
    }
    
    public List<UserAccount> getUserAccountList() {
        return directory.getAllValues();
    }
    
    // Authenticates a user with the given username and password
    public boolean authenticateUser(String username, String password) {
        
        if (username == null) {
            log.error("Null username");
            return false;
        }
        
        if (password == null) {
            log.error("Null password");
            return false;
        }
        
        UserAccount userAccount = directory.get(username);
        if (userAccount == null) {
            log.error("Username " + userAccount + " does not exists in user accounts");
            return false;
        }
        
        if (!userAccount.getPassword().equals(password)) {
            log.error("Password mismatched for username " + userAccount);
            return false;
        }
        
        return true;
    }
    
    // Creates new entry for a user's credentials
    public void createNewUserAccount(String username, String password){
        
        if (username == null) {
            log.error("Null username");
            return;
        }
        
        if (password == null) {
            log.error("Null password");
            return;
        }
        
        UserAccount userAccount = new UserAccount(username, password);
        if (!isUserNameUnique(username)) {
            log.error("username already exist");
            return;
            
        }
        directory.add(username, userAccount);
        log.debug("Useraccount created for username " + userAccount);
    }
    
    // Checks if the username already exists in the system.
    // This should be used while a new user is being created.
    // Usernames must be unique across all users in the system since
    // usernames are also used as unique identifiers for every user
    public boolean isUserNameUnique(String username) {
        
        if (username == null) {
            log.error("Null username");
            return false;
        }
        
        UserAccount userAccount = directory.get(username);
        if (userAccount != null) {
            // username already exists
            return false;
        }
        return true;
    }
}
