/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.Role;
import Utils.ConsoleLogger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ankur Bywar
 * 
 * Directory for all the users (roles) in the system
 * 
 */
public class GlobalUserDirectory {
    GenericDirectory<String, Person> personDirectory;
    CredentialsManager credentialsManager;
    
    ConsoleLogger log = ConsoleLogger.getLogger();
    
    public GlobalUserDirectory(CredentialsManager credentialsManager) {
        personDirectory = new GenericDirectory<>();
        this.credentialsManager = credentialsManager;
    }
    
    public Person get(String username) {
        return personDirectory.get(username);
    }
    
    void add(Person person) {
        if (person == null) {
            log.error("Person is null. Cannot add to global user directory.");
            return;
        }
        
        if (person.getUserAccount() == null || 
                person.getUserAccount().getUsername() == null) {
            log.error("Person's useraccount OR username is null. "
                    + "Cannot add to global user directory.");
            return;
        }
        
        personDirectory.add(person.getUserAccount().getUsername(), person);
    }
    
    public void remove(Person person) {
        if (person == null) {
            log.error("Person is null. Cannot remove from global user directory.");
            return;
        } 
        
        if (person.getUserAccount() == null || 
                person.getUserAccount().getUsername() == null) {
            log.error("Person's useraccount OR username is null. "
                    + "Cannot remove from global user directory.");
            return;
        }        
        
        personDirectory.remove(person.getUserAccount().getUsername());
        credentialsManager.removeUserAccount(person.getUserAccount().getUsername());
    }
    
    // Use this method to create a new user after collecting user data from console
    public void createNewUser(Person person) {
        add(person);
        credentialsManager.createNewUserAccount(
                person.getUserAccount().getUsername(), 
                person.getUserAccount().getPassword());
    }
    
    public List<Person> getAllDoctors() {
        List<Person> doctors = new ArrayList<>();
        List<Person> allPersons = personDirectory.getAllValues();
        for (Person p : allPersons) {
            if (p.getRole().equals(Role.DOCTOR)) {
                doctors.add(p);
            }
        }
        return doctors;
    }
    
    public List<Person> getAllDietitians() {
        List<Person> dietitians = new ArrayList<>();
        List<Person> allPersons = personDirectory.getAllValues();
        for (Person p : allPersons) {
            if (p.getRole().equals(Role.DIETITIAN)) {
                dietitians.add(p);
            }
        }
        return dietitians;
    }  
    
       public List<Person> getAllFitnessTrainers() {
        List<Person> fitnessTrainers = new ArrayList<>();
        List<Person> allPersons = personDirectory.getAllValues();
        for (Person p : allPersons) {
            if (p.getRole().equals(Role.TRAINER)) {
                fitnessTrainers.add(p);
            }
        }
        return fitnessTrainers;
    }  
       
        public List<Person> getAllCounselors() {
        List<Person> counselors = new ArrayList<>();
        List<Person> allPersons = personDirectory.getAllValues();
        for (Person p : allPersons) {
            if (p.getRole().equals(Role.COUNSELOR)) {
                counselors.add(p);
            }
        }
        return counselors;
    } 
}
