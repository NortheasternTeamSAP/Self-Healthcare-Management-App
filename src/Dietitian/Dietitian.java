/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dietitian;

import Patient.Patient;
import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.Role;
import Personnel.UserAccount;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Icon;

/**
 *
 * @author preet
 */
public class Dietitian implements Person{

    private PersonDetails dietitianDetails;
    private DietitianSchedule dietitianSchedule;
    private Set<String /* Appointment Date + time */> availability;
    
    public Dietitian(
            String fullName, 
            LocalDate dob, 
            PersonDetails.Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount account) {
        dietitianDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.DIETITIAN);
        dietitianSchedule = new DietitianSchedule();
        this.availability = new HashSet<>();
    }
    
    public Dietitian(
            String fullName, 
            LocalDate dob, 
            PersonDetails.Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount account,
            Icon icon,
            int organizationId) {
        dietitianDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.DIETITIAN,icon, organizationId);
        dietitianSchedule = new DietitianSchedule();
        this.availability = new HashSet<>();
    }

    @Override
    public UserAccount getUserAccount() {
        return dietitianDetails.getUserAccount();
    }

    @Override
    public Role getRole() {
        return dietitianDetails.getRole();
    }
    
    public boolean isDietitianAvailable(LocalDate date, int timeHours) {
        return !availability.contains(date.toString() + timeHours);
    }    
    
    public DietitianAppointment scheduleAppointment (LocalDate d,Patient p, int timeHours ,String r,String m,String c){
        availability.add(d.toString() + timeHours);
        return dietitianSchedule.ScheduleAppointment(d, p, this,r,m,c);
    }

    public DietitianSchedule getDietitianSchedule() {
        return dietitianSchedule;
    }
    
    
    public void addDietPlan(Patient p, ArrayList<String> mealplans,int c,int pro, int fiber, int fat){    
        DietPlan dp= new DietPlan(p,this, mealplans,c,fat, pro, fiber);
        p.addDietplan(dp);
    }

    public PersonDetails getDietitianDetails() {
        return dietitianDetails;
    }

    @Override
    public String toString() {
        return "" + dietitianDetails.getFullName();
    }

    @Override
    public PersonDetails getPersonDetails() {
        return dietitianDetails;
    }

    @Override
    public int getOrganizationId() {
        return getPersonDetails().getOrganizationId();
    }
}
