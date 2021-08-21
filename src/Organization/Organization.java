/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organization;

import Enterprise.Enterprise;
import Personnel.Person;
import Utils.ConsoleLogger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ankur Bywar
 */
public abstract class Organization {
    
    protected String name;
    protected OrganizationType organizationType;
    protected Enterprise enterprise;
    protected int organizationId;
    Map<String, Person> employeesMap;
    static int countId = 1;
    LocalDate organizationCreationDate;
    
    ConsoleLogger log = ConsoleLogger.getLogger();
    
    
    public Organization(String name, Enterprise enterprise, OrganizationType organizationType, LocalDate organizationCreationDate) {
        this.name = name;
        this.enterprise = enterprise;
        this.organizationType = organizationType;
        this.employeesMap = new HashMap<>();
        this.organizationId = countId++;
        this.organizationCreationDate = organizationCreationDate;
    }
    
    public void addEmployee(Person p) {
        if (p == null) {
            log.error("Person is null. Cannot add to Organization");
            return;
        }
        
        if (employeesMap.containsKey(p.getUserAccount().getUsername())) {
            log.error("Person with id " + p.getUserAccount().getUsername() 
                    + " already exists in Organization with id " + organizationId);
            return;
        }
        
        employeesMap.put(p.getUserAccount().getUsername(), p);
    }
    
    public List<Person> getAllEmployees() {
        return new ArrayList<>(employeesMap.values());
    }
    
    public String getName() {
        return name;
    }

    public OrganizationType getOrganizationType() {
        return organizationType;
    }

    public int getOrganizationId() {
        return organizationId;
    }
    
    public Enterprise getEnterprise() {
        return enterprise;
    }
    
    public LocalDate getOrganizationCreationDate() {
        return this.organizationCreationDate;
    }
}
