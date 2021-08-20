/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Counselor;

import Dietitian.DietPlan;
import Dietitian.DietitianAppointment;
import Dietitian.DietitianSchedule;
import Patient.Patient;
import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.PersonRatings;
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
 * @author preet
 */
public class Counselor implements Person{
    
    
    private PersonDetails counselorDetails;
    private CounselorSchedule counselorSchedule;
    private Set<String /* Appointment Date + time */> availability;
    private PersonRatings personRatings;
  
    
    public Counselor(
            String fullName, 
            LocalDate dob, 
            PersonDetails.Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount account,
            Icon icon,
            int organizationId) {
        counselorDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.COUNSELOR, icon, organizationId);
        counselorSchedule = new CounselorSchedule();
        this.availability = new HashSet<>();
        this.personRatings = new PersonRatings();
    }

    @Override
    public UserAccount getUserAccount() {
        return counselorDetails.getUserAccount();
    }

    @Override
    public Role getRole() {
        return counselorDetails.getRole();
    }
    
    public boolean isCounselorAvailable(LocalDate date, int timeHours) {
        return !availability.contains(date.toString() + timeHours);
    }    
    
    public CounselorAppointment scheduleAppointment (LocalDate d,Patient p, int timeHours,String restriction,String medication,String cheifcomplaint ){
        availability.add(d.toString() + timeHours);
        return counselorSchedule.ScheduleAppointment(d, p, this,restriction,medication,cheifcomplaint);
    }

    public CounselorSchedule getCounselorSchedule() {
        return counselorSchedule;
    }
    
    
    public void addCounsellingNote(Patient p, String CounsellingNote){    
        CounsellingNote dp= new CounsellingNote(p,this, CounsellingNote);
        p.addCounsellingNotes(dp);
    }

    @Override
    public String toString() {
        return "" + counselorDetails.getFullName();
    }

    @Override
    public PersonDetails getPersonDetails() {
        return counselorDetails;
    }

    @Override
    public int getOrganizationId() {
        return getPersonDetails().getOrganizationId();
    }

    @Override
    public void updateDetails(PersonDetails newCounselorDetails) {
        this.counselorDetails = newCounselorDetails;
    }

    @Override
    public void addRating(Rating rating) {
        personRatings.addRating(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return personRatings.getAllRatings();
    }
}
