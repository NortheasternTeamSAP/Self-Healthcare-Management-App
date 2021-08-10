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

/**
 *
 * @author preet
 */
public class Dietitian implements Person{

    private PersonDetails dietitianDetails;
    private DietitianSchedule dietitianSchedule;
    
    public Dietitian(
            String fullName, 
            LocalDate dob, 
            PersonDetails.Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount account) {
        dietitianDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.DIETITIAN);
        dietitianSchedule = new DietitianSchedule();
    }

    @Override
    public UserAccount getUserAccount() {
        return dietitianDetails.getUserAccount();
    }

    @Override
    public Role getRole() {
        return dietitianDetails.getRole();
    }
    
    public DietitianAppointment scheduleAppointment (LocalDate d,Patient p ){
        return dietitianSchedule.ScheduleAppointment(d, p, this);
    }

    public DietitianSchedule getDietitianSchedule() {
        return dietitianSchedule;
    }
    
    
    public void addDietPlan(Patient p, ArrayList<String> mealplans){    
        DietPlan dp= new DietPlan(p,this, mealplans);
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
}
