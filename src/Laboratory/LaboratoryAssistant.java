/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratory;

import Insurance.*;
import Doctor.*;
import DataStore.Appointment;
import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.PersonDetails.Gender;
import Personnel.Role;
import Personnel.UserAccount;
import Utils.Rating;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.Icon;

/**
 *
 * @author Ankur Bywar
 */
public class LaboratoryAssistant implements Person {
    private PersonDetails labAssistantDetails;
    
    private List<LaboratoryTestReport> pendingLabTests;
    private List<LaboratoryTestReport> completedLabTests;
    
    public LaboratoryAssistant(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber,
            Icon logoImage,
            UserAccount account) {
        
        labAssistantDetails = new PersonDetails(fullName, dob, gender, 
                address, phoneNumber, account, Role.LABASSISTANT, logoImage);
        pendingLabTests = new ArrayList<>();
        completedLabTests = new ArrayList<>();
    }
    
    public LaboratoryAssistant(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber,
            Icon logoImage,
            UserAccount account,
            long organizationId) {
        
        labAssistantDetails = new PersonDetails(fullName, dob, gender, 
                address, phoneNumber, account, Role.LABASSISTANT, logoImage, organizationId);
        pendingLabTests = new ArrayList<>();
        completedLabTests = new ArrayList<>();
    }
    
    public LaboratoryAssistant(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber,
            Icon logoImage,
            UserAccount account,
            long organizationId,
            String emailId) {
        
        labAssistantDetails = new PersonDetails(fullName, dob, gender, 
                address, phoneNumber, account, Role.LABASSISTANT, logoImage, organizationId, emailId);
        pendingLabTests = new ArrayList<>();
        completedLabTests = new ArrayList<>();
    }
    

    @Override
    public UserAccount getUserAccount() {
        return labAssistantDetails.getUserAccount();
    }

    @Override
    public Role getRole() {
        return labAssistantDetails.getRole();
    }

    public List<LaboratoryTestReport> getPendingLabTests() {
        return pendingLabTests;
    }

    public List<LaboratoryTestReport> getCompletedLabTests() {
        return completedLabTests;
    }

    @Override
    public PersonDetails getPersonDetails() {
        return labAssistantDetails;
    }
    
    public void assignLabTest(LaboratoryTestReport labTest) {
        pendingLabTests.add(labTest);
    }
    
    public void finishLabTest(LaboratoryTestReport labTest) {
        labTest.setLabTestStatus(LaboratoryTestReport.LabTestStatus.COMPLETED);
        pendingLabTests.remove(labTest);
        completedLabTests.add(labTest);
    }

    @Override
    public long getOrganizationId() {
        return getPersonDetails().getOrganizationId();
    }
    
    @Override
    public void updateDetails(PersonDetails newLabAssistantDetails) {
        this.labAssistantDetails = labAssistantDetails;
    }

    @Override
    public void addRating(Rating rating) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rating> getAllRatings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
