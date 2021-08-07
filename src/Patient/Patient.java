/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patient;

import Dietitian.DietPlan;
import Dietitian.Dietitian;
import Dietitian.DietitianAppointment;
import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.PersonDetails.Gender;
import Personnel.Role;
import Personnel.UserAccount;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ankur Bywar
 */
public class Patient implements Person {

    private PersonDetails patientDetails;
    private ArrayList<DietPlan> dietplans;
    private ArrayList<DietitianAppointment> dietitianAppointments;
    
    public Patient(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount account) {
        
        patientDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.PATIENT);
        dietplans = new ArrayList<DietPlan>();
        dietitianAppointments = new ArrayList<DietitianAppointment> ();
    }

    @Override
    public UserAccount getUserAccount() {
        return patientDetails.getUserAccount();
    }

    @Override
    public Role getRole() {
        return patientDetails.getRole();
    }
    
    public boolean scheduleDietitianAppointment(Dietitian dietitian, LocalDate date)
    {
        DietitianAppointment appointment = dietitian.scheduleAppointment(date, this);
        if (appointment != null)
        {
            dietitianAppointments.add(appointment);
            return true;
        }
        return false;
    }
    
    public void addDietplan(DietPlan dp){
        dietplans.add(dp);
    }

    public ArrayList<DietPlan> getDietplans() {
        return dietplans;
    }

    public ArrayList<DietitianAppointment> getDietitianAppointments() {
        return dietitianAppointments;
    }
}
